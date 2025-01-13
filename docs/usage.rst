Usage
=====

## Exemple of endpoint

### Get all ingredients

http://localhost:8080/ingredients/all

### Add an ingredient

POST /ingredients/add HTTP/1.1
Host: localhost:8080
Content-Type: application/x-www-form-urlencoded
Content-Length: 56

name=tomatoe2&type=vegetable&seasonal=true&seasons=7%2C3