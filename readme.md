# JPA Study

##Stack
|||
|------|---|
|Back-end|Spring Boot 3.3|
|  |  Hibernate + jpa|
|  |  Spring-data-jpa|
| DB | (test) mem h2 |
|  |  MYSQL|
| template engine |  Thymeleaf|


##목적
1. Entity 와 RDBMS 연관관계 매핑
2. JPA의 성능 문제 해결  
    (1) 지연로딩 LAZY_MODE  
    (2) fetch join  
3. 웹 계층과 도메인 계층 분리
    (1) DTO or 새로운 클래스를 이용한 API 스펙 변경시 유지보수 용이

-- --
###다음 목표
* spring-data-jpa
* Querydsl