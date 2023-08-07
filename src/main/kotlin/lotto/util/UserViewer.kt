package lotto.util

class UserViewer {
    companion object {
        fun printMoneyMessage() {
            println("구입금액을 입력해 주세요.")
        }

        fun printBuyingMessage(buyingCount: Int) {
            println("${buyingCount}개를 구매했습니다.")
        }

        fun printWinningNumsMessage() {
            println("당첨 번호를 입력해 주세요.")
        }

        fun printBonusNumsMessage() {
            println("보너스 번호를 입력해 주세요.")
        }
    }
}