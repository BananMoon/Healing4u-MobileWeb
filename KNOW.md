##1. Spring 웹 계층
### 1. Web Layer

흔히 사용하는 컨트롤러(@Controller)와 뷰 템플릿 영역(JSP/Freemarker 등) 입니다.<br>
이외에도 외부 요청과 응답에 대한 전반적인 영역(필터@Filter, 인터셉터, 컨트롤러 어드바이스@ControllerAdvice)

### 2. Service Layer (@Service)

일반적으로 Controller와 Dao(데이터 저장소 접근 영역)의 중간 영역에서 사용됩니다.<br>
@Transactional이 사용되어야 하는 영역이기도 합니다.

### 3. Repository Layer
Database와 같이 데이터 저장소에 접근하는 영역 (Dao 영역)<br>

### 4. Dtos
Dto(Data Trasfer Object)는 계층간 데이터 교환을 위한 객체.<br>
Dtos는 이들의 영역<br>
예) 뷰 템플릿 엔진에서 사용될 객체, Repository Layer에서 결과로 넘겨줄 객체

### 5. Domain Model
도메인이라 불리는 개발 대상을 모든 사람이 동일한 관점에서 이해하고 공유할수 있도록 단순화 시킨 것<br>
@Entity가 사용된 영역<br>
예) 택시 앱 - '배차', '탑승', '요금' 등이 모두 도메인<br>
**비즈니스 처리를 담당해야할 곳**




결국 API를 만들기 위해서는 총 3개의 클래스가 필요하겠지요.

Request 데이터를 받을 Dto
API 요청을 받을 Controller
트랜잭션, 도메인 기능간 순서를 보장하는 Service