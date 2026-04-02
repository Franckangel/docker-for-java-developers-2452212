package com.example.blogdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Spring Data JPA Web Application for message blogging
 */
@SpringBootApplication
@RestController
public class Application {
    private static ConfigurableApplicationContext context;

    @Autowired
    private BlogRepository repository;

    /**
     * Get all Blog entities in the database.
     *
     * @return List of Blog Entities.
     */
    @GetMapping("/blogs")
    public List<Blog> getAll(){
        return repository.findAll();
    }

    /**
     * Create a Blog Message
     *
     * @param message string message
     * @return Created Blog Entity
     */
    @PostMapping("/blogs")
    public Blog create(@RequestBody String message) {

        return repository.save(new Blog().setMessage(message));
    }

    /**
     * Stop then entire application.
     * Not a normal method, here for demontration
     */
    @GetMapping("/stop")
    public void stop(){
        System.out.println("SHUTTING DOWN");
        context.close();
        return ;
    }
    public static void main(String[] args) {
        context = SpringApplication.run(Application.class, args);
    }


}

/*
    ORCHESTRATION

    Running related containers is called orchestration. It can be done manually (Docker CLI) or through tools such as:
    - Docker compose
    - Docker swarm
    - kubernetes

    Manual orchestration :

    * First we create a network called blog-network
    docker network create blog-network (Any containers included in this network can refer to each other by name)

    * Create an image for blog-backend
    docker build -t blog-backend .

    *Then run the postgres image to have a Postgres container
    docker run --name db \
            -network blog-network \
            -v db-data:/var/lib/postgresql/data \
            -p 5432:5432
            -e POSTGRES_DB=blogdemo \
            -e POSTGRES_PASSWORD=lmnop \
            -d postgres

    *Run the block-backend image as an app
    docker run --name app \
            -p 8080:8080 \
            -network blog-network \
            -e POSTGRES_HOST=db \
            -e POSTGRES_DB=blogdemo \
            -e PSOTGRES_PASSWORD=lmnop \
            -d blog-backend

    MANUAL ORCHESTRATION

    To manually monitor this containers
    docker logs db
    docker logs app
    curl localhost:8080/actuator/health

    To shut it down
    docker stop postgres-db
    docker stop blog-backend-app
    docker rm postgres-db
    docker network rm blog-network

    AUTOMATED ORCHESTRATION

    Configuration file: docker-compose.yml
    startup : docker-compose up (to start all the containers)
    Monitoring is provided by docker compose daemon


 */