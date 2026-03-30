package com.example.layerdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class LayerdemoApplication {

	@GetMapping
	public String sayHello() {
		return "Hello World";
	}
	public static void main(String[] args) {
		SpringApplication.run(LayerdemoApplication.class, args);
	}

}

/*

DOCKER BEST PRACITCES

IMAGE LAYERS

- Image layers are grouped by the action of each dockerfile instruction.
- A collection of files resulting from a Dockerfile instruction.

LAYERING BEST PRACTICES

- Import lightest (less layers) image possible
- Start with stable, verified, non-changing version images
- Only add files you need
- Order DockerFile from least to most frequently changed

 */
