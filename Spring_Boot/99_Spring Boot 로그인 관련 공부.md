# Spring Boot 로그인 관련 공부

---

스프링에서 로그인, 권한 별 접근 기능 등을 구현하고자 한다면 **Spring Security**를 사용해야 한다. [start.spring.io](https://start.spring.io/) 해당 사이트에서 spring security를 추가해줘도 되고 수동으로 추가하기 위해서는 `pom.xml`이나 `build.gradle`의 `<dependencies>`에 관련 설정을 추가해주면 된다.



## Social Login (OAuth2.0)

`application.properties`파일에 다른 properties (구성)파일을 이식하고 싶다면 다음과 같이 작성한다.

```properties
spring.profiles.include=
```

