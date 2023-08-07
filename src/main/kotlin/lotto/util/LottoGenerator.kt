package lotto.util

import camp.nextstep.edu.missionutils.Randoms
import lotto.Lotto

class LottoGenerator {
    companion object {
        fun generate(): Lotto {
            val nums = Randoms.pickUniqueNumbersInRange(1, 45, 6)
            return Lotto(nums)
        }
    }
}