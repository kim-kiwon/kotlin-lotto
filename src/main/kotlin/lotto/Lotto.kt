package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        validate()
    }

    private fun validate() {
        if (numbers.size != 6) {
            throw IllegalArgumentException("Lotto num must be consist of 6 numbers")
        }

        if (numbers.size != numbers.toSet().size) {
            throw IllegalArgumentException("Lotto num don't have duplicated number")
        }

        if (numbers.any { it < 1 || it > 45}) {
            throw IllegalArgumentException("Lotto num must be between 1 and 45")
        }
    }
}
