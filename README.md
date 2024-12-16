# Simpleboard

Spring Framework를 활용해 CRUD 기능을 구현한 간단한 게시판입니다

---

## 1. 프로젝트 개요

- 웹 서비스의 기본 기능인 CRUD를 구현한 간단한 형태의 게시판입니다.
- 회원, 게시글, 댓글, 카테고리에 대한 생성, 읽기, 수정, 삭제가 주 기능입니다
- 세션을 통한 로그인과 페이지 처리 기능이 있습니다
- JavaScript를 통한 엘리먼트 조작과 유효성 검사, Ajax를 이용한 비동기 통신 기술이 활용되었습니다

## 2. 사용된 기술

### 2-1. 백엔드

- 사용된 언어

  - Java 11

- 프레임워크/라이브러리

  - Spring Framework 5.2.13
  - JSP 2.3.3
  - Jstl 1.2
  - Jackson-databind 2.12.2
  - Ojdbc6 11.2.0.4
  - MyBatis 3.5.6
  - Lombok 1.18.30

- 데이터베이스

  - Oracle 11g

- 프로젝트 빌드 툴

  - Maven 4.0.0

### 2-2. 프론트엔드

- HTML/CSS
- JavaScript
- BootStrap 5.2.3

## 3. 화면 설계

### 3-1. 메인 화면 (게시글 목록)


![1 메인화면](https://github.com/user-attachments/assets/ea496b87-f7e4-4cca-9926-50f8492124f8)


- 메인 화면으로 이동 시 전체 글 목록이 출력됨


![2 페이징처리](https://github.com/user-attachments/assets/04184553-b585-4427-ab52-080a032c705d)


- 화면 최하단에 페이지 처리


![3 카테고리 검색](https://github.com/user-attachments/assets/80517fa8-2f59-41d9-b99d-be03d91cb598)


- 우측 검색 위젯에서 카테고리 클릭 시 해당 카테고리 게시글 검색


![4 키워드 검색](https://github.com/user-attachments/assets/b5cce207-f3ec-42c5-b64a-42fc9e6cf69c)


- 우측 검색 위젯에서 키워드 검색 시 해당 키워드가 포함된 게시글 검색


### 3-2. 회원 가입


![5 회원 가입](https://github.com/user-attachments/assets/81d0bbcd-7824-4ccf-af6b-f7e24f79964f)


- 우측 상단 Join 버튼을 통해 회원 가입 가능


![5-1 유효성 검사](https://github.com/user-attachments/assets/f38ad9fb-0963-4a04-9e8d-cf64a18bc2a1)


- 입력값에 대한 유효성 검사


![6 가입 성공](https://github.com/user-attachments/assets/5ae3c553-86e6-4f35-802c-aad341bf480a)


- 가입 성공 시 화면


### 3-3. 로그인


![7 로그인 화면](https://github.com/user-attachments/assets/fc22ae54-3402-4f45-9c78-c07ca663f6bd)


- 우측 상단의 Login 버튼을 통해 로그인 가능


![7-1 패스워드 검사](https://github.com/user-attachments/assets/164fa9a0-cc8c-4478-840b-64df3376321a)


- Ajax를 이용해 새로고침 없이 실시간 아이디/비밀번호 검사


### 3-4. 마이 페이지


![8 마이 페이지](https://github.com/user-attachments/assets/ed3cd430-1b9b-4d1a-9a26-f5573dd311e4)


- 로그인 후 우측 상단의 MyPage 버튼을 통해 마이 페이지 입장 가능


![8-1 회원정보 수정](https://github.com/user-attachments/assets/2c11a715-bdd8-4410-89c3-0451133d4af6)


- 회원정보 수정 창


### 3-5 게시글 작성


![9 게시글 작성](https://github.com/user-attachments/assets/5e36b8c4-bff3-4e4c-a58d-39f684fcdb84)


- 로그인 후 우측 상단의 Write 버튼을 통해 글 작성 가능


### 3-6 게시글 보기


![10 게시글 보기](https://github.com/user-attachments/assets/edc76827-edbb-4e49-9289-bd2453a3e980)


- 작성된 게시물 보기


![10-1 댓글 작성](https://github.com/user-attachments/assets/1b3463b1-e597-4008-a027-1a0acf3ca273)


- 로그인 후 댓글 작성 가능


![10-2 댓글 수정](https://github.com/user-attachments/assets/85976e8d-ef84-4591-96a1-58d07df4eab1)


- 댓글 옆 버튼을 통해 수정 및 삭제 가능


### 3-7 관리자 화면


![11 관리자 화면](https://github.com/user-attachments/assets/4c674637-4f7a-4ef9-8013-a23b1cfb62f6)


- 관리자 계정 로그인 후 마이 페이지에서 admin 버튼을 통해 입장


![11-1 관리자 화면](https://github.com/user-attachments/assets/af792f6d-f3e0-41c8-ab1d-1ca6caca377f)


- 간단한 통계와 회원, 카테고리 관리 기능


![11-2 회원 관리](https://github.com/user-attachments/assets/fef126e2-3071-4a7d-beaa-306b15ad49f3)


- 관리자용 회원 관리 창


![11-3 카테고리 관리](https://github.com/user-attachments/assets/dddcee21-b56f-494e-a277-511b85813804)


- 관리자용 카테고리 관리 창


## 4. 데이터베이스 설계

![12 DB 관계도](https://github.com/user-attachments/assets/4dff0ba0-60e7-4831-89fe-baae8e0dc0e5)


## 5. 개선할 점

- 현재는 많은 프로젝트가 Spring Boot로 대체되는 것으로 보이므로 Spring Boot로 포팅할 계획
- Service와 Controller의 역할 분담이 아직 제대로 이루어지지 않은 것 같다는 느낌이 듬
- 뷰, 비즈니스 로직, 서비스의 역할 분담에 조금 더 신경써서 개발할 예정
