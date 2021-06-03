# App Demo
App desarrollada 100% en Kotlin

## App Demo utilizando Clean Architecture

Esta app pretende ser una pequeña guía de como se puden crear app en Android basada en los prinpios de Clean Architecture.

La aplicación consta de una pantalla que presenta información al usuario en forma de lista, se puede acceder al detalle de cada elemento

<table>
  <tr>
    <td>
<img src="https://github.com/dgcodes-app/TestCleanArchitecture/blob/main/media/img01.png" width="350px"> 
    </td>
    <td>
<img src="https://github.com/dgcodes-app/TestCleanArchitecture/blob/main/media/img02.png" width="350px"> 
    </td>
  </tr>
  </table>
  


La aplicación es muy sencilla, la finalidad de esta app es mostrar la forma de implementar Clean Architecture

<img src="https://github.com/dgcodes-app/TestCleanArchitecture/blob/main/media/v1.gif" width="350px"> 

## Capas Implementadas

### Presentación
Pantallas que verá el usuario y gestión de las interacciones del usuario

La presentacion de la informacion en pantalla se realiza utilizando el patron de diseño MVP, estableciendo un Presenter para cada Activity que será el encargado de gestionar los datos a presentar dejando a la propia Activity lo más libre de lógica posible.
En los presenter tambien se ha implementado Corrutinas, cambiando asi el hilo de ejecucción para relizar las llamadas  a WS en un hilo distinto al principal

### Dominio
Definición de las reglas de negocio  y los diferntes casos de uso que se van a utilizar


### Accesos a datos
Definición de los origenes de datos y como se puede acceder a ellos

Se han creado los respectivos repositorios para acceder a la información
En esta app se tienen 2 origenes de datos: WS (vía Retrofit) y Shared Prefences


## Librerías utilizadas

  - Koin : Para inyeccion de dependencias
  - Retrofit: LLamadas a webservices
  - Corrutinas: Implementación de corrutinas en Kotlin
  - Glide: Carga y gestión de imágenes
  - de.hdodenhof:circleimageview: Aspecto circular la las imagenes
  - Calligraphy: Modificar tipos de letra en la aplicación
