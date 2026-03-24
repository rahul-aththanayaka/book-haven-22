# 📚 Book Haven 22 - Bookstore Management System

A professional desktop application built using **Java (Swing)** and **MySQL**, following the **MVC (Model-View-Controller)** architecture. This system automates inventory, user management, and stock monitoring for a bookstore.

---

## 🏛️ Architecture & OOP Implementation

This project is structured using the **MVC Pattern** to separate data logic from the user interface:
- **Model:** Database logic and data structures.
- **View:** GUI developed with Java Swing.
- **Controller:** Bridges the gap between View and Model.

### 🧩 Core OOP Concepts:
- **Encapsulation:** Used in model classes for data security.
- **Inheritance & Abstraction:** Used for user roles and product categories.
- **Polymorphism:** Implemented in search and filtering methods.

---

## 🚀 Key Features
- **Store Manager:** User account creation, stock monitoring, and restock alerts.
- **Cashier:** Add new products, view details, and search items across categories (Fiction, Non-fiction, etc.).

---

## 🛠️ Tech Stack & Dependencies
- **Language:** Java (JDK 8+)
- **Database:** MySQL (XAMPP)
- **Library:** `mysql-connector-j-9.5.0.jar` (Included in `/lib` folder)

---

## 📋 Setup Instructions

1. **Clone/Download** this repository.
2. Open the project in **NetBeans**.
3. **Database Setup:**
   - Open phpMyAdmin and create a database named **`book_haven_db`**.
   - Import the **`book_haven_db.sql`** file from this repository.
4. **Library Setup:**
   - Ensure the **`mysql-connector-j-9.5.0.jar`** (found in the `lib` folder) is added to your project's Libraries/Classpath in NetBeans.
5. **Run:** Start the application from the Login frame.

---

## 🔑 Demo Credentials

| Role | Username | Password |
| :--- | :--- | :--- |
| **Store Manager** | `manager` | `1234` |
| **Cashier** | `cashier` | `1234` |

---

## 🎓 Academic Context
Developed as an **Individual Assignment** for the HNDIT program at SLIATE, demonstrating practical application of Object-Oriented Programming and Database Integration.
