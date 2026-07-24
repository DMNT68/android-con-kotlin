fun main () {
    arrays()
    calcularFactorial(4)
}

fun arrays () {
    var arregloNumeros:Array<Int> = arrayOf(1,2,3,4,5)          // Array de enteros, arrayOf método que permite inicializar el array con valores establecildos
    var nombreMeses = arrayOf("Enero","Febrero")                // Array de Strings (cadena de texto) infiriendo el tipo
    val mi_matriz = Array(5) {0}                           // Usando la Clase Array que permite establece el tamaño o posiciones del array (5), y {0} inicializa el array en 0 en todas la posiciones


    println(nombreMeses[1])         // imprime el elemento 2 de la posición 1

}

// loop o bucles
fun calcularFactorial(numero: Int): Long {
    var resultado = 1L
    for (i in 2..numero) {
        resultado *= i
        println("$i ---> $resultado")
    }
    println("El factorial de $numero es $resultado")
    return resultado
}