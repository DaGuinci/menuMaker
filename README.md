This application is designed to help you plan your weekly menus effortlessly. With just one step, you can access seasonal vegetables and easily organize your meals for the week.


# Development

## Setup

Need to have a Mysql server running, an existent database and .env file as :

```
DB_USER=user
DB_PASSWORD=password
```

## Launch

```bash
mvn spring-boot:run
```

## Use

Get ingredients:

```
http://localhost:8080/ingredients/all
```

Add ingredient:

## Doc

http://localhost:8080/swagger-ui/index.html