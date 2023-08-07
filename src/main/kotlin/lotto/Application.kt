package lotto

import camp.nextstep.edu.missionutils.Console
import lotto.result.LottoResult
import lotto.result.LottoResults
import lotto.util.LottoBuyer
import lotto.util.UserInputHandler
import lotto.util.UserViewer

fun main() {
    UserViewer.printMoneyMessage()
    val money = UserInputHandler.handleMoneyInput(Console.readLine())

    val buyingCount = money / 1000
    UserViewer.printBuyingMessage(buyingCount)
    val lottos = LottoBuyer.buyLotto(buyingCount)
    UserViewer.printLottos(lottos)

    println()

    UserViewer.printWinningNumsMessage()
    val winningNumbers = UserInputHandler.handleWinningNumbersInput(Console.readLine())

    UserViewer.printBonusNumsMessage()
    val bonusNumber = UserInputHandler.handleBonusNumberInput(winningNumbers, Console.readLine())

    val results = mutableListOf<LottoResult>()
    for (lotto in lottos) {
        results.add(lotto.getResult(winningNumbers, bonusNumber))
    }
    val lottoResults = LottoResults(results)

    println(lottoResults.getStatistics())
    println("총 수익률은 ${lottoResults.getRateOfReturn(money)}%입니다.")
}
