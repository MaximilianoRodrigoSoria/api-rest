![rating](https://img.shields.io/badge/Java-17-orange?style=flat-square) ![rating](https://img.shields.io/badge/Spring%20Boot-3.1.5-brighred?style=flat-square)

![Docker Compose](/docs/img/spring-challenger.gif)

<!-- <img src="./docs/img/spring-challenger.gif" width="300" height="100"> -->


# 🚩Tabla de Contenido

- [Descripción](#descripcion)
- [Funcionalidades](#funcionalidades)
    - [Suma con Porcentaje](#suma-con-porcentaje)
    - [Historial de Llamadas](#historial-de-llamadas)
    - [Límite de RPM](#límite-de-rpm)
    - [Errores HTTP](#errores-http)
    - [Pruebas Unitarias](#pruebas-unitarias)
    - [Docker Container](#docker-container)
    - [Documentación](#documentación)
- [Repositorio y Despliegue](#repositorio-y-despliegue)
- [Links útiles](#links-utiles)

## 📒Descripcion 


Esta es una API REST desarrollada en Spring Boot con Java 17, que proporciona las siguientes funcionalidades:


### 🛠️ Funcionalidades

1. **Suma con Porcentaje**
    - La API tiene un servicio que recibe dos números, los suma y les aplica un porcentaje adquirido de un servicio externo.
    - El servicio externo puede ser un mock y devuelve el porcentaje a sumar.
    - Si el servicio externo falla, se utiliza el último valor retornado. Si no hay valor, se devuelve un error en la API.

2. **Historial de Llamadas**
    - La API registra un historial de todos los llamados a los endpoints, incluyendo las respuestas en caso de éxito.
    - El historial se almacena en una base de datos PostgreSQL.
    - El guardado del historial no afecta el tiempo de respuesta del servicio principal.

3. **Límite de RPM**
    - La API admite un máximo de 3 solicitudes por minuto (RPM). Si se supera este umbral, se devuelve un error HTTP con un mensaje adecuado.

4. **Errores HTTP**
    - La API incluye mensajes y descripciones adecuadas para la serie de errores 4XX.

5. **Pruebas Unitarias**
    - Se han incluido pruebas unitarias para verificar el funcionamiento de la API.

6. **Docker Container**
    - La aplicación se puede desplegar en un contenedor Docker. Tanto la API como la base de datos PostgreSQL se ejecutan en contenedores Docker. Se recomienda el uso de Docker Compose para gestionarlos.

7. **Documentación**
    - Se proporciona un archivo de colección de Postman y una documentación Swagger para probar la API.

<a name="repositorio-y-despliegue"></a>
## 📦 Repositorio y Despliegue

El código fuente de esta API está disponible en el siguiente repositorio público:


[Repositorio en GitHub](https://github.com/MaximilianoRodrigoSoria/api-rest)

Para desplegar la aplicación, sigue las siguientes instrucciones:

1. Clona el repositorio en tu entorno de desarrollo.

2. Asegúrate de tener Docker y Docker Compose instalados en tu sistema.

3. Para armar la imagen de la api-rest

 ```bash
   docker build -t api-rest:001 .
   ```
4. Para correr la imagen podemos usar

 ```bash
   docker run -p 8080:8080 --name api-rest api-rest

   ```
![Docker Compose](/docs/img/docker-compose.png)


5. Ejecuta el siguiente comando en la raíz del proyecto para iniciar la aplicación y la base de datos:

   ```bash
   docker-compose up
   ```

4. La API estará disponible en `http://localhost:8080/api-rest/swagger-ui.html`. Accede a la documentación de la API a través de la ruta correspondiente (Postman o Swagger) para probarla.

Recuerda que esta aplicación está diseñada para funcionar en un entorno distribuido, por lo que puede haber varias réplicas del servicio en funcionamiento en paralelo.

¡Disfruta probando la API y explorando su funcionalidad!

---
<a name="links-utiles"></a>
## 🔗 Links utiles

### ✴️ Wiremock

WireMock es una biblioteca de simulación de servicios web (stubbing) que se utiliza comúnmente en pruebas unitarias e integración de software. Permite a los desarrolladores simular servicios HTTP/HTTPS, como API REST, para crear entornos de prueba controlados y predecibles

En este caso esta mockeado el serviio de percentage

#### URL

> http://localhost:9001/percentage

#### Response

> { "value": 30 }

### ✴️ Swagger


Swagger es un conjunto de herramientas y especificaciones que se utiliza para diseñar, crear y documentar APIs de manera sencilla y efectiva. Su objetivo principal es facilitar la colaboración entre equipos de desarrollo y documentación al proporcionar una forma estandarizada de describir y exponer las capacidades de una API.

#### URL

> http://localhost:8080/api-rest/swagger-ui.html
