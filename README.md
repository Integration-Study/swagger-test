# swagger-test

### 목표
- Swagger를 이용하여 API 문서를 작성하면서, 기존의 스프링 부트만을 사용하는 것처럼 최대한 비즈니스 로직에 영향을 주지 않는다.

### 개발 환경
- Spring Boot 3.3.4
- Java 17

### 주요 의존성
```text
dependencies {
    ...
    implementation 'org.springdoc:springdoc-openapi-starter-webmvc-ui:2.0.2'
}
```
### Swagger 설정
- [SwaggerConfig.java](https://github.com/Integration-Study/swagger-test/blob/f638f3fa280e5a41d1836ecd5154f92495c529f8/src/main/java/demo/swaggertest/config/SwaggerConfig.java) 참고

## V1 ( Controller에 Swagger 적용 )
### 코드
- [TestControllerV1.java](https://github.com/Integration-Study/swagger-test/blob/bdc42d6f258e72a40ba3a9e80dbc01d22c993690/src/main/java/demo/swaggertest/v1/controller/TestControllerV1.java#L21-L63)
- 기존의 컨트롤러 코드를 그대로 사용하면서, Swagger를 적용한다.
- 그 결과 컨트롤러 코드 위에 어노테이션이 3~5줄 정도 추가되면서, 가독성을 낮추는 효과가 발생

## V2 ( Controller와 Swagger 분리 )
### Swagge 관련 코드
- [TestControllerV2Docs.java](https://github.com/Integration-Study/swagger-test/blob/bdc42d6f258e72a40ba3a9e80dbc01d22c993690/src/main/java/demo/swaggertest/v2/controller/TestControllerV2Docs.java#L14-L34)
- 기존의 컨트롤러에서 Swagger와 관련된 어노테이션을 전부 interface로 분리한다.
### Controller 코드
- [TestControllerV2.java](https://github.com/Integration-Study/swagger-test/blob/bdc42d6f258e72a40ba3a9e80dbc01d22c993690/src/main/java/demo/swaggertest/v2/controller/TestV2Controller.java#L17)
- 그 결과 컨트롤러 코드는 비즈니스 로직에만 집중하게 되며, Swagger와 관련된 코드는 별도의 파일로 분리되어 가독성이 높아진다.
- 위의 interface를 구현한 컨트롤러 코드에서는 **implements TestControllerV2Docs**만 추가하면, Swagger 관련 코드를 하나도 작성하지 않아도 된다.
