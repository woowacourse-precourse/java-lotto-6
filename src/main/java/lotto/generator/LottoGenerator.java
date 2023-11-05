package lotto.generator;

import lotto.domain.model.Lotteries;
import lotto.domain.model.Lotto;

public class LottoGenerator {
    Lotteries lotteries = new Lotteries();

    public Lotteries run(int countOfLotto) {
        for (int i = 0; i < countOfLotto; i++) {
            lotteries.add(issueLotto());
        }

        return lotteries;
    }

    private Lotto issueLotto() {
        try {
            Lotto lotto = new Lotto(SixNumberGenerator.run());

            return lotto;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());

            return this.issueLotto();
        }
    }

}
