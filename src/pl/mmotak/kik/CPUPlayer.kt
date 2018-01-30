package pl.mmotak.kik

class CPUPlayer(val t: Char) : Player(t) {
    private var place = 1

    // just select the next
    override fun selectPlace(): Int = place++
}