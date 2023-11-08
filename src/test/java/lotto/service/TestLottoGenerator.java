package lotto.service;

import java.util.List;
import lotto.domain.lotto.Lotto;
import lotto.domain.lottogenerator.LottoGenerator;

public class TestLottoGenerator implements LottoGenerator {

    @Override
    public Lotto generate() {
        return new Lotto(List.of(1, 2, 3, 4, 5, 6));
    }
}
