package lotto.util

import camp.nextstep.edu.missionutils.Randoms
import lotto.Lotto

class LottoBuyer {
    companion object {
        fun buyLotto(buyingCount: Int): List<Lotto> {
            val lottos = mutableListOf<Lotto>()

            for (i in 0 until buyingCount) {
                val nums = Randoms.pickUniqueNumbersInRange(1, 45, 6)
                lottos.add(Lotto(nums))
            }

            return lottos
        }
    }
}