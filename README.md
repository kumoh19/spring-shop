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
