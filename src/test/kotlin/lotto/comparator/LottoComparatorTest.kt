package lotto.comparator

import lotto.result.LottoResult
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoComparatorTest {
    @Test
    fun `compare result second prize - success test`() {
        val lottoComparator = LottoComparator(listOf(1, 2, 3, 4, 5, 6), 7)
        val lottoNumber = listOf(1, 2, 3, 4, 5, 7)

        assertThat(lottoComparator.compare(lottoNumber)).isEqualTo(LottoResult.SECOND)
    }

    @Test
    fun `compare result none - success test`() {
        val lottoComparator = LottoComparator(listOf(1, 2, 3, 4, 5, 6), 7)
        val lottoNumber = listOf(8, 9, 10, 11, 12, 13)

        assertThat(lottoComparator.compare(lottoNumber)).isEqualTo(LottoResult.NONE)
    }
}