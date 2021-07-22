

import kotlin.math.PI
import kotlin.math.sqrt

fun main() {
    val squareCabin = SquareCabin(5, 50.0)
    with(squareCabin) {
        println("\nSquare Cabin\n============")
        println("Capacity: $capacity")
        println("Material: $buildingMaterial")
        println("Has room? ${hasRoom()}")
        println("Floor area: ${floorArea()}")
        getRoom()
        println("Has room? ${hasRoom()}")
        println("Carpet size: ${calculateMaxCarpetSize()}")
    }

    val roundHut = RoundHut(6, 10.0)

    with(roundHut) {
        println("\nRound Hut \n===========")
        println("Material: $buildingMaterial")
        println("Capacity: $capacity")
        println("Hasroom? ${hasRoom()}")
        println("Floor area: ${floorArea()}")
        getRoom()
        println("Has room? ${hasRoom()}")
        println("Carpet size: ${calculateMaxCarpetSize()}")
    }

    val roundTower = RoundTower(4, 15.5)

    with(roundTower) {
        println("\nRound Tower\n==========")
        println("Material: $buildingMaterial")
        println("Capacity: $capacity")
        println("Has room? ${hasRoom()}")
        println("Floor area: ${floorArea()}")
        getRoom()
        println("Has room? ${hasRoom()}")
        println("Carpet size: ${calculateMaxCarpetSize()}")
    }
}

abstract class Dwelling(private var residents: Int) {
    abstract val buildingMaterial: String
    abstract val capacity: Int

    fun hasRoom(): Boolean {
        return residents < capacity
    }

    abstract fun floorArea(): Double

    fun getRoom() {
        if (capacity > residents) {
            residents++
            println("Quarto Ocupado!")
        } else {
            println("Desculpe, não existem vagas disponiveis")
        }
    }
    abstract fun calculateMaxCarpetSize(): Double
}

class SquareCabin(residents: Int, val lenght: Double) : Dwelling(residents) {
    override val buildingMaterial = "Madeira"
    override val capacity = 6
    override fun floorArea(): Double {
        return lenght * lenght
    }
    override fun calculateMaxCarpetSize(): Double {
        return floorArea()
    }
}

open class RoundHut(residents: Int, val radius: Double) : Dwelling(residents) {
    override val buildingMaterial = "Straw"
    override val capacity = 4
    override fun floorArea(): Double {
        return PI * radius * radius
    }

    override fun calculateMaxCarpetSize(): Double {
        val diamenter = 2 * radius
        return sqrt(diamenter * diamenter / 2)
    }
}

class RoundTower(residents: Int, radius: Double, val floors: Int = 2) : RoundHut(residents, radius) {
    override val buildingMaterial = "Stone"
    override val capacity = 4 * floors
    override fun floorArea(): Double {
        return super.floorArea() * floors
    }
    override fun calculateMaxCarpetSize(): Double {
        val diamenter = 2 * radius
        return super.calculateMaxCarpetSize() * floors
    }
}
