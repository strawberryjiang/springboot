package com.atguigu.boot;

import ch.qos.logback.core.db.DBHelper;
import com.atguigu.boot.bean.Pet;
import com.atguigu.boot.bean.User;
import com.atguigu.boot.config.MyConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcProperties;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
//@SpringBootConfiguration
//@EnableAutoConfiguration
//@ComponentScan("com.atguigu.boot")
public class MainApplication {

    public static void main(String[] args) {
        //1、返回我们IOC容器
        ConfigurableApplicationContext applicationContext = SpringApplication.run(MainApplication.class, args);

        //2、查看容器里面的组件
//        String[] names = applicationContext.getBeanDefinitionNames();
//        for (String name : names) {
//            System.out.println(name);
//        }
//
//        int beanDefinitionCount = run.getBeanDefinitionCount();
//        System.out.println(beanDefinitionCount);
//
//        String[] beanNamesForType = run.getBeanNamesForType(CacheAspectSupport.class);
//        System.out.println("======" + beanNamesForType.length);

        //3、从容器中获取组件
        String[] beanNamesForType1 = applicationContext.getBeanNamesForType(WebMvcProperties.class);
        System.out.println("======" + beanNamesForType1.length);

        //4、com.atguigu.boot.config.MyConfig$$EnhancerBySpringCGLIB$$51f1e1ca@1654a892
        MyConfig bean = applicationContext.getBean(MyConfig.class);
        System.out.println(bean);

        //如果@Configuration(proxyBeanMethods = true)代理对象调用方法,
        //SpringBoot总会检查容器中是否有这个组件。保持组件单实例
        //如果@Configuration(proxyBeanMethods = false),不是单实例
        User user = bean.user01();
        User user1 = bean.user01();
        System.out.println(user == user1);

        User user01 = applicationContext.getBean("user01", User.class);
        Pet tom = applicationContext.getBean("tom", Pet.class);
        System.out.println("用户的宠物：" + (user01.getPet() == tom));


        //5、获取组件
        String[] beanNamesForType = applicationContext.getBeanNamesForType(User.class);
        System.out.println("======");
        for (String s : beanNamesForType) {
            System.out.println(s);
        }

        DBHelper bean1 = applicationContext.getBean(DBHelper.class);
        System.out.println(bean1);

    }
}
