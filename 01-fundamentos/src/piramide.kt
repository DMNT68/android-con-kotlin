fun main() {
    println("Piramide!!!")
    val respuesta = piramide(7)
    print(respuesta)
}


fun piramide(niveles: Int = 1): String {
    var respuesta: String = ""

    if (niveles < 0) return "No se acepta niveles menores a 1"

    if (niveles == 1) return "*"

    var espacios = niveles - 1
    var horizontal = niveles

    for (n in 1..niveles) {
        for (h in 1..horizontal) {
            if (espacios < h) respuesta += "*"
            else respuesta += " "
        }
        horizontal++
        espacios--
        if (n < niveles) respuesta += "\n"
    }

    return respuesta
}