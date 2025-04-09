<h1>README for Zynetic Assignment Repository</h1>

  <h2>Setup Instructions</h2>

  <h3>1. Clone the Repository</h3>
  <p>Clone the repository to your local machine using the following command:</p>
  <pre><code>git clone [https://github.com/kumarwhocodes/zynetic_assignment.git](https://github.com/ArslanXa/ZyneticBookStoreBackend.git)</code></pre>
  <p><em>But, preferably download the zip file from Google Forms.</em></p>

  <h3>2. Navigate to the Project Directory</h3>
  <p>Move into the cloned directory:</p>
  <pre><code>cd SpringSecEx</code></pre>

  <h3>3. Build the Project</h3>
  <p>The project uses Gradle for building. Run the following command to build the project:</p>
  <pre><code>mvn install</code></pre>

  <h3>4. Run the Application</h3>
  <p>Start the application using:</p>
  <pre><code>mvn spring-boot:run</code></pre>

  <h3>5. Docker Setup (Optional)</h3>
  <p>If you prefer to run the application in a Docker container:</p>
  <ul>
    <li>Build the Docker image:
      <pre><code>docker build -t SpringSecEx .</code></pre>
    </li>
    <li>Run the Docker container:
      <pre><code>docker run -p 8080:8090 SpringSecEx</code></pre>
    </li>
  </ul>

  <h2>API Endpoints and Sample Requests</h2>
  <p>Refer to the documentation section for full details on available API endpoints and example usage.</p>

   <h2>🔐 Authentication Endpoints</h2>
  <table>
    <tr><th>Method</th><th>Endpoint</th><th>Description</th></tr>
    <tr><td>POST</td><td>/api/auth/register</td><td>User registration</td></tr>
    <tr><td>POST</td><td>/api/auth/login</td><td>JWT login</td></tr>
  </table>

  <details>
    <summary><strong>Sample Request/Response for Signup</strong></summary>
    <pre><code>POST /api/signup
Content-Type: application/json

{
  "email": "user@example.com",
  "password": "securePass123"
}</code></pre>
<pre><code>
200 OK
{
  "token": "jwt_token_here"
}</code></pre>
  </details>

  <details>
    <summary><strong>Sample Request/Response for Login</strong></summary>
    <pre><code>POST /api/login
Content-Type: application/json

{
  "email": "user@example.com",
  "password": "securePass123"
}</code></pre>
<pre><code>
200 OK
{
  "token": "jwt_token_here"
}</code></pre>
  </details>

  <p>Use JWT token in header:</p>
  <pre><code>Authorization: Bearer &lt;your_token&gt;</code></pre>

  <h2>📘 Book Endpoints</h2>
  <table>
    <tr><th>Method</th><th>Endpoint</th><th>Description</th></tr>
    <tr><td>POST</td><td>/api/books/create</td><td>Create a book</td></tr>
    <tr><td>GET</td><td>/api/books/getallbooks</td><td>All books</td></tr>
    <tr><td>GET</td><td>/api/books/{id}</td><td>Book by ID</td></tr>
    <tr><td>PUT</td><td>/api/books/{id}</td><td>Update book</td></tr>
    <tr><td>DELETE</td><td>/api/books/{id}</td><td>Delete book</td></tr>
    <tr><td>GET</td><td>/api/books/search</td><td>Search by title</td></tr>
    <tr><td>GET</td><td>/api/books/filter</td><td>Filter books</td></tr>
    <tr><td>GET</td><td>/api/books/sort</td><td>Sort books</td></tr>
    <tr><td>GET</td><td>/api/books/getallbookspaged</td><td>Paginated list of books</td></tr>
  </table>

  <details>
    <summary><strong>Sample Request/Response for Creating a Book</strong></summary>
    <pre><code>POST /api/books/create
Content-Type: application/json

{
  "id": 1,
  "title": "The Alchemist",
  "author": "Paulo Coelho",
  "category": "Novel",
  "price": 350,
  "rating": 4.8,
  "publishedDate": "1993-08-01"
}</code></pre>
<pre><code>
200 OK
{
  "id": 1,
  "title": "The Alchemist",
  "author": "Paulo Coelho",
  "category": "Novel",
  "price": 350,
  "rating": 4.8,
  "publishedDate": "1993-08-01"
}</code></pre>
  </details>

  <details>
    <summary><strong>Sample Response for Get Book by ID</strong></summary>
    <pre><code>GET /api/books/1

Response:
200 OK
{
  "id": 1,
  "title": "The Alchemist",
  "author": "Paulo Coelho",
  "category": "Novel",
  "price": 350,
  "rating": 4.8,
  "publishedDate": "1993-08-01"
}</code></pre>
  </details>

  <details>
    <summary><strong>Sample Request/Response for Update Book</strong></summary>
    <pre><code>PUT /api/books/1
Content-Type: application/json

{
  "id": 1,
  "title": "The Alchemist - Updated",
  "author": "Paulo Coelho",
  "category": "Novel",
  "price": 400,
  "rating": 4.9,
  "publishedDate": "1993-08-01"
}</code></pre>
<pre><code>
200 OK
{
  "id": 1,
  "title": "The Alchemist - Updated",
  "author": "Paulo Coelho",
  "category": "Novel",
  "price": 400,
  "rating": 4.9,
  "publishedDate": "1993-08-01"
}</code></pre>
  </details>

  <details>
    <summary><strong>Sample Response for Get All Books</strong></summary>
    <pre><code>GET /api/books/get-all

Response:
200 OK
[
  {
    "id": 1,
    "title": "The Alchemist",
    "author": "Paulo Coelho",
    "category": "Novel",
    "price": 350,
    "rating": 4.8,
    "publishedDate": "1993-08-01"
  }
]</code></pre>
  </details>

  <details>
    <summary><strong>Sample Response for Search by Title</strong></summary>
    <pre><code>GET /api/books/search?title=alchemist

Response:
200 OK
[
  {
    "id": 1,
    "title": "The Alchemist",
    "author": "Paulo Coelho",
    "category": "Novel",
    "price": 350,
    "rating": 4.8,
    "publishedDate": "1993-08-01"
  }
]</code></pre>
  </details>

  <details>
    <summary><strong>Sample Response for Filter</strong></summary>
    <pre><code>GET /api/books/filter?author=Paulo&category=Novel&rating=4.5

Response:
200 OK
[
  {
    "id": 1,
    "title": "The Alchemist",
    "author": "Paulo Coelho",
    "category": "Novel",
    "price": 350,
    "rating": 4.8,
    "publishedDate": "1993-08-01"
  }
]</code></pre>
  </details>

  <details>
    <summary><strong>Sample Response for Sort</strong></summary>
    <pre><code>GET /api/books/sort?basedOn=rating&ascending=false

Response:
200 OK
[
  {
    "id": 1,
    "title": "The Alchemist",
    "author": "Paulo Coelho",
    "category": "Novel",
    "price": 350,
    "rating": 4.8,
    "publishedDate": "1993-08-01"
  }
]</code></pre>
  </details>

  <details>
    <summary><strong>Sample Response for Pagination</strong></summary>
    <pre><code>GET /api/books/paged?page=0&size=5&sort=price,desc

Response:
200 OK
{
  "content": [
    {
      "id": 1,
      "title": "The Alchemist",
      "author": "Paulo Coelho",
      "category": "Novel",
      "price": 350,
      "rating": 4.8,
      "publishedDate": "1993-08-01"
    }
  ],
  "pageNumber": 0,
  "pageSize": 5,
  "totalElements": 1,
  "totalPages": 1,
  "last": true
}</code></pre>
  </details>

 
  <h2>✅ Completed Features</h2>
  <ul>
    <li>[x] JWT Authentication</li>
    <li>[x] Book CRUD</li>
    <li>[x] Search / Filter / Sort</li>
    <li>[x] Pagination</li>
    <li>[x] Swagger Documentation</li>
    <li>[x] Dockerization</li>
  </ul>



</body>
</html>
