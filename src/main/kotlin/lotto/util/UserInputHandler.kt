package lotto.util

class UserInputHandler {
    companion object {
        fun handleMoneyInput(userInput: String): Int {
            if (!userInput.isIntString()) {
                throw IllegalArgumentException("Money should be number")
            }

            val money = userInput.toInt()
            if (money % 1_000 != 0) {
                throw IllegalArgumentException("Money must be a multiple of 1,000")
            }

            if (money <= 0) {
                throw IllegalArgumentException("Money must not be 0 or minus")
            }

            return money
        }

        fun handleWinningNumbersInput(userInput: String): List<Int> {
            val winningNumberStrings = userInput.split(",")

            if (winningNumberStrings.any { !it.isIntString() }) {
                throw IllegalArgumentException("Winning numbers must consist of Integer")
            }

            val winningNumbers = winningNumberStrings.map { it.toInt() }

            if (winningNumbers.size != 6 ) {
                throw IllegalArgumentException("Winning numbers must consist of 6 numbers")
            }

            if (winningNumbers.any { it < 1 || it > 45 }) {
                throw IllegalArgumentException("Winning numbers must be between 1 and 45")
            }

            return winningNumbers
        }

        fun handleBonusNumberInput(winningNumbers: List<Int>, userInput: String): Int {
            if (!userInput.isIntString()) {
                throw IllegalArgumentException("Bonus number must be Integer")
            }

            val bonusNumber = userInput.toInt()

            if (bonusNumber < 1 || bonusNumber > 45) {
                throw IllegalArgumentException("Bonus numbers must be between 1 and 45")
            }

            if (winningNumbers.contains(bonusNumber)) {
                throw IllegalArgumentException("Bonus numbers must not include in winningNumbers")
            }

            return bonusNumber
        }

        private fun String.isIntString(): Boolean {
            return this.toIntOrNull() != null
        }

    }


}