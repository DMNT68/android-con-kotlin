# Proyecto Casas - Android con Kotlin

Este es un proyecto de práctica desarrollado como parte del curso de **Píldoras Informáticas** para aprender desarrollo de aplicaciones Android utilizando **Kotlin** y **Jetpack Compose**.

El Objetivo del proyecto es aprender a navegar entre pantallas

##  Descripción
La aplicación es una galería interactiva de casas que permite a los usuarios:
- Visualizar una lista de diferentes tipos de viviendas (mediterráneas, rústicas, modernas, etc.).
- Ver detalles específicos de cada casa, incluyendo una imagen ampliada y una descripción.
- Interactuar con la interfaz mediante cambios de colores dinámicos.
- Navegación fluida entre pantallas mediante Jetpack Navigation.

##  Tecnologías Utilizadas
- **Kotlin**: Lenguaje de programación principal.
- **Jetpack Compose**: Toolkit moderno para construir interfaces de usuario nativas.
- **Material Design 3**: Sistema de diseño para una interfaz moderna y coherente.
- **Jetpack Navigation**: Para la gestión de rutas y pantallas.
  - **NavController**: Es el motor principal que gestiona el flujo entre pantallas. Funciona como el "director de orquesta" que sabe en qué pantalla estamos y a cuál queremos ir, manteniendo el historial (la pila) de navegación.
  - **NavHost**: Actúa como el mapa de la aplicación, donde se definen todas las rutas y se vinculan con sus respectivos Composables.
- **State Management**: Uso de `remember`, `mutableStateOf` y `Animatable` para una UI reactiva.

##  Estructura del Proyecto
- `ui/pantallas/`: Contiene los composables de cada pantalla (`Inicio`, `Galeria`, `Detalle`).
- `data/`: Repositorio y modelos de datos para las casas.
- `ui/theme/`: Configuración de colores, tipografía y temas de la aplicación.

##  Funcionalidades Destacadas
- **Zoom Interactivo**: Capacidad de hacer zoom en las imágenes de detalle.
- **Temas Dinámicos**: Soporte para colores personalizados y adaptación de UI.
- **Diseño Adaptativo**: Uso de `Scaffold` y `Safe Areas` para garantizar que la app se vea bien en cualquier dispositivo.

---
Desarrollado con ❤️ durante el aprendizaje de Android con Kotlin.
