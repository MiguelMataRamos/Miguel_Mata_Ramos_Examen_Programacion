package com.example.miguel_mata_ramos_examen_programacion

import kotlin.math.PI

//Ejercicio1
data class Videojuego(var nombre: String, var plataforma: String, var anio: Int)

//Ejercicio2
fun filtraJuegos(lista_juegos: List<Videojuego>, anio: Int): List<Videojuego> {
    var lista = mutableListOf<Videojuego>()
    for (juego in lista_juegos) {
        if (juego.anio == anio) {
            lista.add(juego)
        }
    }
    return lista
}

//Ejercicio3
fun mapaJuegos(lista_juegos: List<Videojuego>): Map<String, String> {
    var map = mutableMapOf<String, String>()
    for (juego in lista_juegos) {
        var j = map.getOrDefault(juego.plataforma, "")
        map[juego.plataforma] = j + " " + juego.nombre
    }

    return map
}

//Ejercicio4
fun plataformas(lista_juegos: List<Videojuego>): List<String> {
    println()
    var plataformas = mutableListOf<String>()

    for (juego in lista_juegos) {
        if (juego.plataforma !in plataformas) {
            plataformas.add(juego.plataforma)
        }
    }

    return plataformas
}

//Ejercicio5
open class Circunferencia(var radio: Double = 0.0) {
    var centro: List<Int> = listOf(0, 0)

    constructor(centro: List<Int>, punto: List<Int>) : this(){
        this.centro = centro
        this.radio = ((punto[0] - centro[0]) + (punto[1] - centro[1])).toDouble()
    }

    private fun longitud(): Double {
        return 2 * PI * radio
    }

    override fun toString(): String {
        return "Mi radio es de: $radio\n" +
                "Mi centro es: ${centro[0]},${centro[1]}\n" +
                "Mi longitud es de: ${longitud()}"
    }

}

//Ejercicio8
class Circulo(radio: Double, private var color: String) : Circunferencia(radio) {

    constructor(color: String, centro: List<Int>, punto: List<Int>) : this(radio = 0.0,color) {
        this.centro = centro
        this.radio = ((punto[0] - centro[0]) + (punto[1] - centro[1])).toDouble()
        this.color = color
    }

    private fun area(): Double {
        return (radio * radio) * PI
    }

    override fun toString(): String {
        return super.toString() + "\nMi color es: $color\n" +
                "Mi area es de : "+area()
    }

}

//Ejercicio9
class EquipoFutbol(var nombre: String, var pais: String)

//Ejercicio10
var lista_equipos = listOf(
    EquipoFutbol("Arenas", "España"),
    EquipoFutbol("Jun", "España"),
    EquipoFutbol("Polopos", "España"),
    EquipoFutbol("Paco", "España"),

    EquipoFutbol("Ahmed", "Marruecos"),
    EquipoFutbol("Abdul", "Marruecos"),
    EquipoFutbol("Muhamed", "Marruecos"),
    EquipoFutbol("Muhamed Segundo", "Marruecos"),

    EquipoFutbol("Torre", "Francia"),
    EquipoFutbol("Eiffel", "Francia"),
    EquipoFutbol("Croasan", "Francia"),
    EquipoFutbol("Mbappe", "Francia"),

    EquipoFutbol("Pijo", "Murcia"),
    EquipoFutbol("Acho", "Murcia"),
    EquipoFutbol("Desierto", "Murcia"),
    EquipoFutbol("Playa", "Murcia"),
)

//Ejercicio10.2
fun championsLeague(lista: List<EquipoFutbol>) {
    var lista2 = lista.toMutableList()
    for (i in 1..8) {
        var equipo1 = lista2.random()
        lista2.remove(equipo1)
        var equipo2 = lista2.random()
        lista2.remove(equipo2)

        println("Partido $i :")
        println("${equipo1.nombre}(${equipo1.pais}) --VS-- ${equipo2.nombre}(${equipo2.pais})")
        println("--------------------------")
    }
}

fun main() {
    //ej2
    var lista_juegos = listOf(
        Videojuego("Juego1", "PSP", 2006),
        Videojuego("Juego2", "DS", 2006),
        Videojuego("Juego3", "GAMEBOY", 2006),
        Videojuego("Juego4", "PSP", 2010),
        Videojuego("Juego5", "DS", 2010),
        Videojuego("Juego6", "GAMEBOY", 2010),
        Videojuego("Juego7", "PSP", 2002),
        Videojuego("Juego8", "DS", 2001),
        Videojuego("Juego9", "GAMEBOY", 2000),
        Videojuego("Extra1", "PSP", 2006),
        Videojuego("Extra2", "DS", 2006),
        Videojuego("Extra3", "GAMEBOY", 2006)

    )
    println(filtraJuegos(lista_juegos, 2010))

//    ej3
    print(mapaJuegos(filtraJuegos(lista_juegos, 2006)))

//    ej4
    println(plataformas(lista_juegos))

//    ej5
    var circunferencia1 = Circunferencia(4.0)
    var centro = listOf(1,1)
    var punto= listOf(1,6)
    var circunferencia2 = Circunferencia(centro,punto)

    println(circunferencia1)
    println(circunferencia2)

//    ej8
    var circulo1 = Circulo(3.4,"Rojo")
    var circulo2 = Circulo("Azul", centro, punto)
    println(circulo1)
    println(circulo2)

//    ej9
//    ej10
//    ej10.2
    championsLeague(lista_equipos)
}