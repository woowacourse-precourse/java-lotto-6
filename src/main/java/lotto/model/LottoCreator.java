package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.common.config.LottoGameRule;

public class LottoCreator {

    public static Lotto createRandomLotto() {
        return new Lotto(pickRandomNumbers());
    }

    public static Lotto createWinningLotto(List<Integer> numbers) {
        return new Lotto(numbers);
    }

    private static List<Integer> pickRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(
                LottoGameRule.MIN_LOTTO_NUMBER.getConstant(),
                LottoGameRule.MAX_LOTTO_NUMBER.getConstant(),
                LottoGameRule.LOTTO_NUMBERS_SIZE.getConstant());
    }
}
