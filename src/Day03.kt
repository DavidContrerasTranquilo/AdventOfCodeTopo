fun main(){
    fun String.getMaxJoltage():Int {
        val searchString = this.dropLast(1)
        (9 downTo 1).forEach { s ->
            val c = s.toString()[0]
            val index = searchString.indexOf(c)
            if (index != -1) {
                val firstDigit = this[index].toString()
                val secondDigit = this.drop(index + 1).max().toString()
                return (firstDigit + secondDigit).toInt()
            }
        }

        // should never get here
        throw IllegalStateException("Should not be here")
    }
    fun part1(input: List<String>):Int = input.sumOf { it.getMaxJoltage() }
    val input = readInput("Day03")
    println(part1(input))
    fun String.getMaxJoltage2():Long {
        var ret = this
        while (ret.length > 12) {
            var removed = false
            val lastIdx = ret.length-1
            for (idx in 0 until lastIdx) {
                if (ret[idx+1] > ret[idx]) {
                    ret = ret.removeRange(idx, idx+1)
                    removed = true
                    break
                }
            }
            if (!removed) {
                val numToDrop = ret.length - 12
                ret = ret.dropLast(numToDrop)
                break
            }
        }
        return ret.toLong()
    }

    fun part2(input: List<String>):Long = input.sumOf { it.getMaxJoltage2() }
    print(part2(input))

}