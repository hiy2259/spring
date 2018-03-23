## 개요
스프링 중급 1일차 문서

## 교육 내용
### 교육자료 다운로드 위치 및 파일
* [블로그](https://blog.naver.com/vega2k)
    * 2018+KOSTA+교육과정+Learning+Object+기반_스프링프레임워크중급.pdf
    * AspectJ포인트컷표현식.pdf
    * MyBatis-3-User-Guide_ko.pdf
    * SpringWebPrj.zip

### Mybatis
#### mapper.xml
* SQL 문 포함
#### sqlMapConfig.xml
* MyBatis config file
* DataSource 설정 -> Spring bean confg.xml
* VO(Value Object) 클래스 정보
* log4j2(SQL logging)
#### JDK 1.9 버전
#### 참고사항
* JDK 1.9 버전에서 JAXB 라이브러리가 누락되어서 따로 MAVEN 에서 찾아서 따로 추가해야 함.
* MyBatis Spring 는 내부적으로 spring jdbc를 사용하기 때문에 같이 설치 해줘야 함.

### AOP
* Aspect = Advice + Point Cut
* 부가기능의 클래스, 공통 기능 = Advice 클래스
* Advice를 적용할 target(Dao 클래스, Service 클래스, 메서드등)을 선택하는 식(정규표현식) -> Point Cut
* spring에서 Aspect를 Advisor라고 함.
* 타켓이랑 advice를 합치는 과정을 Weaving 이라고 한다.
* 타켓과 어드바이스 합쳐지는 위치를 조인 포인트라고 한다.

### AspectJ
#### proceedingJoinPoint
* Proceed -> 타갯이 실행 할 수 있게 하는 명령을 하는 메소드

### Log4j
#### Log Level 제공
* debug, info, warn, error, fatal)
#### Log4j의 구성 요소
* logger + appender(console, file, mail 등등등) + formatter

### EJB
#### BMT (Bean managed Transaction)
* 개발자가 직접 관리
#### CMT (Containter Managed Transation) -> 스프링에서 사용
* 컨테이너가 직접 관리