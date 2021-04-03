package org.mybatis.example.mapper;

import org.mybatis.example.Blog;

/**
 * @TODO:   配置文件中引入xml mapper.java的目录并不要求一致
 * @author: lwq
 */
public interface BlogMapper {
    Blog selectBlog(int id);
}
