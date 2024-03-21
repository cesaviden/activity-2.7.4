package main.source;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import main.java.Task;
import main.java.TaskService;
import java.util.ArrayList;
import java.util.List;

@Configuration
@ComponentScan("main.java")
@PropertySource("src/main/source/application.properties")
public class AppConfig {
	
	@Value("${description1}")
    private String description1;
    
    @Value("${owner1}")
    private String owner1;
    
    @Value("${description2}")
    private String description2;
    
    @Value("${owner2}")
    private String owner2;
	
    @Bean
    public Task task1() {
        return new Task("Complete the report", "Minghai Chen");
    }

    @Bean
    public Task task2() {
        return new Task("Review the presentation", "César Suárez");
    }

    @Bean
    public List<Task> taskList() {
        List<Task> tasks = new ArrayList<>();
        tasks.add(task1());
        tasks.add(task2());
        return tasks;
    }

    @Bean
    public TaskService taskService() {
        TaskService taskService = new TaskService();
        taskService.setTasks(taskList());
        return taskService;
    }
}
