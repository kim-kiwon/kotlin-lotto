package lotto.comparator

import lotto.result.LottoResult
import lotto.result.LottoResult.*

class LottoComparator(private val winningNumber: List<Int>, private val bonusNumber: Int) {
    fun compare(lottoNumber: List<Int>): LottoResult {
        val winCount = winningNumber.intersect(lottoNumber).count()
        val hasBonusNumber = lottoNumber.contains(bonusNumber)

        return when {
            winCount == 6 -> FIRST
            winCount == 5 && hasBonusNumber -> SECOND
            winCount == 5 -> THIRD
            winCount == 4 -> FOURTH
            winCount == 3 -> FIFTH
            else -> NONE
        }
    }
}