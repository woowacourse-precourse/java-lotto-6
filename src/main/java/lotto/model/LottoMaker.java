package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.common.config.LottoGameRule;

public class LottoMaker {

    public static Lotto makeAutoLotto() {
        return new Lotto(pickRandomNumbers());
    }

    public static Lotto makeManualLotto(List<Integer> numbers) {
        return new Lotto(numbers);
    }

    private static List<Integer> pickRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(
                LottoGameRule.MIN_LOTTO_NUMBER.constant(),
                LottoGameRule.MAX_LOTTO_NUMBER.constant(),
                LottoGameRule.LOTTO_NUMBERS_SIZE.constant());
    }
}
