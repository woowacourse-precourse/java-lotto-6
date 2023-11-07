package lotto.domain;

import lotto.dto.RequestLotto;
import lotto.dto.RequestLottos;
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
        final RequestLottos requestLottos = generateLottosByCash();
        return Lottos.create(requestLottos.lottoDummy());
    }

    private RequestLottos generateLottosByCash() {
        List<Lotto> generatedNumbersDummy = new ArrayList<>();
        while (cash.isAfford()) {
            cash.spendOneUnit();
            final Lotto lotto = generateLotto();
            generatedNumbersDummy.add(lotto);
        }

        return RequestLottos.of(generatedNumbersDummy);
    }

    private Lotto generateLotto() {
        final List<Integer> numbers = numberGenerator.generateNumbers();
        final RequestLotto requestLotto = RequestLotto.of(numbers);
        return Lotto.create(requestLotto.numbers());
    }



}
