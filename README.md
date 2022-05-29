# bonz-house-manage

## Abstract
Instead of applying MVC structure to build the web application, I adopt RPC structure (distributed microservices)
to develop my web application in order to accommodate larger scale requests

## api-server
Receive data from frontend using GraphQL/RESTful interface (controller package)
and communicate with dubbo-server (service package).

When we inject service instance (as a consumer) from dubbo-server, we would add @Reference annotation on it 
and assign the version to it (subscribe from registry), which implements the RPC design pattern and distribution framework
to maximize the extents of disintegration between each layers
## dubbo-server
Established a provider and register service into registry center, here I adopt zookeeper as a registry center.

Depending on the requirements, I created different children maven projects to develop the backend application

Here the application driver is toward the registry server not an aspect of web application.


## Project display

### add house resources (web background)
![add](https://github-zen-project.s3.amazonaws.com/house-images-desc/add+house.jpeg "add")

### house resources list (web background)
![page list](https://github-zen-project.s3.amazonaws.com/house-images-desc/backend+house+list+page.jpeg "pagination")

### front page (web application)
![front page](https://github-zen-project.s3.amazonaws.com/house-images-desc/frontend+front+page.jpeg "front page")

### house resources list (web application)
![page list](https://github-zen-project.s3.amazonaws.com/house-images-desc/frontend+house+list+page.jpeg "house list")

### map API
![map](https://github-zen-project.s3.amazonaws.com/house-images-desc/map+api+1.jpeg "map")

### map zoom in
![zoom in](https://github-zen-project.s3.amazonaws.com/house-images-desc/map+zoom+in.jpeg "zoom in")

### map zoom out
![zoom out](https://github-zen-project.s3.amazonaws.com/house-images-desc/map+zoom+out.jpeg "zoom out")

