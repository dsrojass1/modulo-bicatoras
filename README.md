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

## Estructura y Buenas Prácticas del Proyecto

### Arquitectura en Capas

El proyecto sigue una arquitectura en capas basada en el patrón MVC (Model-View-Controller) y los principios de Clean Architecture, organizando el código en los siguientes paquetes:

📁 **config**

Contiene las configuraciones globales de la aplicación:

- `ApplicationConfig`: Configura beans globales como ModelMapper y CORS
- Centraliza la configuración de dependencias y comportamientos cross-cutting
  
📁 **controller**

Capa de presentación que expone los endpoints REST:

- `BitacoraController`
- `CoordinadorController`
- Maneja las peticiones HTTP y delega la lógica de negocio a los servicios
- Utiliza anotaciones como `@RestController`, `@RequestMapping`, etc.
- Documentada con OpenAPI/Swagger

📁 **dto (Data Transfer Objects)**

Objetos para transferencia de datos entre capas:

- `BitacoraDTO`
- `CoordinadorDTO`
- Evita exponer las entidades de dominio
- Permite versionado de APIs
- Usa Lombok para reducir boilerplate

📁 **exception**

Manejo centralizado de excepciones:

- `EntityNotFoundException`
- Permite un manejo consistente de errores
- Facilita respuestas HTTP apropiadas

📁 **model**

Entidades de dominio:

- `BitacoraEntity`
- `CoordinadorEntity`
- Mapean directamente a colecciones MongoDB
- Usan anotaciones de Spring Data

📁 **repository**

Interfaces para acceso a datos:

- `BitacoraRepository`
- `CoordinadorRepository`
- Extienden `MongoRepository` para operaciones CRUD
- Definen queries personalizados

📁 **service**

Lógica de negocio:

- `BitacoraService`
- `CoordinadorService`
- Implementan transacciones y validaciones
- Orquestan llamadas a repositorios

📁 **resources**

Archivos de configuración:

- `application.properties`: Configuración de Spring Boot
- `.env`: Variables de entorno
- Perfiles de Spring Boot

### Buenas Prácticas Implementadas

1. Separación de Responsabilidades

- Cada capa tiene una responsabilidad única y bien definida
- Bajo acoplamiento entre componentes
- Alta cohesión dentro de cada módulo

2. Gestión de Dependencias

- Inyección de dependencias con Spring
- Uso de interfaces para abstracción
- Maven para gestión de dependencias

3. Manejo de Datos

- DTOs para transferencia segura de datos
- Mapeo objeto-documento con Spring Data MongoDB
- Validación de datos en múltiples capas
  
4. Documentación

- OpenAPI/Swagger para documentación de API
- Comentarios descriptivos en código
- README con instrucciones de despliegue
  
5. Escalabilidad

- Diseño modular
- Fácil adición de nuevos endpoints
- Preparado para microservicios

### Integración y Mantenimiento

Para mantener y extender el proyecto:

- Seguir la estructura de paquetes existente
- Usar DTOs para nuevos endpoints
- Documentar APIs con OpenAPI
- Mantener la separación de capas
- Implementar pruebas unitarias
- Seguir convenciones de nombres
- Actualizar documentación

Para integrar con otros sistemas:

- Usar los DTOs existentes como contratos
- Implementar nuevos endpoints siguiendo el patrón
- Mantener la compatibilidad hacia atrás
- Documentar cambios en la API




