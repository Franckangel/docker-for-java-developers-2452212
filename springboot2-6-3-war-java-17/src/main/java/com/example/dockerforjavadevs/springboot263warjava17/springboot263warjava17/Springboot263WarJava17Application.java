package com.example.dockerforjavadevs.springboot263warjava17.springboot263warjava17;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Springboot263WarJava17Application {

	public static void main(String[] args) {
		SpringApplication.run(Springboot263WarJava17Application.class, args);
	}

}


/*
	An IMAGE is an immutable artifact composed of files.
	It encapsulates a desired operating system, environment the application, and a run command
	we use tools for running an image

	Java does not execute directly from java source code. the source must be compiled
	into a byte code archive usually a java archive (jar)

	JAR files can be installed into the local maven m2 repository or shared to server registries like
	maven central, artifactory or nexus

	Likewise, the containerization ecosystem requires a pre-built application image.
	Images once built are installed into a local registry or could be shared to remote registries
	like Docker hub.

	The CONTAINER RUNTIME is a platform for running images, just as a JAVA RUNTIME is a platform for
	JARs

	In these course we will be using the docker container engine

	A CONTAINER is the actual instance of a running image on a container runtime. Just like a java object
	is an instantiation of a java class

	The primary tools to build an image are the Dockerfile and the docker build command.

	A DOCKERFILE is basically an image recipe card. it begins with a FROM <base image> and ends with a
	CMD or ENTRYPOINT command.
	FROM provide the builder a starting state followed by zero or more of the following:

	ADD and COPY commands contribute files from the local file system into the image.
	Additional FROMs are for creating multi-stage builds
	RUN executes a shell command within the image
	USER claims a user permission for proceeding instructions.
	VOLUME is used to associate a folder in a container with external data.
	WORKDIR changes the current working directory.

	CMD is the final command which usually launches the containerized application.

	Before actually invoking Docker files we need some overall understanding of the Docker engine.
	The DOCKER ENGINE is the docker toolbox. Two components are the :
	DOCKER DAEMON which is the docker runtime docker server
	and the
	DOCKER CLI the command line interface that invokes the services of the Docker Daemon.

	COMMANDS FOR CREATION

	docker build : creates an image
	docker run : instantiates an image as a container and runs it
	docker images : List images in local registry
	docker ps : List active containers
	docker exec : Run a command within a running container
	docker system : General Docker system inspection
	docker rmi : removes an image
	docker stop : Stop a running container
	docker rm : remove a stopped container
	docker system prune : Removes all unused or orphan images

 */
