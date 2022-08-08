# 🔥What is SpringBoot?

## 1. 🌱 Spring Framework
스프링 프레임워크는 자바에서 가장 많이 사용하는 프레임워크이다.
현재 우리나라의 '전자정부 표준 프레임워크'의 기반 기술로 채택되어 공공기관 웹 서비스를 개발할 때도 사용됨
스프링은 자바 언어를 이용해 엔터프라이즈급 개발을 편리하게 만들어주는 '오픈소스 경량급 애플리케이션 프레임워크'로 불림
즉, __자바로 애플리케이션을 개발하는 데 필요한 기능을 제공하고 쉽게 사용하도록 돕는 도구__
```
엔터프라이즈급 개발이란 기업 환경을 대상으로 하는 개발을 뜻함
네이버나 카카오톡 같은 데규모 데이터를 처리하는 환경을 엔터프라이즈(Enterprise)환경이라고 부름
스프링은 이 환경에 설계되어 있어 개발자는 애플리케이션을 개발할 때 많은 요소를 프레임워크에 위임하고 비즈니스 로직을 구현하는데 집중할 수 있음
```
스프링의 핵심가치는 즉,
__애플리케이션 개발에 필요한 기반을 제공해서 개발자가 비즈니스 로직 구현에만 집중할 수 있게끔 하는 것__

## 2. 🎛 제어 역전(IoC; Inversion of Control)
사용하려는 객체를 선언하고 해당 객체의 의존성을 생성한 후 객체에서 제공하는 기능을 사용
객체를 생성하고 사용하는 일련의 작업을 개발자가 직접 제어하는 구조
__But__, 제어 역전을 특징으로 하는 스프링은 기존 자바 개발 방식과 다르게 동작함
IoC를 적용한 환경에서는 사용할 객체를 직접 생성하지 않고 객체의 생명주기 관리를 외부(Spring Container, IoC Container)에 위임
__객체의 관리를 컨테이너에 맡겨 제어권이 넘어간 것__ 을 제어 역전이라고 부르며
이를 통해 의존성 주입(DI; Dependency Injection), 관점 지향 프로그래밍(AOP; Aspect_Oriented Programming) 등이 가능해짐

## 3. 💉 의존성 주입(DI; Dependency Injection)
제어 역전의 방법 중 하나로, 사용할 객체를 직접 생성하지 않고 외부 컨테이너가 생성한 객체를 주입받아 사용하는 방식

- 의존성을 주입받는 방법
    - 생성자를 통한 의존성 주입
    ```
    @RestController
    public class DIController{
        My Service myService;

        @Autowired
        public DIController(MyService myService){
            this.myService = myService;
        }

        @GetMapping("/di/hello")
        public String getHello(){
            return myService.getHello();
        }
    }
    ```
    - 필드 객체 선언을 통한 의존성 주입
    ```
    @RestController
    public class FieldInjectionController{
        @Autowired
        private MyService myService;
    }
    ```
    - setter 메서드를 통한 의존성 주입
    ```
    @RestController
    public class SetterInjectionController{
        MyService myService;

        @Autowired
        public void setMyService(MyService myService){
            this.myService = myService;
        }
    }
    ```

스프링에서는 @Autowired라는 어노테이션(Annotation)을 통해 의존성을 주입 가능

스프링 공식 문서에서는 생성자를 통해 의존성을 주입받는 방식을 권장
Becuase, __다른 방식과는 다르게 생성자를 통해 의존성을 주입받는 방식은__ 레퍼런스 객체 없이는 객체 초기화 불가능

## 4. 🧠 관점 지향 프로그래밍(AOP; Aspect_Oriented Programming)
관점을 기준으로 묶어 개발하는 방식
__관점(Aspect)__ 이란 어떤 기능을 구현할 때 그 기능을 __'핵심기능'__ 과 __'부가기능'__ 으로 구분해 각각을 하나의 관점으로 보는 것을 의미

- __핵심기능__
    비즈니스 로직을 구현하는 과정에서 비즈니스 로직이 처리하려는 목적 기능
    ```
    예를 들면, 클라이언트로부터 상품 정보 등록 요청으 ㄹ받아 데이터베이스에 저장하고 
    그 상품 정보를 조회하는 비즈니스 로직을 구현한다면 (1)상품 정보를 데이터베이스에 저장하고,
    (2)저장된 상품 정보데이터를 보여주는 코드가 핵심기능
    ```

- __부가기능__
비즈니스 로직에서 반복되는 동일한 기능

__부가기능을 하나의 공통 로직으로 처리하도록 모듈화해 삽입하는 방식을 AOP라고 함__

- 구현 방법
    - 컴파일 과정에 삽입
    - 바이트코드를 메모리에 로드하느 ㄴ과정에 삽입
    - 프락시 패턴을 이용

- 목적
    - OOP와 마찬가지로 모듈화해서 재사용 가능한 구성을 만드는 것
    - 모듈화된 객체를 편하게 적용할 수 있게 함으로써 개발자가 비즈니스 로직을 구현하는 데만 집중할 수 있게 도움

