# 소셜 메트릭스 모니터링 서비스

## 프로젝트 설계
  - 자바 패키지는 속성 (수집현황, 활성화상태, 공통, httpClient 등)으로 나눈다.
  - 속성 별 패키지 별로 (dto, entity, repository, dao, service, config, handler, ...) 를 둔다.
  - 테스트 코드는 샘플로 몇개 만들어 놓았다.
  - 스크립트는 속성 별로 디렉토리를 만들고 그 안에 세부 동작 파일들을 둔다.

## 프로젝트 구조
> ## **Java**
> - com / daumsoft (groupId) / smm (artifactId)
>   - **buzz** : 채널 별 수집현황
>     - dto
>       - BuzzResultDTO : 수집현황 결과 DTO
>     - entity
>       - BuzzResult : 수집현황 결과 Entity
>       - BuzzResultPK : 수집현황 조회 시 사용되는 PK
>     - repository
>       - BuzzResultRepository : 수집현황 조회 Repo (DAO 와 같은 동작)
>     - service
>       - BuzzResultService : 테이블에서 가져온 데이터를 반환 데이터로 가공해주는 Service
>     - web
>       - BuzzResultController : 컨트롤러 REST API
>   - **httpClient**
>     - config
>       - HttpClientConfiguration : HttpClient 설정
>       - RestTemplateConfiguration : RestTemplate 설정
>     - handler
>       - CustomHttpClientRequestErrorHandler : RestTemplate 에러 처리 핸들러
>     - interceptor
>       - CusttomHttpClientRequestInterceptor : RestTemplate 요청 인터셉터인데 현재는 별다른 동작 없음
>     - service 
>       - CallAPI : GET, POST 요청 메소드 호출 시 사용
>   - **status**
>     - dto
>       - AppStatusDTO : UP / DOWN (활성화 상태) DTO 객체
>     - service
>       - AppStatusService : 서비스 별 URL 을 static 변수로 가지고 있으며 파라미터 (요청 서비스) 에 따라  RestTemplate 호출
>     - web
>       - AppStatusController : 활성화 상태 반환 컨트롤러
>   - **common**
>     - config 
>       - WebMVCConfiguration : application.yml 에서 전부 설정하였으므로 backup 파일로 보존
>     - dto 
>       - ResponseResultDTO : 데이터 반환 공통 DTO 객체, 상태, 메세지, 데이터를 담아 보낸다.
>     - web
>       - PageController : 페이지 컨트롤러, 단순 페이지 이동만 관리한다
>     - constant
>       - HTTP : HTTP 의 상태를 사용자 정의로 추가한 객체
> ---
> ## **Resources**
> - static / resouces 밑에 보관
> - css
>   - plugins : inspinia 라이브러리 보관
>   - patterns : inspinia 라이브러리 보관
>   - inspinia 라이브러리 파일
>   - 사용자 정의 css 파일은 css 밑에 둔다.
> - js
>   - buzzResult 
>     - buzzResult : 수집현황 데이터를 호출, 차트를 호출하는 함수를 가진 js
>     - chart : 수집현황 차트 관련 js
>   - common 
>     - navi : 네비게이션 바에 대한 동작 정의
>     - common : 공통 동작에 대해서 정의
>     - util : 사용시 필요한 유틸리티 함수를 모아놓음
>   - index 
>     - index : 초기 js
>   - hist 
>     - hist : 로그량 호출 및 차트를 호출
>     - chart : 로그량 차트 호출
>   - inspinia : inspinia js 모음
>   - plugin
>     - daterangepicker
>     - amchart
> - config
>   - application-development.yml : DEV 버전 설정파일
>   - application-product.yml : PROD 버전 설정파일
>   - application.yml : 공통 설정파일
>   - log4jdbc.log4j2.properties : JDBC 로그 설정파일
> ---
> ## **JSP**
> - webapp / WEB-INF / views
>   - buzzResult
>     - buzzResult : 수집현황 화면 뷰
>   - common
>     - footer : 푸터 뷰
>     - meta : 메타 태그 모음
>     - navi : 네이게이션 바 뷰
>     - script : 스크립트 모음
>     - style : 씨에스에스모음
>     - taglib : taglib 모음
>   - error : Spring boot 에서는 404, 500 같은 경우 error 밑에 파일명과 매핑된다.
>     - 400 : 400 에러 페이지 뷰
>     - 404 : 404 에러 페이지 뷰
>     - 500 : 500 에러 페이지 뷰
>   - hist 
>     - hist : 로그량 화면 뷰
>   - index 
>     - index : 초기 화면 뷰 (현재는 사용 안됨)