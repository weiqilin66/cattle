package org.wayne.thief;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.wayne.thief.service.ICardService;

/**
 * @Description:
 * @author: lwq
 */
@SpringBootTest(classes = {ThiefApp.class})
@RunWith(SpringRunner.class)
public class SelTest {

    @Autowired
    ICardService cardService;
    @Test
    public void t1() throws InterruptedException {
        System.out.println(1);
        cardService.crawl();
    }


}
