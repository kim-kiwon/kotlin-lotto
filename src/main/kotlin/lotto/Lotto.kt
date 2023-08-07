package lotto

import lotto.result.LottoResult

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

    fun getResult(winningNumber: List<Int>, bonusNumber: Int): LottoResult {
        val winCount = winningNumber.intersect(numbers).count()
        val hasBonusNumber = numbers.contains(bonusNumber)

        return when {
            winCount == 6 -> LottoResult.FIRST
            winCount == 5 && hasBonusNumber -> LottoResult.SECOND
            winCount == 5 -> LottoResult.THIRD
            winCount == 4 -> LottoResult.FOURTH
            winCount == 3 -> LottoResult.FIFTH
            else -> LottoResult.NONE
        }
    }

    override fun toString(): String {
        val sb = StringBuilder()

        sb.append("[")

        numbers.forEachIndexed { index, num ->
            sb.append(num)
            if (index != numbers.size - 1) {
                sb.append(", ")
            }
        }

        sb.append("]")

        return sb.toString()
    }
}
