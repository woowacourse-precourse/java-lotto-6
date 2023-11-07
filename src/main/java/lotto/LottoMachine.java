package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    private static final int COUNT_ZERO = 0;
    private List<Lotto> lotteries = new ArrayList<>();

    public List<Lotto> publishLotteries(int count) {
        while (count > COUNT_ZERO) {
            lotteries.add(this.generateLotto());
            count--;
        }
        return lotteries;
    }

    private Lotto generateLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(Lotto.MIN_LOTTO_NUMBER, Lotto.MAX_LOTTO_NUMBER,
                Lotto.LOTTO_LENGTH);
        return new Lotto(numbers);
    }
}
