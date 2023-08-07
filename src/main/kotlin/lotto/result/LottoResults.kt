package lotto.result

import lotto.result.LottoResult.*
import java.text.NumberFormat

class LottoResults(private val results: List<LottoResult>) {
    private val resultMap = mapOf(
        FIRST to results.count { it == FIRST },
        SECOND to results.count { it == SECOND },
        THIRD to results.count { it == THIRD },
        FOURTH to results.count { it == FOURTH },
        FIFTH to results.count { it == FIFTH }
    )

    fun getStatistics(): String {
        return """
        3개 일치 (${getCommaNumber(FIFTH.income)}원) - ${resultMap[FIFTH]}개
        4개 일치 (${getCommaNumber(FOURTH.income)}원) - ${resultMap[FOURTH]}개
        5개 일치 (${getCommaNumber(THIRD.income)}원) - ${resultMap[THIRD]}개
        5개 일치, 보너스 볼 일치 (${getCommaNumber(SECOND.income)}원) - ${resultMap[SECOND]}개
        6개 일치 (${getCommaNumber(FIRST.income)}) - ${resultMap[FIRST]}개
        """.trimIndent()
    }

    fun getRateOfReturn(money: Int): String {
        var totalIncome = 0

        for ((result, count) in resultMap) {
            totalIncome += result.income * count
        }

        return String.format("%.2f", totalIncome / money * 100)
    }

    private fun getCommaNumber(num: Int): String {
        return NumberFormat.getNumberInstance().format(num)
    }
}