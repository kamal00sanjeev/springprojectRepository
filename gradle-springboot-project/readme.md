## Create a Gradle project

# First we need to create the sample project folder in our home directory and initialize the project:

$ mkdir gradle-springboot-project

$ cd gradle-springboot-project

$ gradle init  --type java-application

Next we need to apply the Spring Boot plugin and define the dependencies.

# To import project in eclipse, add below block
plugins {    
    id 'eclipse'
}

then hit this command

$ gradlew cleanEclipse eclipse

# To build and run

$ gradlew bootJar

$ java -jar build/libs/gradle-springboot-project.jar

OR

$ gradlew bootRun
