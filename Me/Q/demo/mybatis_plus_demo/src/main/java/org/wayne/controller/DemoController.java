package org.wayne.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wayne.mapper.Blog;
import org.wayne.mapper.DemoMapper;

/**
 * @Description:
 * @author: lwq
 */
@RestController
@RequestMapping("/mybatis_plus")
public class DemoController {

    @Autowired
    DemoMapper demoMapper;

    @GetMapping("/")
    public void hello(){
        Blog blog = demoMapper.selectById(1);
        System.out.println(blog.getTitle());
    }
}
