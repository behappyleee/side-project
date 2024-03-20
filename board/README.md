- ### 사용 기술 스택
  - #### Kotlin
  - #### Exposed
  - #### MySql

### API Exposed Library List
#### Exposed 사용
- 게시글 생성
  - POST /api/v1/exposed/posts
 - 전체 게시글 조회
   - GET /api/v1/exposed/posts
 - 특정 게시글 조회
   - GET /api/v1/exposed/posts/{postId}
 - 게시글 업데이트
   - PUT /api/v1/posts/exposed/{postId}
 - 게시글 삭제
   - DELETE /api/v1/posts/exposed/{postId}

#### Jpa 사용
- 게시글 생성
    - POST /api/v1/jpa/posts
- 전체 게시글 조회
    - GET /api/v1/jpa/posts
- 특정 게시글 조회
    - GET /api/v1/jpa/posts/{postId}
- 게시글 업데이트
    - PUT /api/v1/posts/jpa/{postId}
- 게시글 삭제
    - DELETE /api/v1/posts/jpa/{postId}