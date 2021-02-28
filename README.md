## Spring Boot + MySQL (MyBatis) Project (+ Docker)

#### Spring Boot REST API & Docker 실습해보기

Spring Boot와 MySQL을 이용한 간단한 REST API 제작 후 Docker를 이용해 배포하기

<br/>

## 1. SpringApplication class

Spring Starter Project 생성 - New Spring Starter Project Dependencies로 Web - Spring Web만 선택 <br/>

Spring Boot Application을 실행시키는 클래스가 자동으로 생성됨

[![](https://img.shields.io/badge/class-Application%20run%20class-blue)](https://github.com/lgm1007/RESTAPIBoardPractice/blob/master/src/main/java/com/mycomp/exboard/RestapiBoardApplication.java) 

<br/>

## 2. Controller

Application이 정상적으로 동작하는지 확인해보는 getExample 메소드

데이터베이스 내 Book 개체의 속성값을 조회하는 getBookList 메소드

[![](https://img.shields.io/badge/controller-ExController-blue)](https://github.com/lgm1007/RESTAPIBoardPractice/blob/master/src/main/java/com/mycomp/exboard/controller/ExController.java)

<br/>

## 3. Dependency 추가

pom.xml 파일에 필요한 라이브러리 의존성 추가 (Maven 방식)

[![](https://img.shields.io/badge/xml-pom-blueviolet)](https://github.com/lgm1007/RESTAPIBoardPractice/blob/master/pom.xml)

<br/>

## 4. application.properties

application.properties 파일에 server.port 또는 datasource 정보들을 입력

```properties
spring.datasource.hikari.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.hikari.jdbc-url=jdbc:mysql://127.0.0.1:3306/DB(스키마)이름?useSSH=false
spring.datasource.hikari.username=유저이름
spring.datasource.hikari.password=비밀번호
```

<br/>

## 5. Mapper 파일 (DB 개체 당 1개)

DB의 개체 (현재 나의 데이터베이스에서는 Book)의 쿼리문을 Mapper 파일에서 정의,

mapper 태그의 namespace의 값은 다음에 추가할 Mapper 인터페이스의 패키지명+클래스명으로 지정해야 자동으로 Mapper XML 파일과 인터페이스를 매핑한다.

(현재 프로젝트에서는 com.mycomp.exboard.service.BookMapper)

[![](https://img.shields.io/badge/xml-book%20mapper-blueviolet)](https://github.com/lgm1007/RESTAPIBoardPractice/blob/master/src/main/resources/mapper/book-mapper.xml)

<br/>

## 6. Mapper 인터페이스 및 Service 클래스

Mapper 인터페이스에서 Mapper XML 파일에서의 select, insert, delete, update 태그 id 값과 일치한 메소드를 생성해야 해당 쿼리를 실행할 수 있다.

Service 클래스에서 해당 인터페이스를 주입해 각 쿼리 동작마다 메소드를 정의

[![](https://img.shields.io/badge/interface-BookMapper-violet)](https://github.com/lgm1007/RESTAPIBoardPractice/blob/master/src/main/java/com/mycomp/exboard/service/BookMapper.java)   [![](https://img.shields.io/badge/class-BookService-blue)](https://github.com/lgm1007/RESTAPIBoardPractice/blob/master/src/main/java/com/mycomp/exboard/service/BookService.java)

<br/>

## 7. DataSourceConfig 클래스

application.properties에서 DataSource 접속 정보를 읽어와 SqlSessionFactory, SqlSessionTemplate를 설정하는 역할을 함.

**@ComponentScan** = @Component 및 streotype(@Service, @Repository, @Controller) 어노테이션이 부여된 Class들을 자동으로 스캔하여 Bean으로 등록해주는 역할

**@MapperScan** = 지정된 패키지에서 Mapper를 자동 스캔, 현 프로젝트에서는 Mapper 인터페이스를 스캔

[![](https://img.shields.io/badge/class-DataSourceConfig-blue)](https://github.com/lgm1007/RESTAPIBoardPractice/blob/master/src/main/java/com/mycomp/exboard/config/DataSourceConfig.java)

