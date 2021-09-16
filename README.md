# Microservices with Spring Boot.

Small test with microservices and Spring Boot.

Build using Gradle.

You can test it just by running each service(SpringBootApplication) separately.

**Endpoints:**

You can test the endpoints below using Postman or your favorite tool

Product endpoint:
```
(GET)    http://localhost:8001/product/details/101
```
Price endpoint:
```
(GET)    "http://localhost:8002/price/101
```
Inventory endpoint:
```
(GET)    http://localhost:8003/inventory/101
```
Exchange endpoint: Here the valid values to exchange the currency are "USD to YEN" and "USD to INR". Do not blame me! It is just a simple test. 
```
(GET)    http://localhost:8004/currexg/from/USD/to/YEN
```

