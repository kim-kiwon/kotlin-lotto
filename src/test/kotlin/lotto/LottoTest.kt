package lotto

import lotto.result.LottoResult
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows


class LottoTest {
    @Test
    fun `로또 번호의 개수가 6개가 넘어가면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 6, 7))
        }
    }

    @Test
    fun `로또 번호에 중복된 숫자가 있으면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 5))
        }
    }

    @Test
    fun `Lotto num must be between 1 and 45 - fail test`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 46))
        }
    }

    @Test
    fun `Lotto getResult second prize - success test`() {
        val winningNumber = listOf(1, 2, 3, 4, 5, 6)
        val bonusNumber = 7
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 7))

        assertThat(lotto.getResult(winningNumber, bonusNumber)).isEqualTo(LottoResult.SECOND)
    }

    @Test
    fun `Lotto getResult none - success test`() {
        val winningNumber = listOf(1, 2, 3, 4, 5, 6)
        val bonusNumber = 7
        val lotto = Lotto(listOf(8, 9, 10, 11, 12, 13))

        assertThat(lotto.getResult(winningNumber, bonusNumber)).isEqualTo(LottoResult.NONE)
    }
}
