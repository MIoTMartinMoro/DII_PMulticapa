![WebServices](https://img.shields.io/badge/WebServices-REST-green.svg) ![WebServices](https://img.shields.io/badge/API-JAXRS-red.svg)

# DII_PMulticapa

Proyecto multicapa basada en servicios web para la asignatura DII del MIOT en el que se puede crear, leer, actualizar y borrar localidades con su longitud y latitud. Consiste en dos proyectos:

- localidadREST es la aplicación servidor.
- localidadRESTCliente es la aplicación cliente.

## Índice

1. [Dependencias](#1-dependencias)
2. [Instalar entorno](#2-instalar-entorno)
3. [Configurar entorno](#3-configurar-entorno)
4. [Ejecutar aplicación](#4-ejecutar-aplicación)

## 1. Dependencias

**localidadREST** y **localidadRESTCliente** son dos aplicaciones basadas en servicios web REST y utiliza una base de datos relacional para almacenar los datos. Antes de empezar hay que tener instalado:

- [JDK8](https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html).
- [Eclipse J2EE](https://www.eclipse.org/).
- [MySQL](https://www.mysql.com/).
- [Apache Tomcat](https://tomcat.apache.org/).
- [Connector/J](https://dev.mysql.com/downloads/connector/j/5.1.html).
- [Apache CXF](https://cxf.apache.org/).

## 2. Instalar entorno

En este punto se explicará como instalar todas las dependenncias que necesitamos. La instalación está hecha en Ubuntu 18.04.

### 2.1. Instalar JDK8

Instala el JDK, en este caso, la versión 8:

#### Paso 1: Añadir PPA de terceros a Ubuntu

```sh
sudo add-apt-repository ppa:webupd8team/java
```

#### Paso 2: Descargar el instalador de Oracle Java 8

```sh
sudo apt update
sudo apt install -y oracle-java8-installer
```

Sigue los pasos que aparezcan en la terminal.

#### Paso 3: Configurar Oracle JDK8 por defecto

```sh
sudo apt install -y oracle-java8-set-default
```

Comprueba que se ha instalado bien y configurado por defecto con:

```sh
javac -version
```
Salida esperada: "javac 1.8.x"

### 2.2. Instalar Eclipse J2EE

1. Descarga la versión de Linux para nuestra arquitectura desde la [web de Eclipse](http://www.eclipse.org/downloads/packages/release/2018-09/r/eclipse-ide-java-ee-developers). A la derecha hay una columna que pone *Download Links* donde se puede descargar para varios SO.
2. Extrae Eclipse en el directorio que quieras. Obtendrás un directorio con el nombre *eclipse* y su versión y dentro de ésta un directorio de nombre *eclipse*. Preferiblemente copia este último directorio en el path que quieras.

### 2.3. Instalar servidor MySQL

Instala el paquete `mysql-server` del repositorio oficial de Ubuntu.

```sh
sudo apt update
sudo apt install -y mysql-server
```

Después se debe instalar de forma segura. El siguiente comando abrirá un instalador CLI con preguntas Sí/No. Leelas con cuidado y responde según corresponda.

```sh
sudo mysql_secure_installation
```

Recomendable crear un nuevo usuario.

### 2.4. Instalar Apache Tomcat

1. Descarga la distribución Core de [Tomcat 7](https://tomcat.apache.org/download-70.cgi).
2. Extrae Tomcat en el directorio que quieras, una buena opción es dentro de la carpeta *eclipse* descargada [anteriormente](#22-instalar-eclipse-j2ee).

### 2.5. Instalar Connector/J

Es un driver que conecta nuestra aplicación Java con MySQL.

1. Entra en la web de [descargas](https://dev.mysql.com/downloads/connector/j/) de MySQL.
2. Seleciona *Ubuntu Linux* como SO y la versión de SO que uses, en este caso: *Ubuntu Linux 18.04*.
3. Descargar el paquete DEB e instalalo con doble click sobre él.

### 2.6. Instalar Apache CXF

1. Descarga la distribución binaria de [Apache CXF 3.2](http://cxf.apache.org/download.html).
2. Comprueba la integridad de los ficheros según explica en la web.
3. Extrae CXF en el directorio que quieras, una buena opción es dentro de la carpeta *eclipse* descargada [anteriormente](#22-instalar-eclipse-j2ee).

## 3. Configurar entorno

En este punto se explicará como configuar el programa *Eclipse* para poder ejecutar nuestra aplicación.

### 3.1. Ejecutar Eclipse

Para abrir la aplicación ejecuta el fichero *eclipse* dentro de la carpeta *eclipse* descargada [anteriormente](#22-instalar-eclipse-j2ee).

### 3.2. Seleccionar JDK8

1. En la barra de herramientas abre "Window>Preferences", desglosa "Java" y abre "Installed JREs".
2. Pulsa el botón "Add", elige "Standar VM" y pulsa "Next".
3. En "JRE home" elige el directorio: "/usr/lib/jvm/java-oracle-8" y pulsa "Finish".
4. Márcalo y pulsa "Apply".

### 3.3. Instalar servidor Tomcat 7

1. En la barra de herramientas abre "Window>Preferences", desglosa "Server" y abre "Runtime Evironment".
2. Pulsa el botón "Add", elige "Apache Tomcat v7.0" y pulsa "Next".
3. En "Browse" elige el path a la carpeta descargada [anteriormente](#24-instalar-apache-tomcat) y pulsa "Finish".
4. Abre la pestaña "Servers" de la ventana inferior de *Eclipse* y crea un nuevo servidor Tomcat v7.0.

### 3.4. Añadir driver Connector/J

1. En la barra de herramientas abre "Run>Run Configurations" y haz doble click en "Apache Tomcat". Se creará una nueva configuración.
2. Abre la pestaña "Classpath", click en "User Entries" y pulsa "Add External JARs".
3. Navega hasta el directorio "/usr/share/java" y elige "mysql-connector-java-{version}.jar" y pulsa "Apply".

### 3.5. Configurar CXF facet

1. En la barra de herramientas abre "Window>Preferences", desglosa "Web Services" y abre "CXF 2.x Preferences".
2. Pulsa "Add" y en "Browse" elige el path a la carpeta descargada [anteriormente](#26-instalar-apache-cxf) y pulsa "Finish".
3. Márcalo y pulsa "Apply".
4. Desglosa "Web Services" y abre "Server and Runtime". Elige "Tomcat v7.0 Server" como Server runtime y "Apache CXF 2.x" como Web service runtime y pulsa "Apply".

## 4. Ejecutar aplicación

En este punto se explicará como desplegar la aplicación en Ubuntu 18.04. Se debe tener instalado y configurado el entorno como se ha explicado en los puntos anteriores y tener instalada el programa `git`.

### 4.1. Clonar proyecto

```sh
git clone https://github.com/MIoTMartinMoro/DII_PMulticapa.git
cd DII_PMulticapa
```

### 4.2. Crear base de datos

Crea la base de datos ejecutando `mysql -u {usuario} -p < localidad.sql`

### 4.3. Crear proyecto servidor

1. Crear un nuevo proyecto desde "File>New>Dynamic Web Project" de nombre "localidadREST" (Si no se llama así luego se deberá cambiar la url a la que se conecta el cliente).
2. Abrir "Properties" pinchando con el botón derecho sobre el proyecto.
3. Abrir "Project Facets", marcar "CXF 2.x Web Services" y pulsar en "Apply".
4. Sustituir los directorios "src" y "WebContent" por los de el directorio "localidadREST" descargado del repositorio de *GitHub* y refrescar el proyecto.
5. Abrir "src/integracion/localidad/imp/DAOLocalidadImp" y en la línea 17 sustituir el usuario y contraseña (Aparecerán "masteriot" en ambos casos) por tu usuario y contraseña de MySQL.
6. Abre la pestaña "Servers" de la ventana inferior de *Eclipse*, pulsa con el boón derecho el servidor Tomcat que aparece, entra en "Add and Remove", añade "localidadREST" y pulsa "Finish".

### 4.3. Crear proyecto cliente

1. Crear un nuevo proyecto desde "File>New>Dynamic Web Project" con cualquier nombre.
2. Abrir "Properties" pinchando con el botón derecho sobre el proyecto.
3. Abrir "Project Facets", marcar "CXF 2.x Web Services" y pulsar en "Apply".
4. Sustituir los directorios "src" y "WebContent" por los de el directorio "localidadRESTCliente" descargado del repositorio de *GitHub* y refrescar el proyecto.
5. Ejecutar aplicación pulsando con botón derecho sobre el proyecto, correr como "Run As>Run on Server", elegir el servidor Tomcat creado [anteriormente](#33-instalar-servidor-tomcat-7) y pulsar en "Finish".

Si fuese necesario desde la pestaña "Servers" de la ventana inferior de *Eclipse* se puede arrancar, restaurar y parar el servidor.
