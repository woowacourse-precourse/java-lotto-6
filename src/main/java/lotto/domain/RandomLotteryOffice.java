package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RandomLotteryOffice implements LotteryOffice {

    @Override
    public boolean sellTo(User user) {
        return user.buy(LotteryOffice.LOTTO_PRICE, issueLotto());
    }

    private Lotto issueLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(
                LotteryOffice.LOTTO_START_NUMBER,
                LotteryOffice.LOTTO_END_NUMBER,
                LOTTO_LENGTH);

        return new Lotto(numbers);
    }
}
