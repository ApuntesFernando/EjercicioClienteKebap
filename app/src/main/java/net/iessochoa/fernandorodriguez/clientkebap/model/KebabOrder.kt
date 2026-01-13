package net.iessochoa.fernandorodriguez.clientkebap.model

enum class ProductType(){

    DURUM, BOX, PIZZA, PLATO,

}

enum class Vegetables(){
    TOMATE, LECHUGA, CEBOLLA, ACEITUNA, MAIZ
}

enum class ProductSize(){
    PEQUEÑO, MEDIANO, GRANDE
}

data class KebapOrder(
    val id: Int = 0,
    val productType: ProductType = ProductType.DURUM,
    val vegetables: List<Vegetables> = emptyList(),
    val clientName: String = "",
    val size: ProductSize = ProductSize.MEDIANO,
    val basePrice: Double = 0.0,
    val notes: String = "",
    val delivery: Boolean = false,
    val salsas: String = ""
)

fun KebapOrder.productPrice():Double{

    val precioProducto = when(productType) {

        ProductType.DURUM -> 5.0
        ProductType.BOX -> 6.0
        ProductType.PIZZA -> 7.0
        ProductType.PLATO -> 8.0

    }

    val precioSize = when(size) {
        ProductSize.PEQUEÑO -> 0.0
        ProductSize.MEDIANO -> 1.0
        ProductSize.GRANDE -> 2.0
    }

    val ingredientesExtra = vegetables.size * 0.5

    return precioProducto + ingredientesExtra + precioSize

}