package com.example.api;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Objects;

@SpringBootApplication
//@EnableEurekaClient
@EnableCircuitBreaker
public class Application {


    public static void main(String[] args) {
        createFileJava();
        moverFile();
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) throws IOException {
        return args -> {
            System.out.println("Let's inspect the beans provided by Spring Boot:");
            String[] beanNames = ctx.getBeanDefinitionNames();
            Arrays.sort(beanNames);
            for (String beanName : beanNames) {
//                System.out.println(beanName);
            }
        };
    }

    private static void moverFile() {
        File files = new File("api/src/main/java/com/example/api/controller/");
        Object[] pathnames = Arrays.stream(Objects.requireNonNull(files.list())).filter(s -> s.contains(".class")).toArray();
        if (pathnames.length > 0) {
            for (Object path : pathnames) {
                Path source = Paths.get(files.toString() + "/" + path);
                source.toFile().renameTo(new File(new File("").getAbsolutePath() + "/api/build/classes/java/main/com/example/api/controller/" + path));
//                    Path target = Paths.get();
//                    System.out.println(new File("").getAbsolutePath());
//                    Files.move(source, target, REPLACE_EXISTING);
            }
        }
    }

    private static void createFileJava() {
        try {

            String fileName = "api/src/main/java/com/example/api/controller/TestController.java";
            StringBuilder sb = new StringBuilder();
            Path pathToFile = Paths.get(fileName);
            System.out.println(pathToFile.toAbsolutePath());
            if (!pathToFile.toFile().isFile()) {
                File file = new File(fileName);
                fileName = file.getPath();
            }
            String str = "package com.example.api.controller;\n" +
                    "\n" +
                    "import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;\n" +
                    "import org.springframework.web.bind.annotation.RequestMethod;\n" +
                    "import org.springframework.web.bind.annotation.RestController;\n" +
                    "import org.springframework.web.bind.annotation.RequestMapping;\n" +
                    "\n" +
                    "@RestController\n" +
                    "public class TestController {\n" +
                    "\n" +
                    "    @RequestMapping(method = RequestMethod.GET, value = \"/\")\n" +
                    "    public String index() {\n" +
                    "        return \"Greetings from Spring Boot!\";\n" +
                    "    }\n" +
                    "\n" +
                    "    @HystrixCommand(fallbackMethod = \"getTollRateBackup\")\n" +
                    "    @RequestMapping(\"/Hello\")\n" +
                    "    public String hello() {\n" +
                    "        return \"hello\";\n" +
                    "    }\n" +
                    "\n" +
                    "    public String getTollRateBackup() {\n" +
                    "        System.out.println(\"Fallback operation called\");\n" +
                    "        return \"hello\";\n" +
                    "    }\n" +
                    "    \n" +
                    "    @RequestMapping(value = \"/employee\", method = RequestMethod.GET)\n" +
                    "    @HystrixCommand(fallbackMethod = \"getDataFallBack\")\n" +
                    "    public Employee firstPage() {\n" +
                    "\n" +
                    "        System.out.println(\"firstPage\");\n     " +
                    "   Employee emp = new Employee();\n" +
                    "        emp.setName(\"emp1\");\n" +
                    "        emp.setDesignation(\"manager\");\n" +
                    "        emp.setEmpId(\"1\");\n" +
                    "        emp.setSalary(3000);\n" +
                    "\n" +
                    "        if(emp.getName().equalsIgnoreCase(\"emp1\"))\n" +
                    "            throw new RuntimeException();\n" +
                    "        return emp;\n" +
                    "    }\n" +
                    "\n" +
                    "    public Employee getDataFallBack() {\n" +
                    "\n" +
                    "        System.out.println(\"getDataFallBack\");\n     " +
                    "        Employee emp = new Employee();\n" +
                    "        emp.setName(\"fallback-emp1\");\n" +
                    "        emp.setDesignation(\"fallback-manager\");\n" +
                    "        emp.setEmpId(\"fallback-1\");\n" +
                    "        emp.setSalary(3000);\n" +
                    "\n" +
                    "        return emp;\n" +
                    "\n" +
                    "    }\n" +
                    "\n" +
                    "}";
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
            writer.write(str);

            writer.close();
            JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
            compiler.run(null, null, null, String.valueOf(pathToFile));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

