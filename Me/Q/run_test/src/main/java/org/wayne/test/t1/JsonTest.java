package org.wayne.test.t1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @TODO:
 * @author: lwq
 */
@RestController
public class JsonTest {


    @RequestMapping("/t1")
    public String t1(@RequestBody User user){

        System.out.println(user.getName());
        return user.getName();
    }

}
