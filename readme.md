# JPA Study

## Stack
|||
|------|---|
|Back-end|Spring Boot 3.3|
|  |  Hibernate + jpa|
|  |  Spring-data-jpa|
| DB | (test) mem h2 |
|  |  MYSQL|
| template engine |  Thymeleaf|


## 목적
1. Entity 와 RDBMS 연관관계 매핑
2. JPA의 성능 문제 해결  
    (1) 지연로딩 LAZY_MODE  
    (2) fetch join  
3. 웹 계층과 도메인 계층 분리
    (1) DTO or 새로운 클래스를 이용한 API 스펙 변경시 유지보수 용이
4. 엔티티 직접 노출 x
    (1) Dto로 변환!!
    (2) 생성자 호출시 property에러 -> getter 확인 
5. 컬렉션 조회
    (1) 컬렉션은 지연 로딩으로 조회한다
    (2) 컬렉션 패치 조인 2개 이상은 사용하면 안됨
    (3) 사용하더라도 1개, 페이징 사용못함!
6. DTO 직접 조회
-- --
### 다음 목표
* spring-data-jpa
* Querydsl
* ecache