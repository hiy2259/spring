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
* 부가기능의 클래스 = Advice 클래스
* Advice를 적용할 target(Dao 클래스, Service 클래스)을 선택하는 식(정규표현식) -> Point Cut