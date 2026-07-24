fun main () {
    tiposDatos()
}

// Funciones, son bloques de código que permite resolver un problema
fun tiposDatos(){
    var nombre:String = "Andrés"            // variable string poniendo explicitamente el tipo de dato
    val apellido = "Salgado"                // constante string si poner tipo de dato, kotlin infiere el tipo
    var edad:Short = 30                     // variable entero (short)
    var esMayorEdad = true                  // variable boolean

    print("El nombre de la persona es: " + nombre)              // imprimir en consola sin salto de línea
    println(" su apellido es: $apellido")                       // imprimir en consola con salto de línea
    println("Es mayor de edad: " + esMayorEdad)                 // Concatenación con +
    println("Tiene la edad de: $edad")                          // Concatenacion con template
}