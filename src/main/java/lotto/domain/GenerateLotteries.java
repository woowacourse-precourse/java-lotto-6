package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.constant.MagicNumber;

import java.util.ArrayList;
import java.util.List;

public class GenerateLotteries {
    private final List<Lotto> lotteries = new ArrayList<>();

    public GenerateLotteries(int count) {
        for (int i = 0; i < count; i++) {
            this.lotteries.add(generateRandomNumbers());
        }
    }

    public List<Lotto> getLotteries() {
        return this.lotteries;
    }

    private Lotto generateRandomNumbers() {
        Lotto numbers = new Lotto(Randoms.pickUniqueNumbersInRange(MagicNumber.MIN_NUMBER.getNumber(),
                MagicNumber.MAX_NUMBER.getNumber(), MagicNumber.LOTTO_COUNT.getNumber()));
        return numbers;
    }
}
