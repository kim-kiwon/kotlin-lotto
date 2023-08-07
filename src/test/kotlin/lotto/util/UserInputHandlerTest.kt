package lotto.util

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class UserInputHandlerTest {
    @Test
    fun `handleMoneyInput's input must be Integer - fail test`() {
        val userInput = "abc"

        assertThrows<IllegalArgumentException> {
            UserInputHandler.handleMoneyInput(userInput)
        }
    }

    @Test
    fun `handleMoneyInput's input must be 1_000's multiple - fail test`() {
        val userInput = "2001"

        assertThrows<IllegalArgumentException> {
            UserInputHandler.handleMoneyInput(userInput)
        }
    }

    @Test
    fun `handleMoneyInput's input must not be minus - fail test`() {
        val userInput = "-1000"

        assertThrows<IllegalArgumentException> {
            UserInputHandler.handleMoneyInput(userInput)
        }
    }

    @Test
    fun `handleMoneyInput - success test`() {
        val userInput = "2000"
        val money = UserInputHandler.handleMoneyInput(userInput)

        assertThat(money).isEqualTo(2000)
    }

    @Test
    fun `handleWinningNumbersInput's input must be consist of 6 element - fail test`() {
        val userInput = "1,2,3,4,5"

        assertThrows<IllegalArgumentException> {
            UserInputHandler.handleWinningNumbersInput(userInput)
        }
    }

    @Test
    fun `handleWinningNumbersInput's input must be consist of Integer element - fail test`() {
        val userInput = "1,2,3,4,5,c"

        assertThrows<IllegalArgumentException> {
            UserInputHandler.handleWinningNumbersInput(userInput)
        }
    }

    @Test
    fun `handleWinningNumbersInput's input must be consist of between 1 and 45 element - fail test`() {
        val userInput = "1,2,3,4,5,46"

        assertThrows<IllegalArgumentException> {
            UserInputHandler.handleWinningNumbersInput(userInput)
        }
    }

    @Test
    fun `handleWinningNumbersInput - success test`() {
        val userInput = "1,2,3,4,5,6"
        val winningNumbers = UserInputHandler.handleWinningNumbersInput(userInput)

        assertThat(winningNumbers[0]).isEqualTo(1)
        assertThat(winningNumbers[1]).isEqualTo(2)
        assertThat(winningNumbers[2]).isEqualTo(3)
        assertThat(winningNumbers[3]).isEqualTo(4)
        assertThat(winningNumbers[4]).isEqualTo(5)
        assertThat(winningNumbers[5]).isEqualTo(6)
    }

    @Test
    fun `handleBonusNumberInput's input don't be included in winningNumbers - fail test`() {
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
        val userInput = "1"

        assertThrows<IllegalArgumentException> {
            UserInputHandler.handleBonusNumberInput(winningNumbers, userInput)
        }
    }
}