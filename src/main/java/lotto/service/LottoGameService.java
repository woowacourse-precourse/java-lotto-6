package lotto.service;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.PlayerLotto;
import lotto.service.numbergenerator.NumberGenerator;

public class LottoGameService {
    private final NumberGenerator numbersGenerator;
    private final YieldCalculator yieldCalculator;

    public LottoGameService(NumberGenerator numbersGenerator, YieldCalculator yieldCalculator) {
        this.numbersGenerator = numbersGenerator;
        this.yieldCalculator = yieldCalculator;
    }

    public PlayerLotto createPlayerLotto(final int totalCounts) {
        List<Lotto> lottos = new ArrayList<>();
        for (int count = 0; count < totalCounts; count++) {
            lottos.add(new Lotto(numbersGenerator.generate()));
        }
        return new PlayerLotto(lottos);
    }
}
