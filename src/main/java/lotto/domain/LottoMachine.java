package lotto.domain;

import lotto.util.NumberGenerator;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    private final NumberGenerator numberGenerator;
    private final Cash cash;


    public LottoMachine(NumberGenerator numberGenerator, Cash cash) {
        this.numberGenerator = numberGenerator;
        this.cash = cash;
    }

    public Lottos purchaseLottos() {
        List<Lotto> purchasedLottos = new ArrayList<>();
        while (cash.isAfford()) {
            cash.spendOneUnit();
            Lotto lotto = generateLotto();
            purchasedLottos.add(lotto);
        }

        return new Lottos(purchasedLottos);
    }

    private Lotto generateLotto() {
        List<Integer> numbers = numberGenerator.generateNumbers();
        return new Lotto(numbers);
    }


}
