# Módulo de Bitácoras

API REST para la gestión de bitácoras de siniestros desarrollada con Spring Boot.

## Descripción

Este sistema permite gestionar el registro y seguimiento de fallecidos, incluyendo información sobre:

- Datos del fallecido
- Datos de contacto
- Datos del reporte
- Coordinadores asignados
- Estado de la bitácora

## Tecnologías

- Java 17
- Spring Boot 3.4.0
- MongoDB
- Maven
- Swagger/OpenAPI

## Requisitos

- JDK 17
- Maven 3.x

## Configuración

1. Clonar el repositorio
2. Configurar las variables de entorno en `src/main/resources/.env`:

```properties
MONGO_USER=tu_usuario
MONGO_PASSWORD=tu_password
```

## Instalación

Para construir el proyecto:

```terminal
./mvnw clean install
```

Para ejecutar la aplicación:

```terminal
./mvnw spring-boot:run
```

## API Endpoints

La documentación completa de la API está disponible, una vez ejecutada la aplicación, en:

```link
http://localhost:8080/api/swagger-ui.html
```

## Base de datos

El proyecto utiliza MongoDB como base de datos. Las principales colecciones son:

- `bitacoras`: Almacena los registros de bitácoras
- `coordinadores`: Almacena la información de los coordinadores

## Estructura del Proyecto

```
src/
├── main/
│   ├── java/
│   │   └── com/matrix/modulo_bicatoras/
│   │       ├── config/
│   │       ├── controller/
│   │       ├── dto/
│   │       ├── exception/
│   │       ├── model/
│   │       ├── repository/
│   │       └── service/
│   └── resources/
└── test/
```

