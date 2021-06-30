class LootBox<T>(item: T) {
    var open = false
    private var loot:T =item

    fun fetch(): T?{
        return loot.takeIf { open }
    }
}

class Fedora(val name: String, val value:Int)

class Coin(val value: Int)

fun main(arg: Array<String>){
    val lootBoxOne: LootBox<Fedora> = LootBox(Fedora("a generic-looking fedora",15))
    val lootBoxTwo: LootBox<Coin> = LootBox(Coin(15))
}