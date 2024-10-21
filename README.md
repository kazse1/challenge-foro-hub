# Foro-Hub
Challenge Foro Hub

## Descripcion
El proyecto consiste en la implementacion de un foro que permita a los usuarios postear preguntas respecto a distintos topicos, a la vez de poder visualizar los topicos existentes, eliminar algun topico en cuestion o hacer alguna actualizacion a un topico, todo esto considerando que solo usuarios que esten registrados en la base de datos podran hacer dichos cambios. La manera de poder hacer estas solictudes es mediante el programa Insomnia en el cual es necesario configurar las HTTP request para poder acceder al respectivo servidor, en nuestro caso, el servidor se incia de forma local en el puerto 8080.

## Requisitos
* Java (versión 17 en adelante)
* Spring Boot (versión 3.3.1)
* MySQL
* IDE Java (Eclipse, IntelliJ IDEA, etc.)
* Insomnia

Tome en consideracion que en el documento application.properties datos sensibles como contraseña, usuario, etc. aparecen como variables de entorno, por lo que para que el programa funcione es necesario ajustar estas variables a las propias necesidades. Asi mismo, en la base de datos de usuarios las contraseñas se guardan de forma encriptada haciendo uso de Bcrypt Password Generator, la cual es una herramieta disponible en https://www.browserling.com/tools/bcrypt.
