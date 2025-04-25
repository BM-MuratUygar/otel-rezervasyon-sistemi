# Otel Rezervasyon Sistemi

Microservices Mimarisi ile Geliştirilmiş Otel Rezervasyon Sistemi

## 📦 İçerdiği Servisler

- **hotel-service**: Otel ve oda CRUD işlemleri
- **reservation-service**: Rezervasyon işlemleri ve Kafka publisher
- **notification-service**: Kafka consumer, rezervasyon bildirimi
- **api-gateway**: Tüm servislere giriş noktası (opsiyonel)
- **postgres**: Veritabanı (PostgreSQL)
- **kafka**: Mesajlaşma servisi

## 🚀 Başlatma Adımları

1. **Projeyi Klonlayın**:

    ```bash
    git clone https://github.com/BM-MuratUygar/otel-rezervasyon-sistemi.git
    ```
    ```bash
    cd otel-rezervasyon-sistemi
    ```

2. **Projeyi Derleyin**:

    Her servisin kalsörü içerisinde,
    ```bash
    mvn clean package -DskipTests -X
    ```

3. **Docker Compose ile Servisleri Başlatın**:

    Ana dizinde,
	```bash
    docker-compose up
    ```

## Servislere Erişim

- **Hotel Service**: 8081
- **Reservation Service**: 8082
- **Notification Service**: 8083
- **ApiGateway Service**: 8084
- **PostgreSQL**: 5432
- **Kafka (internal)**: 9092

## 🔒 Kimlik Doğrulama

JWT Authentication kullanılarak her kullanıcı sadece kendi rezervasyonlarını görebilir.

## 📡 Kafka Event Akışı

- **reservation-service**: Kafka üzerinden `reservation-created` event gönderir.
- **notification-service**: Bu event’i dinler ve log/console’a bildirir.

## 🧱 Teknolojiler

- Java 17
- Spring Boot
- Spring Data JPA
- Spring Cloud Gateway
- Spring Security + JWT
- Apache Kafka
- PostgreSQL
- Docker & Docker Compose
- Lombok
- MapStruct

bilgisayarmuhendisi@hotmail.com
