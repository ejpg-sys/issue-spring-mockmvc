The MIT License (MIT)  
Copyright (c) 2024 Eduardo Junior Pereira Garcia  
 
https://github.com/ejpg-sys/issue-spring-mockmvc  


# Step by Step

# 1. Requests to Spring Boot WebService with cURL

1.1.: Request GET /hello **without** SESSION-KEY using cURL
> curl http://localhost:33884/hello  
>> response: {"status":401,"message":"401 UNAUTHORIZED"}  
[BDD APPROVED]  

1.2.: Request GET /hello **with wrong** SESSION-KEY using cURL
> curl --header "SESSION-KEY: 33885" http://localhost:33884/hello  
>> response: {"status":401,"message":"401 UNAUTHORIZED"}  
[BDD APPROVED]  

1.3.: Request GET /hello **with** SESSION-KEY using cURL
> curl --header "SESSION-KEY: 33884" http://localhost:33884/hello  
>> response: {"status":200,"message":"Hi, how are you ?"}  
[BDD APPROVED]  

1.4.: Request POST /authorization **without** SESSION-KEY using cURL
> curl --request POST \  
  --url http://localhost:33884/authorized \  
  --header 'Content-Type: application/json' \  
  --data '{"number": "33884"}'  
>> response: {"status":401,"message":"401 UNAUTHORIZED"}  
[BDD APPROVED]  

1.5.: Request POST /authorization **with** SESSION-KEY using cURL
> curl --request POST \  
  --url http://localhost:33884/authorized \  
  --header 'SESSION-KEY: 33884' \  
  --header 'Content-Type: application/json' \  
  --data '{"number": "33884"}'  
>> response: {"status":202,"message":"202 ACCEPTED"}  
[BDD APPROVED]  

1.6.: Request POST /authorization **with** SESSION-KEY **and wrong** GiftCard using cURL
> curl --request POST \  
  --url http://localhost:33884/authorized \  
  --header 'SESSION-KEY: 33884' \  
  --header 'Content-Type: application/json' \  
  --data '{"number": "33885"}'  
>> response: {"status":401,"message":"401 UNAUTHORIZED"}  
[BDD APPROVED]  


# 2. Requests to Spring Boot WebService with MockMvc

2.1.: Request GET /hello **without** SESSION-KEY using MockMvc  
> doHelloWithoutSessionKeyTest  
>> something is wrong: status expected 401 but was 200  
[BDD REPROVED]  

2.2.: Request GET /hello **with wrong** SESSION-KEY using MockMvc  
> doHelloWithWrongSessionKeyTest  
>> something is wrong: status expected 401 but was 200  
[BDD REPROVED]  

2.3.: Request GET /hello **with** SESSION-KEY using MockMvc  
> doHelloWithRightSessionKey  
>> it's all right: status expected 200 and response was 200  
[BDD APPROVED]  

2.4.: Request POST /authorization **without** SESSION-KEY using MockMvc  
> doAuthorizationWithoutSessionKey  
>> something is wrong: status expected 401 but was 202  
[BDD REPROVED]  

2.5.: Request POST /authorization **with** SESSION-KEY using MockMvc  
> doAuthorizationWithRightSessionKey  
>> it's all right:  status expected 202 and response was 202  
[BDD APPROVED]  

2.6.: Request POST /authorization **with** SESSION-KEY **and wrong** GiftCard using MockMvc  
> doAuthorizationWithRightSessionKeyAndWrongGiftCardNumber  
>> it's all right: status expected 401 and response was 401  
[BDD APPROVED]   
