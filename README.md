# ForoHub

ForoHub es una aplicación diseñada para permitir a los usuarios registrados crear, gestionar y explorar tópicos en un ambiente escolar. Este proyecto utiliza Spring Boot, JPA, y una base de datos MySQL para su funcionamiento. Challenge realizado para ONE de Alura LATAM.

## Características

### 1. **Registro de Tópicos**
Los usuarios pueden crear nuevos tópicos enviando un request POST a la URL:
```
POST /topicos
```

#### Ejemplo de Body Entrante (JSON):
```json
{
  "titulo": "Problema en curso Java Basico",
  "mensaje": "El resultado de la pagina 3 esta incorrecto.",
  "nombreCurso": "Java Basico"
}
```

#### Ejemplo de Respuesta:
```json
{
  "id": 1,
  "titulo": "Problema en curso Java Basico",
  "mensaje": "El resultado de la pagina 3 esta incorrecto.",
  "nombreCurso": "Java Basico",
  "autor": "Allan Farias",
  "fechaCreacion": "03-01-2025",
  "status": "Publico"
}
```
- El campo `id` es generado automáticamente.
- El `autor` se asigna en base al usuario autenticado.
- La `fechaCreacion` se establece automáticamente al momento de registro.
- El `status` tiene el valor por defecto de "Publico".
- Ni el `titulo` ni el `mensaje` deben seer exactamente identicos a otro topico.

---

### 2. **Actualizar un Tópico**
Para modificar un tópico existente, se envía un request PUT a la URL:
```
PUT /topicos/{id}
```

#### Ejemplo de Body Entrante (JSON):
```json
{
  "id": 1,
  "titulo": "Problema resuelto en Java Basico",
  "mensaje": "La página 3 ahora está correcta.",
  "nombreCurso": "Java Basico"
}
```
- El `id` en el body debe coincidir con el `id` especificado en la URL.
- Solo se pueden modificar los campos `titulo`, `mensaje` y `nombreCurso`, el resto de datos se generan nuevamente.

#### Ejemplo de Respuesta:
```json
{
  "id": 1,
  "titulo": "Problema resuelto en Java Basico",
  "mensaje": "La página 3 ahora está correcta.",
  "nombreCurso": "Java Basico",
  "autor": "Allan Farias",
  "fechaCreacion": "01-01-2025",
  "status": "Publico"
}
```

---

### 3. **Listar Tópicos Públicos**
Para obtener una lista paginada de todos los tópicos públicos, se envía un request GET a la URL:
```
GET /topicos
```
- Devuelve 10 tópicos por página por defecto.

#### Ejemplo de Respuesta:
```json
[
  {
    "id": 1,
    "titulo": "Problema en curso Java Basico",
    "mensaje": "El resultado de la pagina 2 esta incorrecto.",
    "nombreCurso": "Java Basico",
    "autor": "Allan Farias",
    "fechaCreacion": "01-01-2025",
    "status": "Publico"
  }
  {
    "id": 2,
    "titulo": "Otro Problema en curso Java Basico",
    "mensaje": "El enunciado del ejercio 8 tiene faltas gramaticales.",
    "nombreCurso": "Java Basico",
    "autor": "Juan Pereira",
    "fechaCreacion": "02-01-2025",
    "status": "Publico"
  }
]
```

---

### 4. **Ver un Tópico Específico**
Para obtener los detalles completos de un tópico, se envía un request GET a la URL:
```
GET /topicos/{id}
```

#### Ejemplo de Respuesta:
```json
{
  "id": 1,
  "titulo": "Problema en curso Java Basico",
  "mensaje": "El resultado de la pagina 2 esta incorrecto.",
  "nombreCurso": "Java Basico",
  "autor": "allan.farias",
  "fechaCreacion": "01-01-2025T21:10:46.512309",
  "status": "Publico"
}
```

---

### 5. **Cambiar el Estado de un Tópico**
Los usuarios pueden alternar el estado de un tópico entre "Publico" y "Privado" enviando un request PUT a la URL:
```
PUT /topicos/{id}/toggle
```
- Este endpoint cambia el estado de un tópico existente en lugar de eliminarlo físicamente.

---

### 6. **Eliminar un Tópico**
Para eliminar completamente un tópico, se envía un request DELETE a la URL:
```
DELETE /topicos/{id}
```
- Este endpoint elimina físicamente el tópico de la base de datos.

---

## Seguridad
- Los usuarios deben estar autenticados para interactuar con los endpoints.
- El nombre de usuario sigue el formato: `nombre.apellido`.
- Todos los datos enviados deben cumplir las validaciones definidas para evitar errores o duplicados en la base de datos.

---

## Requerimientos Técnicos
- **Base de Datos**: MySQL
- **Framework**: Spring Boot
- **Migraciones**: Flyway

---

## Instalación
1. Clona este repositorio.
2. Configura la base de datos en el archivo `application.properties` con tus propias variables de entorno asi:

```java
spring.datasource.url=jdbc:mysql://${DB_HOST}/${DB_NAME}
spring.datasource.username=${DB_USER}
spring.datasource.password=${DB_PASSWORD}
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

server.error.include-stacktrace=never

api.security.secret=${JWT_SECRET}
```

3. Crea tu base de datos MySQL.
4. Inicia la aplicación en IntelliJ o tu plataforma preferido:

---

## Autor
- **Allan Farias**


