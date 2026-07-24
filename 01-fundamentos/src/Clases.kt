fun main() {

    val perro1 = Perro("Rufian","Pequeño", 9)
    val perro2 = Perro("Maximo","Mediano", -45)
    val perro3 = Perro("Linda", "Pequeño" )
    val perro4 = Perro("Grande" )
    val perro5 = Perro("Snick","Grande", 15, "Pastor Aleman", false,"Macho")

    println("El perro se llama ${perro1.nombre}, es de tamaño ${perro1.estatura}, y su edad es ${perro1.edad}")
    println("El perro se llama ${perro2.nombre}, es de tamaño ${perro2.estatura}, y su edad es ${perro2.edad}")
    println("El perro se llama ${perro3.nombre}, es de tamaño ${perro3.estatura}, y su edad es ${perro3.edad}")
    println("Nombre del perro:  ${perro4.nombre}, Tamaño: ${perro4.estatura}, edad: ${perro4.edad}")
    println("Nombre del perro:  ${perro5.nombre}, Tamaño: ${perro5.estatura}, edad: ${perro5.edad}, raza: ${perro5.raza}, Enfermo: ${if(perro5.enfermo) "si" else "no"}, Genero: ${perro5.genero}")

}
                // contructor principal con propiedades establecidas directamente
class Perro (var nombre:String, var estatura:String, var edad:Int) {

    // propiedades
    var raza:String = ""
    var enfermo:Boolean = false
    var genero:String = "Macho"

    // constructor secundario
    constructor(nombre:String, estatura:String): this(nombre,estatura,0)
    constructor(estatura: String):this("No se sabe",estatura)
    constructor(nombre:String, estatura:String, edad:Int, raza:String, enfermo:Boolean, genero:String) : this(nombre,estatura,edad) {
        this.raza = raza
        this.enfermo = enfermo
        this.genero = genero
    }

    init {
        if(edad < 0){
            println("La edad del perro ${nombre} debe ser un número positivo")
            edad = 0
        }
    }

    // metodos o funciones
    fun ladrar (){
        println("El perro ${this.edad} esta ladrando")
    }
}

/*
Modificadores de acceso: nos permite definir el nivel de acceso es decir, como se va a poder acceder a la función desde
fuera de la clase donde se a definido.
    public -->  modificador de acceso por defecto, pueden ser accedidas desde cualquier parte del código sin ningun tipo
                de excepcion
    private --> limita la visibilidad solo al archivo o clase en donde la función se haya definido
    protective --> similar a private, no se puede acceder fuera de la clase, pero, si estamos fuera heredando de una
                    clase donde hemos definido la función si podemos acceder, solo se aplica a las clases y a sus miembros
    intenal --> restringe al acceso a cualquier codigo dentro del mismo modulo( cojunto de archivos kotlin compilados juntos )

Palabras reservadas
    open --> indica que una función puede ser sobreescrita por una subclase.
    final --> contrario de open, prohibe sobrescribir una función. Si en una función no se define nada explicitamente está como final.
    abstract --> utilizado para definir funciones que no tienes implementación.
    override --> indica que una funcion esta proporcionando una implementacion abstracta o remplazando una funcion open de un superclase, la esta sobrescribiendo.
    operator --> permite a una función sobrecargar un operador.
    infix --> permite que la función sea llamada sin punto y sin parentesis.
    inline --> copia el codigo de la funcion para reducir la sobrecarga en la creacion de objetos.
    tailre --> indica que una función es rescursiva de cola, permite que el compilador la optimice para evitar desbordamientos de pila.
    suspend --> permite marcar una función suspendibles, pueden ser pausadas para luego ser renaudad. utilizada en programación asincrona.

 */
