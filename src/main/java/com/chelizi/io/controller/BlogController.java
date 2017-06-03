package com.chelizi.io.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.chelizi.io.bean.Blog;
import com.chelizi.io.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;


@RestController
@RequestMapping("/blog")
public class BlogController {


    @Autowired
    private BlogService blogService;



    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    @ResponseBody
    public String upload(@RequestBody MultipartFile file){
        if (!file.isEmpty()){
            try {
                BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(new File(file.getOriginalFilename())));
                out.write(file.getBytes());
                out.flush();
                out.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                return "upload failed";
            }catch (IOException e){
                return "upload failed";
            }
            return "upload success";
        }else {
            return "upload failed";
        }
    }


    @RequestMapping(value = "/id", method = RequestMethod.GET)
    public JSONObject getBlog(@RequestParam("id") Long id, HttpServletResponse response) {
        Blog blog = blogService.getBlogById(id);
        JSONObject json = (JSONObject) JSONObject.toJSON(blog);
        if (json != null){
            return json;
        }else{
            response.setStatus(403);
            JSONObject error = new JSONObject();
            error.put("error_code",40000);
            error.put("error_message","加载数据失败");
            return error;
        }
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public String queryAllBlog() {
        List<Blog> blogs = blogService.findAllData();
        if (blogs != null) {
            //查询
            String json = JSON.toJSONString(blogs, true);
            JSONObject result = new JSONObject();
            result.put("results", JSON.parse(json));
            return result.toString();
        } else {
            //请求失败
            JSONObject result = new JSONObject();
            result.put("result", "failed");
            return result.toJSONString();
        }
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public JSONObject save(@RequestBody Blog blog, HttpServletResponse response) {

        blog.setCreatedAt(String.valueOf(System.currentTimeMillis() / 1000));

        boolean isSave = blogService.save(blog);
        if (isSave) {
           return (JSONObject) JSONObject.toJSON(blog);
        } else {
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            JSONObject result = new JSONObject();
            result.put("error_code", "40001");
            result.put("error_message","保存失败");
            return result;
        }
    }

    @RequestMapping(value = "/page", method = RequestMethod.GET)
    public List<Blog> getEntryByParams(@RequestParam(value = "page", defaultValue = "0") Integer page,
                                       @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        Sort sort = new Sort(Direction.DESC, "id");
        Pageable pageable = new PageRequest(page, pageSize, sort);
        Page<Blog> pages = blogService.findAll(pageable);
        return pages.getContent();
    }

    /**
     * 删除一条数据
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public boolean delete(@RequestParam("id") Long id) {
        return blogService.delete(id);
    }
}
