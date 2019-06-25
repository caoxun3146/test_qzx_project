package com.qzx;

import com.qzx.dao.repostiory.AccountRepostiory;
import com.qzx.service.service.AccountService;
import com.qzx.dao.repostiory.SettlementRepostiory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountTests {
    @Autowired
    private AccountRepostiory authorRepostiory;
    @Autowired
    private SettlementRepostiory settlementRepostiory;
    private final static Logger logger = LoggerFactory.getLogger(AccountTests.class);

    @Autowired
    private AccountService accountService;

    @Test
    public void findAccountTest(){
      /*  Account account = authorRepostiory.findByTbId("1953957034");
        System.out.println("===================>>"+ JSON.toJSONString(account,true));
        System.out.println("===================>"+account.getId());

        RandomNumbers randomNumbers = new RandomNumbers();
        randomNumbers.getOrder();
        System.out.println("===================>"+randomNumbers.getOrder());*/

        /*Settlement settlement = settlementRepostiory.findByOrderId("802906840228447389");
        System.out.println("---------------" + settlement.getOrderId());*/
        accountService.deleteById(662407L);

    }
}
