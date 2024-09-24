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

### Build application
run ```./gradlew build```

### Deploy
run ```java -jar build/libs/blog-0.0.1-SNAPSHOT.jar```
choose the environment with ```-Dspring.profiles.active=dev``` or ```-Dspring.profiles.active=pdn```

## APIs
Check ```{host}/api/swagger-ui/index.html``` for more details

# For the future
Here are some potential features for the future of this API blog:
### Automated Content Curation:
* Scrape news sites daily.
* Implement an algorithm to select the most relevant news articles.
### AI-Powered Content Creation:
* Automatically generate blog content based on accurate news articles.
* Optimize content for SEO, including meta descriptions, tags, categories, and image ALT text.
* Generate images using AI tools like Flux.
### Content Interlinking and Enrichment:
* Utilize a trained RAG (Retrieval Augmented Generation) agent to link news articles with relevant internal content.
* Structure blog posts using Gutenberg blocks for seamless integration with WordPress.
### Automated Publishing:
* Automatically publish the generated and optimized blog posts to WordPress on a daily schedule.

The ultimate goal is to create a fully automated system that curates, generates, optimizes, and publishes high-quality blog content without manual intervention.
