package com.example.demo.config;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Component;

import com.example.demo.dao.DS;

@Component
public class BeanLifeCycle {

     /**
     * Beanコンテキスト生成後に呼び出される
     */
     @PostConstruct
     public void initAfterStartup() {

          //起動時の処理を記述
          System.out.println("initAfterStartup ");
     }

     /**
     * Beanコンテキスト破棄前に呼び出される
     */
     @PreDestroy
     public void cleanupBeforeExit() {
    	 DS.close();
          //停止時の処理を記述
          System.out.println(" cleanupBeforeExit ");
     }

}