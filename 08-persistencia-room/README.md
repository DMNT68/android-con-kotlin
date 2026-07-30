# Persistencia de datos con Room

Este proyecto es un ejemplo práctico de cómo implementar la persistencia de datos en aplicaciones Android utilizando la librería **Room**.

## Descripción

El objetivo de este proyecto es demostrar el uso de Room para gestionar una base de datos local de forma eficiente y segura, integrándolo con componentes modernos de Android como **Jetpack Compose**.

## Tecnologías Utilizadas

*   **Lenguaje:** Kotlin
*   **UI Framework:** Jetpack Compose
*   **Base de Datos:** Room Persistence Library
*   **Gestión de Estado:** Flow & ViewModel
*   **Inyección de Dependencias:** Inyectado manualmente vía ViewModelProvider

## Conceptos Clave de Kotlin en Room

Para implementar Room en este proyecto, se han utilizado tres pilares fundamentales de Kotlin que definen la estructura y el acceso a los datos:

### 1. Interface (Interfaz)
Se utiliza para definir el **DAO (Data Access Object)**. Actúa como un contrato que especifica qué operaciones (Insertar, Consultar, Eliminar, Actualizar) se pueden realizar sobre la base de datos sin preocuparnos por la implementación interna de SQL.
*   **Ejemplo:** `TareoDao`.

### 2. Clase Abstracta (`abstract class`)
Se utiliza para definir la **Base de Datos**. Es una clase que no se puede instanciar directamente y sirve como plantilla. Room la utiliza para generar la implementación real que conecta los DAOs con el almacenamiento físico.
*   **Ejemplo:** `TareaDatabase`.

### 3. Companion Object (Objeto Compañero)
Se utiliza dentro de la clase de la base de datos para implementar el **Patrón Singleton**. Permite tener un punto de acceso global y único a la base de datos (similar al uso de `static` en otros lenguajes), garantizando que solo exista una instancia activa para evitar conflictos de escritura.
*   **Ejemplo:** Método `getDatabase` dentro de `TareaDatabase`.

## Conceptos Avanzados de Jetpack Compose Aplicados

Durante el desarrollo de la interfaz, se han aplicado patrones avanzados para garantizar el rendimiento y la mantenibilidad:

### 1. State Hoisting (Elevación de Estado)
Hemos dividido las pantallas en dos tipos de Composables:
*   **Stateful (Con estado):** Gestiona la lógica y la conexión con el `ViewModel`.
*   **Stateless (Sin estado):** Recibe solo datos puros y lambdas para eventos. Esto permite renderizar **Previews** en Android Studio de forma instantánea sin necesidad de una base de datos real.

### 2. Inmutabilidad y Recomposición
Para que Compose detecte cambios en los elementos de la lista (como marcar una tarea como completada), es vital usar **Data Classes inmutables** (`val`). 
*   **Patrón:** No mutamos el objeto directamente. Usamos el método `.copy()` para crear una nueva instancia. Compose detecta el cambio de referencia y fuerza la actualización visual del icono de check.

### 3. Flow y Reactividad
La base de datos devuelve un `Flow<List<Tarea>>`. El Composable lo observa mediante `.collectAsState()`, lo que permite que cualquier cambio en la base de datos (incluso desde otros hilos o procesos) se refleje automáticamente en la interfaz de usuario en tiempo real.

---
*Este proyecto forma parte del curso de Android con Kotlin.*
