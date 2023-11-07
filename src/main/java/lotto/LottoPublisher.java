package lotto;

import config.LottoConfig;
import number_generator.NumberGenerator;

public class LottoPublisher {
    private final NumberGenerator ng;

    public LottoPublisher(NumberGenerator ng) {
        this.ng = ng;
    }

    public Lotto publish() {
        return new Lotto(ng.generateNumberSet(LottoConfig.LOTTO_MIN, LottoConfig.LOTTO_MAX, LottoConfig.LOTTO_SIZE));
    }
}
