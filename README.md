# MyHotel Challenge – Vehicle & Employee Services

Este repositorio contiene dos servicios RESTful desarrollados en **Spring Boot**:

- `vehicle-service`: Administración de vehículos y sus mantenciones.
- `employee-service`: Administración de empleados.

Ambos servicios utilizan bases de datos MySQL independientes y se levantan fácilmente con Docker Compose.

---

## Requisitos Previos

- Java 17 o superior
- Docker y Docker Compose instalados
- Maven instalado

---

## Estructura del Proyecto

```bash
myhotel-challenge
├── docker-compose.yml
├── employee-service
└── vehicle-service
```

---

## Cómo ejecutar los servicios

### 1. Clonar el repositorio

```bash
git clone <url-del-repositorio>
cd myhotel-challenge
```

### 2. Construir y levantar los servicios con Docker Compose

#### Construir employee-service
```bash
cd employee-service
mvn clean install
cd ..
```


#### Construir vehicle-service

```bash
cd vehicle-service
mvn clean install
cd ..
```


```bash
docker-compose build
docker-compose up
```

> **Nota:** Los servicios estarán disponibles en los siguientes puertos:
>
> - Vehicle Service: `http://localhost:8081`
> - Employee Service: `http://localhost:8082`

---

## Verificar que los servicios estén corriendo

Puedes verificar que los servicios estén corriendo correctamente accediendo desde un navegador web o herramientas como Postman:

- Vehicle Service: [http://localhost:8081](http://localhost:8081)
- Employee Service: [http://localhost:8082](http://localhost:8082)

---

## Detener los servicios

Presiona `Ctrl + C` en la terminal o ejecuta:

```bash
docker-compose down
```

---


# API Documentation

## Employee Service Endpoints

### Base URL: `/employees`

| Method | Endpoint                                  | Description                                          |
|--------|-------------------------------------------|------------------------------------------------------|
| GET    | `/salary-segments`                        | Returns salary segments across the company.          |
| GET    | `/salary-segments-by-department`          | Provides salary segments grouped by department.      |
| GET    | `/top-paid-by-department`                 | Lists the top-paid employee in each department.      |
| GET    | `/experienced-managers`                   | Lists managers with significant experience.          |
| GET    | `/average-salary-by-department`           | Provides average salary per department (>10 employees).|
| GET    | `/salary-stats-by-country`                | Returns salary statistics grouped by country.        |

---

## Vehicle Service Endpoints

### Base URL: `/vehicles`

| Method | Endpoint                           | Description                               |
|--------|------------------------------------|-------------------------------------------|
| GET    | `/`                                | Lists all vehicles.                       |
| GET    | `/{id}`                            | Retrieves details for a specific vehicle. |
| POST   | `/`                                | Creates a new vehicle.                    |
| PUT    | `/{id}`                            | Updates an existing vehicle.              |
| DELETE | `/{id}`                            | Deletes a vehicle by ID.                  |
| GET    | `/{id}/maintenances`               | Lists all maintenance records of a vehicle.|
| POST   | `/{id}/maintenances`               | Adds a new maintenance record to a vehicle.|

---

## Error Handling

Endpoints return standard HTTP status codes:
- `200 OK` for successful GET and PUT operations.
- `201 Created` for successful POST operations.
- `204 No Content` for successful DELETE operations.
- `500 Internal Server Error` for server errors, providing details in the response.
