# Url Shortner Application 
- Snowflake unique Id generator
- Eureka Service Registry
- Api Gateway

## Ports
- Core Application : 8080
- API Gateway : 8081
- Registry : 8761
- DB : 3306

## End points
- /short
    - send long url in Request Body
    - `{"longUrl":"https://www.xyz.com"}`
- /redirect?param=shorturl
    - `/redirect?param=shorturl`

## To-Do
- Implement Cache
- Testing
