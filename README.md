# 🎵 Off The Record API
*A Spring Boot REST API powering an online vinyl record store.*

## 📖 Overview

Off The Record is a backend REST API developed using Spring Boot and Java. It serves as the backend for an e-commerce record store, allowing customers to browse vinyl records while administrators manage inventory and categories.

This project was completed as part of the Year Up United Java Development Program Capstone.

---

# 🚀 Features

## Authentication
- JWT Authentication
- User Login
- User Registration
- Role-based authorization
- Password encryption using BCrypt

## Categories
- View all categories
- View a single category
- View products within a category
- Create categories (Admin only)
- Update categories (Admin only)
- Delete categories (Admin only)

## Products
- Search products
- Filter by category
- Filter by minimum price
- Filter by maximum price
- Filter by subcategory
- View individual product
- Create products (Admin only)
- Update products (Admin only)
- Delete products (Admin only)

## Security
- Spring Security
- JWT Authorization
- Role-based endpoint protection
- BCrypt password hashing

---

# 🛠 Technologies Used

- Java 21
- Spring Boot
- Spring MVC
- Spring Data JPA
- Spring Security
- JWT
- MySQL
- Maven
- IntelliJ IDEA
- Insomnia
- Swagger UI
- Git
- GitHub

---

# 📂 Project Structure

```
src
 ├── controllers
 ├── service
 ├── repository
 ├── models
 ├── security
 └── configuration
```

The application follows a layered architecture:

```
Controller
      ↓
Service
      ↓
Repository
      ↓
MySQL Database
```

---

# 🔐 Security

Authentication is handled using JSON Web Tokens (JWT).

Users must log in to receive a JWT token.

Admin-only endpoints include:

- POST /categories
- PUT /categories/{id}
- DELETE /categories/{id}
- POST /products
- PUT /products/{id}
- DELETE /products/{id}

---

# 📡 API Endpoints

## Authentication

| Method | Endpoint |
|---------|----------|
| POST | /login |
| POST | /register |

---

## Categories

| Method | Endpoint |
|---------|----------|
| GET | /categories |
| GET | /categories/{id} |
| GET | /categories/{id}/products |
| POST | /categories |
| PUT | /categories/{id} |
| DELETE | /categories/{id} |

---

## Products

| Method | Endpoint |
|---------|----------|
| GET | /products |
| GET | /products/{id} |
| POST | /products |
| PUT | /products/{id} |
| DELETE | /products/{id} |

---

# 🐛 Bugs Fixed

Several bugs from the starter project were identified and resolved.

### Product Search
- Fixed incorrect product filtering
- Corrected search behavior for category, price, and subcategory filters

### Product Updates
- Fixed product update logic to correctly save modified product information

### Category API
- Implemented full CRUD functionality
- Added proper HTTP status codes
- Added role-based authorization
- Added error handling for missing categories

---

# 🧪 Testing

The API was tested using:

- Insomnia
- Swagger UI

Testing included:

- Authentication
- Authorization
- CRUD operations
- Search functionality
- Error handling
- HTTP status codes

---

# 💿 Theme

Frontend selected:

**🎵 Off The Record**

An independent vinyl record store specializing in new releases, classics, and collectible albums.

---

# 📸 Screenshots

Add screenshots here:

- Home Page
- Categories
- Product Search
- Swagger UI
- Insomnia Tests

---

# 📈 Future Improvements

- Shopping Cart
- Order Checkout
- Wishlist
- Customer Reviews
- Album Recommendations
- Artist Search
- Inventory Dashboard

---

# 👩‍💻 Author

**Mikayla Brabham**

Java Developer | Spring Boot | REST APIs | SQL

GitHub:
(Add your GitHub URL)

LinkedIn:
(Add your LinkedIn URL)

---

# 🙏 Acknowledgements

Year Up United

Spring Boot

Spring Security

MySQL

Swagger

Insomnia
