# POO_1

Este es un proyecto de Android desarrollado como parte del curso de Android con Kotlin de Píldoras Informáticas.

## Estructura del Proyecto

```text
05-POO_1/
├── app/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/com/example/poo_1/
│   │   │   │   ├── model/
│   │   │   │   │   ├── Rectangulo.kt
│   │   │   │   │   ├── MiDimension.kt
│   │   │   │   │   ├── RectaguloSinBordes.kt
│   │   │   │   │   └── RectanguloConBordes.kt
│   │   │   │   └── MainActivity.kt
│   │   │   └── res/
│   │   └── test/
│   └── build.gradle.kts
├── gradle/
├── build.gradle.kts
├── settings.gradle.kts
└── README.md
```

- `app/`: Contiene el código fuente, recursos y configuración de la aplicación Android.
- `gradle/`: Archivos de configuración del sistema de construcción Gradle.

## Requisitos

- Android Studio Koala | 2024.1.1 o superior.
- JDK 17 o superior.
- Kotlin 1.9.0 o superior.

## Cómo ejecutar

1. Abre el proyecto en Android Studio.
2. Sincroniza los archivos de Gradle.
3. Ejecuta la aplicación en un emulador o dispositivo físico.

## Conceptos de POO Aplicados

En este proyecto se han puesto en práctica los siguientes conceptos fundamentales de la Programación Orientada a Objetos con Kotlin:

- **Clases y Objetos**: Definición de la estructura y comportamiento de entidades como `Rectangulo`.
- **Herencia**: Uso de `open class` para permitir que clases como `RectanguloConBordes` y `RectaguloSinBordes` extiendan la funcionalidad de una clase base.
- **Clases Final**: En Kotlin, las clases son `final` por defecto, lo que significa que no pueden ser heredadas a menos que se marquen explícitamente como `open`. Esto ayuda a garantizar la seguridad y el diseño intencional de la jerarquía de clases (ej. `RectaguloSinBordes`).
- **Constructores**: Implementación de constructores primarios y secundarios para inicializar objetos con diferentes parámetros.
- **Data Classes**: Uso de `data class` (`MiDimension`) para el manejo eficiente de contenedores de datos, aprovechando funciones generadas automáticamente como `copy`, `equals` y `hashCode`.
- **Sobreescritura de Métodos (Overriding)**: Modificación del comportamiento de métodos heredados mediante la palabra clave `override`.
- **Companion Objects**: Definición de miembros estáticos dentro de una clase para compartir constantes y métodos de utilidad (ej. `ManejoColor`).
- **Clases Anidadas (Nested Classes)**: Organización de clases dentro de otras para mejorar la encapsulación y modularidad. En este proyecto, se utiliza la clase `ManejoColor` dentro de `RectanguloConBordes` para agrupar la lógica de gestión de colores de forma desacoplada, facilitando el mantenimiento y controlando la visibilidad.
- **Encapsulación**: Agrupación de datos y métodos relacionados en clases y el uso de propiedades para controlar el acceso al estado del objeto.
- **Polimorfismo**: Capacidad de tratar objetos de diferentes subclases como instancias de una clase común.
