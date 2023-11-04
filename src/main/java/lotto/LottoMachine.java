package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    private List<Lotto> lotteries = new ArrayList<>();

    public List<Lotto> publishLotteries(int count) {
        while (count > 0) {
            lotteries.add(this.GenerateLotto());
            count--;
        }
        return lotteries;
    }

    private Lotto GenerateLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(Lotto.MIN_LOTTO_NUMBER, Lotto.MAX_LOTTO_NUMBER,
                Lotto.LOTTO_LENGTH);
        return new Lotto(numbers);
    }
}
