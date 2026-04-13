# Help Desk Ticketing System 🎫

A robust, enterprise-ready Help Desk solution built with **Spring Boot 3**. This system provides a seamless experience for managing support tickets, real-time communication between users and admins, and automated data maintenance.

## 🌟 Key Features

* **Secure Authentication:** Full JWT-based security flow for user registration and login.
* **Ticket Management:** Create, track, and update support tickets with priority levels and statuses.
* **Real-time 1:1 Chat:** Secure private messaging between users and support agents using **WebSockets & STOMP**.
* **Excel Reporting:** Export ticket data to professional Excel spreadsheets for analysis (Apache POI).
* **Automated Maintenance:** A scheduled cleanup service that removes chat history older than 7 days every midnight.
* **Interactive API Documentation:** Integrated **Swagger/OpenAPI** for easy testing of all endpoints.

## 🛠 Tech Stack

* **Backend:** Java 17, Spring Boot 3.x
* **Security:** Spring Security, JWT
* **Database:** PostgreSQL (Production) / H2 (Development)
* **Real-time:** Spring WebSocket, SockJS, STOMP
* **Persistence:** Spring Data JPA (Hibernate)
* **Utilities:** Lombok, Apache POI, Maven

## 🚀 Getting Started

### Prerequisites
* JDK 17 or higher
* Maven 3.6+

### Installation
1. Clone the repository:
   ```bash
   git clone [https://github.com/your-username/helpdesk-ticketing-system.git](https://github.com/your-username/helpdesk-ticketing-system.git)