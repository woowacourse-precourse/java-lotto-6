package lotto.domain;

import lotto.util.NumberGenerator;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    private final NumberGenerator numberGenerator;
    private final Cash cash;


    public LottoMachine(final NumberGenerator numberGenerator, final Cash cash) {
        this.numberGenerator = numberGenerator;
        this.cash = cash;
    }

    public Lottos purchaseLottos() {
        final List<Lotto> generatedLottos = generateLottosByCash();
        return new Lottos(generatedLottos);
    }

    private List<Lotto> generateLottosByCash() {
        List<Lotto> generatedLottos = new ArrayList<>();
        while (cash.isAfford()) {
            cash.spendOneUnit();
            Lotto lotto = generateLotto();
            generatedLottos.add(lotto);
        }

        return generatedLottos;
    }

    private Lotto generateLotto() {
        final List<Integer> numbers = numberGenerator.generateNumbers();
        return new Lotto(numbers);
    }



}
