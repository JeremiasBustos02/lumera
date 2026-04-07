# 🏥 Lumera: Sistema de Orquestación de Turnos Médicos

**Lumera** es una plataforma SaaS (Software as a Service) diseñada para la gestión inteligente de recursos hospitalarios. El sistema resuelve la complejidad de coordinar agendas médicas, disponibilidad de consultorios y notificaciones asíncronas, asegurando la integridad de los datos mediante una arquitectura distribuida.

## 🚀 Stack Tecnológico
* **Backend:** Java 21, Spring Boot 3.x, Spring Cloud (Gateway).
* **Base de Datos:** PostgreSQL, Redis (Caché).
* **Mensajería:** RabbitMQ (Event-Driven Architecture).
* **Frontend:** React, Vite, Tailwind CSS (Próximamente).
* **Infraestructura:** Docker, Docker Compose.

## 🏗️ Arquitectura de Microservicios
El sistema se divide en servicios especializados para garantizar escalabilidad:
1. **Auth Service:** Gestión de identidades y seguridad con JWT.
2. **Clinic Core:** Lógica de negocio, gestión de médicos y reserva de turnos con *Pessimistic Locking*.
3. **Notification Service:** Procesamiento asíncrono de alertas y recordatorios.
4. **API Gateway:** Punto de entrada único con ruteo y filtros de seguridad.

## 🛠️ Desafíos Técnicos Resueltos
* **Concurrencia Crítica:** Implementación de bloqueos a nivel de base de datos para evitar la doble reserva de recursos físicos (consultorios) en entornos de alta demanda.
* **Comunicación Asíncrona:** Desacoplamiento de servicios mediante el uso de colas de mensajes (RabbitMQ) para mejorar la resiliencia del sistema.
* **Seguridad Centralizada:** Validación de tokens JWT en el Gateway para proteger el ecosistema de microservicios.

## 📦 Cómo ejecutar el proyecto
1. Clonar el repositorio: `git clone https://github.com/TU_USUARIO/lumera.git`
2. Asegurarse de tener **Docker Desktop** iniciado.
3. En la raíz del proyecto, ejecutar:
   ```bash
   docker-compose up -d
   ```
4. Los servicios estarán disponibles en los puertos configurados (Gateway en el 8080).

---

Desarrollado por Jeremías Emanuel Bustos - [Linkedin](https://www.linkedin.com/in/jeremiasbustos/)