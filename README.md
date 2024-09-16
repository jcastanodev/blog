# Blog CRUD API Microservice
## Description
This API expose some services related with blog features...

## Usage
### Environment setup
Use ```application-dev.properties``` for local deploy and ```application-pdn.properties``` for production deploy.
#### Fields
* ```server.port``` means to port exposed for the application
* ```spring.datasource.driver-class-name``` means to what DB you want to use (recommended a Postgres database ```org.postgresql.Driver```)
* ```spring.datasource.url``` Url on host your DB (like: ```jdbc:postgresql://{DB_HOST}:{DB_PORT}/{DB_NAME}```
* ```spring.datasource.username``` User for authenticate in the DB
* ```spring.datasource.password``` Password for authenticate in the DB

## APIs
Check ```{host}/api/swagger-ui/index.html``` for more details
