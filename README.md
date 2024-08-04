# spring-shop

> **객체지향 프로그래밍**

class와 object를 많이 활용해서 개짓거리 하는걸 객체지향 프로그래밍이라고 부르기도 하는데

객체지향 문법은 **길고 복잡한 코드** **정리도구**, **관리도구**일 뿐임

(1) class 만들고

(2) object 뽑는거

(3) constructor 쓰는거



> **정리**

1. 클래스는 변수 함수 보관함임

2. 클래스에 있던 변수함수를 사용하고 싶으면 new 클래스()로 object를 뽑으면 됨

그럼 클래스 안에 들어있던 변수 함수가 object로 복사됨. 

3. object 뽑을 때마다 각각 다른 변수값을 부여하고 싶으면 constructor를 만들면 됨.

클래스이름( ){ } 으로 함수만들면 그게 constructor임

그 안에 있는 코드는 object 뽑을 때 자동실행되므로 this 같은거 써서 변수의 초깃값을 맘대로 설정할 수도 있다.

심지어 함수 파라미터 문법도 사용가능

4. field, attribute, method, instance라는 용어 배움



> **템플릿 엔진**

Q. 쇼핑몰은 매번 다른 상품명이랑 가격을 보내야하는거 아님?

- 서버의 데이터를 html에 동적으로 삽입해야함
- **템플릿 엔진**이라는걸 사용

템플릿 엔진은 서버의 데이터를 html에 집어넣어주는걸 도와주는 외부 라이브러리




> **Thymeleaf로 서버데이터 html에 박아서 보내주려면**

서버에서 특정 html 파일에 서버의 데이터를 집어넣을 수 있는데 어떻게 하냐면

1. 서버 API 함수의 파라미터에 Model model 넣고
2. API안에서 model.addAttribute("작명", 전송할데이터)
3. html 태그에 th:text="${작명}"

```java
@GetMapping("/list")
String list(Model model) {
 model.addAttribute("name", "홍길동");
 return "list.html";
} 
```

1. 서버 API 함수의 파라미터에 Model model 넣고
2. model.addAttribute("작명", 전송할데이터) 쓰면 된다.

```html
(list.html)

<h4 th:text="${name}">바지</h4> 
```

3. html 태그에 th:text="${작명}" 이라고 써야 서버에서 보낸 데이터 출력이 가능.

그래서 위 html을 유저에게 전송할 땐 앞으로 <h4>태그에 "홍길동"이 박혀서 전송됨.

Thymeleaf 문법을 사용하고 싶으면 templates 폴더로 html 파일을 옮겨야 잘 동작한다.



> **데이터베이스 호스팅받기**

1. 하드디스크에 직접 MySQL 설치

2. AWS 같은 클라우드 서비스가서 MySQL 호스팅을 받음

실제 서비스 운영할거면 클라우드 서비스에서 호스팅 받는게 안정적이고 좋을 것.

 

AWS / Google Cloud / 마이크로소프트 Azure 등등 있는데

대부분 카드등록하면 1년 무료 사용권을 준다.

(참고) Azure는 30일 경과 후엔 직접 종량제 요금제로 업그레이드버튼 눌러야 남은 11개월동안 무료로 이용이 가능함.

- **주의!!! 관리자 이름 sa 안됌** (계속 배포할때 에러나서 개고생했다..)




 

> **DB 접속**



DB 접속해서 데이터를 미리보고 싶으면

DBeaver같은 프로그램 설치하는게 가장 쉽고 빠르고 좋다.

![image-20240804122742892](C:\Users\User\AppData\Roaming\Typora\typora-user-images\image-20240804122742892.png)

- Server Host에

![image-20240804122710134](C:\Users\User\AppData\Roaming\Typora\typora-user-images\image-20240804122710134.png)

- Authentication에 azure에서 만든 db에 등록한 서버 관리자 이름과 비번 입력

- 주의) 1년 무료 사용 기간 전에 삭제




 

> **JPA와 MySQL 접속용 라이브러리 설치**

```bash
dependencies {
  runtimeOnly 'com.mysql:mysql-connector-j'
  implementation 'org.springframework.boot:spring-boot-starter-data-jpa'
}
```

build.gradle에 위 코드 추가

```bash
spring.datasource.url=jdbc:mysql://호스팅받은곳엔드포인트주소/만든database이름
spring.datasource.username=DB접속아이디
spring.datasource.password=DB접속비번
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

spring.jpa.properties.hibernate.show_sql=true
spring.jpa.hibernate.ddl-auto=update 
```

application.properties 파일(설정, 환경변수 보관파일)에 추가해두면 서버에서 MySQL 데이터베이스에 접속이 가능하다.

이제 서버띄울 때 Hikari pool 어쩌구 안내메세지가 뜨면 DB접속 잘 되었다는 뜻이다.

 

\- 위의 4줄은 접속할 DB정보 입력하는 곳이고

\- show_sql=true는 DB입출력시 SQL을 따로 실행창에 출력할지 여부

\- ddl-auto=update는 코드짜서 테이블 생성이나 수정시 그걸 자동으로 DB에도 반영할지.

update 해놓으면 변경사항만 반영되고 none 해놓으면 반영금지이다.

none이 실제 서비스 운영할 땐 안정적인데 update도 나쁘지는 않다.



ORM쓰면

장점

- java 코드로 데이터 입출력 가능
- 뽑은 데이터 타입체크도 편함
- 데이터를 java 스타일로 관리가능

단점

- 데이터 입출력 속도 저하



JPA: Java의 ORM 표준 문법

Hibernate: JPA의 구현체. JPA 쓰기좋게 구현한거



#### JPA와 Hibernate

JPA(Java Persistence API)는 자바에서 ORM(Object-Relational Mapping)을 위한 표준 인터페이스입니다. 관계형 데이터베이스에서 데이터를 입출력할 때, SQL을 직접 작성하는 대신 자바 코드로 작업할 수 있게 해줍니다. 이를 통해 개발자들은 테이블을 클래스로 관리하고, 타입 체크 및 코드 재사용이 용이해지는 등의 장점을 누릴 수 있다.

ORM 라이브러리를 사용하면 SQL 대신 자바 코드로 데이터베이스 작업을 할 수 있다. 이로 인해 개발이 쉬워지고, 코드의 유지보수성과 재사용성이 높아진다. 필요할 경우 직접 SQL을 작성하는 것도 가능하다.

Hibernate는 가장 인기 있는 JPA 구현체로, JPA 표준을 사용하기 쉽게 만들어준다. JPA를 설치하면 Hibernate가 함께 설치되는 경우가 많아, 두 용어를 혼용해서 사용하는 경우가 많다. JPA는 표준 인터페이스를 제공하고, Hibernate는 그 표준을 구현한 라이브러리이다.



### `runtimeOnly`와 `compileOnly` 

#### `runtimeOnly`

- **컴파일 시 불필요**: `runtimeOnly`는 컴파일 시 필요 없는 라이브러리를 지정. 컴파일 시간을 절약할 수 있다.
- **컴파일이란?**: 자바 코드를 실행하기 전에 컴퓨터가 이해할 수 있는 바이트 코드로 변환하는 과정.
- **사용 예**: DB 입출력 도우미나 로그 출력 라이브러리는 `runtimeOnly`로 설정할 수 있다.
- **유연성**: 라이브러리 제작자가 `runtimeOnly`로 사용해도 문제없게 설계했다. 싫으면`implementation`을 사용해도 상관없다.

#### `compileOnly`

- **런타임 시 불필요**: `compileOnly`는 컴파일할 때만 필요한 라이브러리를 지정한다. 실제 실행 시 필요하지 않다.
- **사용 예**: 개발 시 코드 자동완성을 도와주는 Lombok 같은 라이브러리는 `compileOnly`로 설정할 수 있다.
- **장점**: 실행 시 불필요한 라이브러리를 제외하여 용량을 절약할 수 있다.

**요약**: `runtimeOnly`는 실행 시에만 필요한 라이브러리, `compileOnly`는 컴파일 시에만 필요한 라이브러리를 지정하여 각각의 상황에 맞게 효율적으로 라이브러리를 관리할 수 있다.





테이블 만들고 싶으면

JPA에선 @Entity 클래스 만들면 자동생성된다.

```
@GeneratedValue(strategy = GenerationType.IDENTITY)
```

- Auto increment 기능



@Entity 클래스만들고 서버 시작하면 table만들어진다.(DBeaver에서 확인가능)

결론 : 

1. 테이블 하나 필요하면 @Entity 붙은 class 하나 만들면 자동으로 생성가능
2. 그 class에 변수 만들면 그게 자동으로 컬럼으로 변한다.
3. @id 컬럼은 항상 하나 있는게 좋다. @GeneratedValue 넣는 것도 편함
4. @Column 사용해서 컬럼마다 제약사항을 집어넣을 수 있다.



**트러블슈팅**

- azure에 만든 mysql서버를 dbeaver에서 insert할때 에러.

org.jkiss.dbeaver.model.sql.DBSQLException: SQL Error [1044] [42000]: Access denied for user 'hodu'@'%' to database '**mysql**'

1. mysql이 아닌 shop database에서 작업중이므로 use shop;

2. 사용자 'hodu'에게 'shop' 데이터베이스에 대한 접근 권한을 부여.

```sql
GRANT ALL PRIVILEGES ON shop.* TO 'hodu'@'%';
FLUSH PRIVILEGES; ###MySQL 서버를 다시 로드
```

 

 

> **제약조건 @Column으로 부여가능**

 

컬럼마다 추가 제약사항들을 집어넣을 수 있다.

```
@Column(nullable = false) 
```

컬럼에 데이터가 비어있을 경우 저장을 막아줌.

 

```
@Column(unique = true)
```

다른 행들에 없는 유니크한 데이터만 저장할 수 있다.

그니까 앞으로 유니크하지 않은게 들어오면 저장 막아주고 에러남

회원 아이디나 이메일 저장할 때 쓰는게 어떨까..

 

```
@Column(columnDefinition = "TEXT") 
```

String만 달랑 집어넣어두면 255자까지 저장이 가능한데

매우 긴 문자를 저장하고 싶으면 MySQL같은 경우 text 타입같은게 있는데 그런거 쓰고 싶으면 여기다가 적으면 된다.

 

참고로 컬럼 이걸 수정을 했는데 이건 서버재시작한다고 바로 DB에 반영되지 않을 수 있다. 

아마 테이블 삭제하고 서버 재시작해야 테이블에 깔끔하게 반영이 잘되니까 처음에 만들 때 잘 만들어야함.

아니면 테이블 변경사항은 쌩으로 SQL 문법 짜는게 깔끔함.



결론 : 

1. 테이블 하나 필요하면 @Entity 붙은 class 하나 만들면 자동으로 생성가능
2. 그 class에 변수 만들면 그게 자동으로 컬럼으로 변함.
3. @id 컬럼은 항상 하나 있는게 좋습니다. @GeneratedValue 넣는 것도 편함
4. @Column 사용해서 컬럼마다 제약사항을 집어넣을 수 있다.



