package lotto.domain.machine;

import static lotto.exception.ErrorMessage.INVALID_INPUT_MONEY_UNIT;
import static lotto.exception.ErrorMessage.LESSER_THAN_MINIMUM_MONEY;

import java.util.List;
import java.util.stream.IntStream;
import lotto.Lotto;
import lotto.exception.LottoGameException;

public class LottoMachine {
    private static final int PRICE_PER_LOTTO = 1000;
    private final LottoNumberGenerator generator;
    public static final int MINIMUM_INPUT_MONEY = 0;

    public LottoMachine(LottoNumberGenerator generator) {
        this.generator = generator;
    }

    public List<Lotto> issueLottoListForInputMoney(int inputMoney) {

        validateInputMoneyNotNegative(inputMoney);
        validateInputMoneyUnit(inputMoney);

        int amount = inputMoney / PRICE_PER_LOTTO;

        return IntStream.range(0, amount)
                .mapToObj(ignore -> generator.generateLottoNumbers())
                .map(Lotto::new)
                .toList();
    }

    private void validateInputMoneyNotNegative(int inputMoney) {
        if (inputMoney < MINIMUM_INPUT_MONEY) {
            throw LottoGameException.of(LESSER_THAN_MINIMUM_MONEY);
        }
    }

    private void validateInputMoneyUnit(int inputMoney) {
        if (inputMoney % PRICE_PER_LOTTO != 0) {
            throw LottoGameException.of(INVALID_INPUT_MONEY_UNIT);
        }
    }
}
