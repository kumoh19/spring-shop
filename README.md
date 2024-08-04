# spring-shop

> **class**

**변수와 함수 보관하는 통**

class안에 있는 변수 함수 쓰려면?

- class를 복사해서 써야함
- class 복사본은 object
- var test = new Test(); //test는 object



> **class 쓰는 이유**

1. 자바를 선택한 이상 자바에선 항상 코딩을 클래스부터 써놓고 시작하기 때문에 어쩔 수 없이 강제로 써야함

2. 관련있는 변수, 함수를 한 곳에 보관할 수 있으니까 코드 정리해두기 좋음

3. 중요한 변수, 함수 원본을 안전하게 보관할 수 있음 

- object를 다른 말로 인스턴스라고 부르기도 함.

  클래스 안에 있는 변수는 field / attribute 라고 부르기도 하고

  클래스 안에 있는 함수는 method라고 부르기도 함.



> **constructor 문법**

 ```java
class Friend {
  String name = "kim";
  int age = 20;
  Friend(){
    this.name = "어쩌구";
  }
} 
 ```

- **object를 하나 만들 때 자동으로 실행**
- this는 새로 생성될 object를 뜻함.
- **this.name = “어쩌구”**
- this를 활용하면 name 변수의 초깃값을 맘대로 설정해줄 수도 있다.
- 즉, 위 코드는 새로 생성될 object의 name 변수에 "어쩌구" 넣으라는 소리

Q. 왜 씀?

**object를 뽑을 때 마다 매번 다른 값**을 변수에 집어넣어서 뽑을 수도 있다.

그니까 뽑을 때 마다 name변수에 "kim"도 넣고 "park"도 자유롭게 넣어서 뽑을 수 있음 

```java
class Friend {
  String name = "kim";
  int age = 20;
  Friend(String 이름){
    this.name = 이름;
  }
} 
```

이런식으로, 매번 가변적으로 설정할 부분에다가 파라미터를 추가하면 됌.



(참고1)

this는 생략해도 됨.

this없어도 그냥 this 생략되었겠거니 하면서 컴퓨터가 알아서 채워주고요 

 

(참고2)

파라미터는 원하는 만큼 많이 만들 수 있다.

 

(참고3)

슈퍼 울트라 스페셜 함수를 개발자 말로 constructor라고 부른다. 



> **객체지향 프로그래밍**

class와 object를 많이 활용해서 개짓거리 하는걸 객체지향 프로그래밍이라고 부르기도 하는데

객체지향 문법은 **길고 복잡한 코드** **정리도구**, **관리도구**일 뿐임

(1) class 만들고

(2) object 뽑는거

(3) constructor 쓰는거



> **배운거 정리**

1. 클래스는 변수 함수 보관함임

2. 클래스에 있던 변수함수를 사용하고 싶으면 new 클래스()로 object를 뽑으면 됨

그럼 클래스 안에 들어있던 변수 함수가 object로 복사됨. 

3. object 뽑을 때마다 각각 다른 변수값을 부여하고 싶으면 constructor를 만들면 됨.

클래스이름( ){ } 으로 함수만들면 그게 constructor임

그 안에 있는 코드는 object 뽑을 때 자동실행되므로 this 같은거 써서 변수의 초깃값을 맘대로 설정할 수도 있다.

심지어 함수 파라미터 문법도 사용가능

4. field, attribute, method, instance라는 용어 배움



> **매번 다른 상품 보내줘야하는거 아님?**

쇼핑몰은 맨날 다른 상품명이랑 가격을 보내야하는거 아님?

-> **템플릿 엔진**이라는걸 사용

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

둘 중 하나 고르면 된다. 

근데 실제 서비스 운영할거면 당연히 클라우드 서비스에서 호스팅 받는게 안정적이고 좋을 것이니 그러도록 하자.

 

AWS / Google Cloud / 마이크로소프트 Azure 이런것들이 있다.

대부분 카드등록하면 1년 무료 사용권을 주는데

AWS는 편하게 AWS RDS에서 데이터베이스호스팅 받으려면 요즘 IPv4 이용 명목으로 월 3달러 추가요금이 발생해서 Azure 써볼것.

(참고) Azure는 30일 경과 후엔 직접 종량제 요금제로 업그레이드버튼 눌러야 남은 11개월동안 무료로 이용이 가능함.

- **주의!!! 관리자 이름 sa 안됌**


 

> **AWS**

 

AWS를 좋아한다면 AWS RDS 이런거 써도 되는데

올해부터 RDS 사용시 퍼블릭 액세스를 "예"로 설정하면 IPv4 사용요금 명목으로 월 3달러 정도 청구되는 것으로 바뀌어서

요금을 피하고 싶다면 AWS EC2 들어가서 인스턴스 하나 만들어서 같은 VPC그룹에 집어넣고 SSH 키파일도 가져온 다음에

SSH 터널링으로 내 컴퓨터 -> EC2 -> RDS DB 이런 식으로 접속하거나

아니면 EC2 인스턴스에 직접 MySQL 설치해서 써야한다.

하지만 EC2에 설치하면 백업이나 모니터링 같은 것도 직접 해야하기 때문에 귀찮다.




 

> **DB 접속은**



DB 접속해서 데이터를 미리보고 싶으면

DBeaver같은 프로그램 설치하는게 가장 쉽고 빠르고 좋다.

![](C:\Users\User\AppData\Roaming\Typora\typora-user-images\image-20240803220539285.png)

- Server Host에 ![image-20240803220649811](C:\Users\User\AppData\Roaming\Typora\typora-user-images\image-20240803220649811.png)
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

update 해놓으면 변경사항반 반영되고 none 해놓으면 반영금지이다.

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



#### JPA

JPA가 뭐냐면 원래 관계형 데이터베이스는 SQL이라는 언어를 써서 데이터 입출력을해야하는데

그걸 좀 귀찮아하고 어려워하는 사람들이 많다. 

그래서 ORM이라는 라이브러리도 함께 설치해서 쓰는 경우가 많다.

 

ORM을 설치하면 SQL이 아니라 자바코드로 입출력을 해결할 수 있다.

테이블들을 클래스로 관리해서 타입체크도 되고 코드 재사용도 쉽고 여러 장점이 많다. 

이거 쓰다가 마음에 안들면 직접 SQL 작성도 가능하다.

 

실은 지금 설치하는 라이브러리를 Hibernate라고도 부르는데

JPA는 뭐냐면 자바에서의 ORM 표준 문법같은거고

JPA 문법을 개발자들이 쓰기쉽게 만들어준게 Hibernate라는 라이브러리이다.

이게 제일 인기있어서 이거 JPA 어쩌구 설치하면 자동으로 Hibernate가 함께 설치되는 것임

그래서 JPA랑 Hibernate를 대충 혼용해서 많이 부른다.



#### runtimeOnly

runtimeOnly라고 적으면 코드를 컴파일할 때는 필요없는 라이브러리니까 컴파일 할 땐 쓰지말라는 소리이다.

이 라이브러리 만든 사람이 runtimeOnly라고 사용해도 상관없게 만들어놔서 그럴 뿐이다.

 

컴파일이뭐냐면 자바코드는 원래 실행하기 전에 컴퓨터 친화적인 바이트 코드로 변환해야하는데 그걸 컴파일이라고 부른다.

그래서 이렇게 쓰면 컴파일 되는 시간을 절약할 수 있음.

그러기 싫으면 그냥 implementation 써도 상관없다.

 

그래서 코드를 실제로 실행할 때만 필요한 라이브러리들은 runtimeOnly만 적어놔도 되는데

DB입출력 도와주는 라이브러리나 로그 출력용 라이브러리들이 이런걸 써도 됨.

나머지는 쓸 일이 없음

 

아니면 반대로 compileOnly 라고 적으면 얘는 컴파일할 때만 쓰라는 뜻이다.

그러면 개발할 때만 잠깐 쓰고 실제 서버구동시 필요없는 라이브러리들은 compileOnly 집어넣으면 나중에 용량을 절약할 수 있다.

나중에 써볼 것인데 코드 자동완성을 시켜주는 Lombok 라이브러리는 그런 식으로 설치해서 쓰기도 한다.



![image-20240803225259329](C:\Users\User\AppData\Roaming\Typora\typora-user-images\image-20240803225259329.png)

성공.



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
3. @id 컬럼은 항상 하나 있는게 좋습니다. @GeneratedValue 넣는 것도 편함
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

아마 테이블 삭제하고 서버 재시작해야 테이블에 깔끔하게 반영이 잘되니까 처음에 만들 때 잘 만들어두면 되겠다. 

아니면 테이블 변경사항은 쌩으로 SQL 문법 짜는게 깔끔함.



결론 : 

1. 테이블 하나 필요하면 @Entity 붙은 class 하나 만들면 자동으로 생성가능
2. 그 class에 변수 만들면 그게 자동으로 컬럼으로 변함.
3. @id 컬럼은 항상 하나 있는게 좋습니다. @GeneratedValue 넣는 것도 편함
4. @Column 사용해서 컬럼마다 제약사항을 집어넣을 수 있다.



