<!DOCTYPE html>
<html lang="tr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Otel Rezervasyon Sistemi</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            line-height: 1.6;
            background-color: #f4f4f9;
            margin: 0;
            padding: 0;
            color: #333;
        }
        header {
            background-color: #333;
            color: white;
            text-align: center;
            padding: 20px;
        }
        section {
            padding: 20px;
            margin: 20px;
            background-color: white;
            border-radius: 8px;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
        }
        h1, h2 {
            color: #333;
        }
        ul {
            padding-left: 20px;
        }
        li {
            margin: 10px 0;
        }
        .important {
            color: #ff5722;
        }
        .technologies {
            display: flex;
            flex-wrap: wrap;
            gap: 10px;
        }
        .tech-item {
            background-color: #3f51b5;
            color: white;
            padding: 8px 12px;
            border-radius: 20px;
            font-size: 14px;
        }
        .steps, .services {
            margin: 20px 0;
        }
        .code-block {
            background-color: #2e2e2e;
            color: white;
            padding: 10px;
            border-radius: 4px;
            font-family: monospace;
            white-space: pre-wrap;
            overflow-wrap: break-word;
        }
        footer {
            background-color: #333;
            color: white;
            text-align: center;
            padding: 10px;
            position: fixed;
            bottom: 0;
            width: 100%;
        }
    </style>
</head>
<body>

    <header>
        <h1>Otel Rezervasyon Sistemi</h1>
        <p>Microservices Mimarisi ile Geliştirilmiş Otel Rezervasyon Sistemi</p>
    </header>

    <section class="intro">
        <h2>📦 İçerdiği Servisler</h2>
        <ul class="services">
            <li><strong>hotel-service</strong>: Otel ve oda CRUD işlemleri</li>
            <li><strong>reservation-service</strong>: Rezervasyon işlemleri ve Kafka publisher</li>
            <li><strong>notification-service</strong>: Kafka consumer, rezervasyon bildirimi</li>
            <li><strong>postgres</strong>: Veritabanı (PostgreSQL)</li>
            <li><strong>kafka</strong>: Mesajlaşma servisi</li>
            <li><strong>gateway-service</strong>: Tüm servislere giriş noktası (opsiyonel)</li>
        </ul>
    </section>

    <section class="setup">
        <h2>🚀 Başlatma Adımları</h2>
        <ol class="steps">
            <li>
                <strong>Projeyi Klonlayın:</strong>
                <div class="code-block">
                    git clone https://github.com/BM-MuratUygar/otel-rezervasyon-sistemi.git
                    cd otel-rezervasyon-sistemi
                </div>
            </li>
            <li>
                <strong>Projeyi Derleyin:</strong>
                <div class="code-block">
                    mvn clean package -DskipTests -X
                </div>
            </li>
            <li>
                <strong>Docker Compose ile Servisleri Başlatın:</strong>
                <div class="code-block">
                    docker-compose up
                </div>
            </li>
        </ol>
    </section>

    <section class="services-ports">
        <h2>Servislere Erişim</h2>
        <ul>
            <li><strong>Hotel Service:</strong> 8081</li>
            <li><strong>Reservation Service:</strong> 8082</li>
            <li><strong>Notification Service:</strong> 8083</li>
            <li><strong>ApiGateway Service:</strong> 8084</li>
            <li><strong>PostgreSQL:</strong> 5432</li>
            <li><strong>Kafka (internal):</strong> 9092</li>
        </ul>
    </section>

    <section class="authentication">
        <h2>🔒 Kimlik Doğrulama</h2>
        <p>JWT Authentication kullanılarak her kullanıcı sadece kendi rezervasyonlarını görebilir.</p>
    </section>

    <section class="kafka-flow">
        <h2>📡 Kafka Event Akışı</h2>
        <ul>
            <li><strong>reservation-service</strong>: Kafka üzerinden reservation-created event gönderir.</li>
            <li><strong>notification-service</strong>: Bu event’i dinler ve log/console’a bildirir.</li>
        </ul>
    </section>

    <section class="technologies">
        <h2>🧱 Teknolojiler</h2>
        <div class="technologies">
            <div class="tech-item">Java 17</div>
            <div class="tech-item">Spring Boot</div>
            <div class="tech-item">Spring Data JPA</div>
            <div class="tech-item">Spring Cloud Gateway</div>
            <div class="tech-item">Spring Security + JWT</div>
            <div class="tech-item">Apache Kafka</div>
            <div class="tech-item">PostgreSQL</div>
            <div class="tech-item">Docker & Docker Compose</div>
            <div class="tech-item">Lombok</div>
            <div class="tech-item">MapStruct</div>
        </div>
    </section>

    <footer>
        <p>© 2025 Otel Rezervasyon Sistemi | Tüm Hakları Saklıdır</p>
    </footer>

</body>
</html>
