Otel Rezervasyon Sistemi
Bu proje, mikroservis mimarisi ile geliştirilmiş örnek bir otel rezervasyon sistemidir. Spring Boot, Docker, Kafka, PostgreSQL, Spring Security (JWT), Spring Cloud Gateway gibi teknolojileri içermektedir.

📦 İçerdiği Servisler

Servis Adı	Açıklama
hotel-service	Otel ve oda CRUD işlemleri
reservation-service	Rezervasyon işlemleri ve Kafka publisher
notification-service	Kafka consumer, rezervasyon bildirimi
postgres	Veritabanı (PostgreSQL)
kafka	Mesajlaşma servisi
gateway-service	Tüm servislere giriş noktası (opsiyonel)
🚀 Başlatma Adımları

1. Projeyi Klonlayın
git clone https://github.com/BM-MuratUygar/otel-rezervasyon-sistemi.git
cd otel-rezervasyon-sistemi

2. Projeyi Derleyin
Her servisin dizinine giderek:
mvn clean package -DskipTests -X

3. Docker Compose ile Servisleri Başlatın
Ana dizine dönün
docker-compose up

4. Servislere Erişim
Servis	Port
Hotel Service	8081
Reservation Service	8082
Notification Service	8083
ApiGateway Service	8084
PostgreSQL	5432
Kafka (internal)	9092
🔒 Kimlik Doğrulama
JWT Authentication kullanılarak her kullanıcı sadece kendi rezervasyonlarını görebilir.

📡 Kafka Event Akışı
reservation-service Kafka üzerinden reservation-created event gönderir.

notification-service bu event’i dinler ve log/console’a bildirir.

🧱 Teknolojiler
Java 17
Spring Boot
Spring Data JPA
Spring Cloud Gateway
Spring Security + JWT
Apache Kafka
PostgreSQL
Docker & Docker Compose
Lombok, MapStruct, etc.

📂 Proje Yapısı
otel-rezervasyon-sistemi/
│
├── hotel-service/
├── reservation-service/
├── notification-service/
├── api-gateway/
├── docker-compose.yml
└── README.md

📬 İletişim
Herhangi bir soru için: [bilgisayarmuhendisi@hotmail.com]
