package com.example.api.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequiredArgsConstructor
public class TestController {
//    @Autowired
//    private final UserRepository userRepository;

    @RequestMapping(method = RequestMethod.GET, value = "/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @HystrixCommand(fallbackMethod = "getTollRateBackup")
    @RequestMapping("/Hello")
    public String hello() {
        return "hello";
    }

    public String getTollRateBackup() {
        System.out.println("Fallback operation called");
        return "hello";
    }
    
    @RequestMapping(value = "/employee", method = RequestMethod.GET)
    @HystrixCommand(fallbackMethod = "getDataFallBack")
    public Employee firstPage() {

        System.out.println("firstPage");
        Employee emp = new Employee();
        emp.setName("emp1");
        emp.setDesignation("manager");
        emp.setEmpId("1");
        emp.setSalary(3000);

        if(emp.getName().equalsIgnoreCase("emp1"))
            throw new RuntimeException();
        return emp;
    }

    public Employee getDataFallBack() {

        System.out.println("getDataFallBack");
             Employee emp = new Employee();
        emp.setName("fallback-emp1");
        emp.setDesignation("fallback-manager");
        emp.setEmpId("fallback-1");
        emp.setSalary(3000);

        return emp;

    }

}