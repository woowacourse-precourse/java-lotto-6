package lotto.domain.machine;

import java.util.stream.IntStream;
import lotto.Lotto;
import lotto.domain.lottery.Lottos;

public class LottoMachine {
    private static final int PRICE_PER_LOTTO = 1000;
    private final LottoNumberGenerator generator;

    public LottoMachine(LottoNumberGenerator generator) {
        this.generator = generator;
    }

    public Lottos issueLottosForInputMoney(int inputMoney) {

        int amount = inputMoney / PRICE_PER_LOTTO;

        return Lottos.create(IntStream.range(0, amount)
                .mapToObj(ignore -> generator.generateLottoNumbers())
                .map(Lotto::new)
                .toList());
    }
}
