package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

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
        Lotto numbers = new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        return numbers;
    }
}
