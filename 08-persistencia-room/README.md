# Persistencia de datos con Room

Este proyecto es un ejemplo práctico de cómo implementar la persistencia de datos en aplicaciones Android utilizando la librería **Room**.

## Descripción

El objetivo de este proyecto es demostrar el uso de Room para gestionar una base de datos local de forma eficiente y segura, integrándolo con componentes modernos de Android como **Jetpack Compose**.

## Tecnologías Utilizadas

*   **Lenguaje:** Kotlin
*   **UI Framework:** Jetpack Compose
*   **Base de Datos:** Room Persistence Library
*   **Arquitectura:** MVVM (Model-View-ViewModel)

## Estructura del Proyecto

El proyecto sigue una estructura modular estándar de Android:

*   `:app`: Módulo principal de la aplicación.
    *   `com.example.persistenciadedatosconroom`: Paquete base.
    *   `ui.theme`: Definiciones de temas, colores y tipografía de Compose.

## Conceptos Clave de Kotlin en Room

Para implementar Room en este proyecto, se han utilizado tres pilares fundamentales de Kotlin que definen la estructura y el acceso a los datos:

### 1. Interface (Interfaz)
Se utiliza para definir el **DAO (Data Access Object)**. Actúa como un contrato que especifica qué operaciones (Insertar, Consultar, Eliminar) se pueden realizar sobre la base de datos sin preocuparnos por la implementación interna de SQL.
*   **Ejemplo:** `TareoDao`.

### 2. Clase Abstracta (`abstract class`)
Se utiliza para definir la **Base de Datos**. Es una clase que no se puede instanciar directamente y sirve como plantilla. Room la utiliza para generar la implementación real que conecta los DAOs con el almacenamiento físico.
*   **Ejemplo:** `TareaDatabase`.

### 3. Companion Object (Objeto Compañero)
Se utiliza dentro de la clase de la base de datos para implementar el **Patrón Singleton**. Permite tener un punto de acceso global y único a la base de datos (similar al uso de `static` en otros lenguajes), garantizando que solo exista una instancia activa para evitar conflictos de escritura.
*   **Ejemplo:** Método `getDatabase` dentro de `TareaDatabase`.

---
*Este proyecto forma parte del curso de Android con Kotlin.*
