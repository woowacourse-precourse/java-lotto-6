package lotto.application;

import java.util.List;
import java.util.stream.IntStream;
import lotto.domain.Lotto;
import lotto.domain.LottoAmount;

public class LottoStore {
    private final LottoMachine lottoMachine;

    public LottoStore(final LottoMachine lottoMachine) {
        this.lottoMachine = lottoMachine;
    }

    public List<Lotto> issueLottoByAuto(final LottoAmount lottoAmount) {
        final int quantity = lottoAmount.getLottoQuantity();
        return IntStream.range(0, quantity)
                .mapToObj(i -> lottoMachine.createLottoByAuto())
                .toList();
    }

    public Lotto issueWinningLotto(final List<Integer> numbers) {
        return lottoMachine.createLottoByManual(numbers);
    }
}
