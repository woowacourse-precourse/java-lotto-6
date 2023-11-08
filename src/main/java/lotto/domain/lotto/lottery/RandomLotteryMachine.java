package lotto.domain.lotto.lottery;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoNumber;

public class RandomLotteryMachine implements LotteryMachine<LottoNumber> {
    public static final int RANDOM_START_INCLUSIVE = 1;
    public static final int RANDOM_END_INCLUSIVE = 45;

    @Override
    public List<LottoNumber> generate() {
        return Randoms.pickUniqueNumbersInRange(
                        RANDOM_START_INCLUSIVE,
                        RANDOM_END_INCLUSIVE,
                        Lotto.LOTTO_SIZE
                ).stream()
                .map(LottoNumber::new)
                .toList();
    }
}
