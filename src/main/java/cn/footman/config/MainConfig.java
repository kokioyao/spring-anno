package cn.footman.config;


import cn.footman.bean.Person;
import cn.footman.service.BookService;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Controller;

//配置类=配置文件
@Configuration //告诉spring 这是一个配置类
//java8及以上
//@ComponentScan(value = "cn.footman",includeFilters = {
//        @ComponentScan.Filter(type = FilterType.ANNOTATION,classes = {Controller.class})
//},useDefaultFilters = false)
@ComponentScans(
        value = {
                @ComponentScan(value = "cn.footman",includeFilters = {
//                        @ComponentScan.Filter(type = FilterType.ANNOTATION,classes = {Controller.class})
//                        @ComponentScan.Filter(type=FilterType.ASSIGNABLE_TYPE,classes={BookService.class}),
                        @ComponentScan.Filter(type=FilterType.CUSTOM,classes={MyTypeFilter.class})
                },useDefaultFilters = false)
        }

)
//@ComponentScan  value:指定要扫描的包
//excludeFilters = Filter[] ：指定扫描的时候按照什么规则排除那些组件
//includeFilters = Filter[] ：指定扫描的时候只需要包含哪些组件
//FilterType.ANNOTATION：按照注解
//FilterType.ASSIGNABLE_TYPE：按照给定的类型；
//FilterType.ASPECTJ：使用ASPECTJ表达式
//FilterType.REGEX：使用正则指定
//FilterType.CUSTOM：使用自定义规则
public class MainConfig {

    //  给容器注册一个Bean，类型为返回值的类型，id默认为方法名
    @Bean
    public Person person(){
        return new Person("lisi",18);
    }
}
