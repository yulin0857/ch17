class Barrel< T>(var item: T) {
}

fun main(arg: Array<String>){
    var fadoraBarrel: Barrel<Fedora> = Barrel(Fedora("a generic-looking fedora", 15))
    var lootBarrel: Barrel<Loot> = Barrel(Coin(15))

    lootBarrel = fedoraBarrel
    lootBarrel.item =Coin(15)
}