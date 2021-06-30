class LootBox<T : Loot>(vararg item: T) {
    var open = false
    private var loot:Array<out T> =item

    operator fun get(index: Int): T? =loot[index].takeIf { open }

    fun fetch(item: Int): T?{
        return loot[item].takeIf { open }
    }
    fun <R> fetch(item: Int, lootModFunction: (T) ->R): R?{
        return lootModFunction(loot[item]).takeIf { open }
    }
}

open class Loot(val value: Int)

class Fedora(val name: String, value:Int):Loot(value)

class Coin(value: Int):Loot(value)

fun main(arg: Array<String>){
    val lootBoxOne: LootBox<Fedora> = LootBox(Fedora("a generic-looking fedora",15),Fedora("a dazzling magenta fedora", 25))
    val lootBoxTwo: LootBox<Coin> = LootBox(Coin(15))

    lootBoxOne.open = true
    lootBoxOne.fetch(1)?.run {
        println("妳從抽獎箱抽到一頂 $name !")
    }
    val coin=lootBoxOne.fetch(0){
        Coin(it.value*3)
    }
    coin?.let { println("價值 ${it.value} 個金幣") }
}