package lotto.application;

import static lotto.enums.LottoConfig.LOTTO_COUNT;

import java.util.List;
import java.util.stream.IntStream;
import lotto.domain.Lotto;
import lotto.domain.LottoAmount;

public class LottoStore {
    private final LottoMachine lottoMachine;
    private final NumberGenerator numberGenerator;

    public LottoStore(final LottoMachine lottoMachine, final NumberGenerator numberGenerator) {
        this.lottoMachine = lottoMachine;
        this.numberGenerator = numberGenerator;
    }

    public List<Lotto> issueLottoByAuto(final LottoAmount lottoAmount) {
        final int quantity = lottoAmount.getLottoQuantity();
        return IntStream.range(0, quantity)
                .mapToObj(i -> numberGenerator.generateNumbers(LOTTO_COUNT.getValue()))
                .map(lottoMachine::createLotto)
                .toList();
    }

    public Lotto issueWinningLotto(final List<Integer> numbers) {
        return lottoMachine.createLotto(numbers);
    }
}
