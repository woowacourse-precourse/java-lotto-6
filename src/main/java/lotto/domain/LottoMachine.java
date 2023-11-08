package lotto.domain;

import lotto.exception.ErrorStatus;
import lotto.exception.LottoArgumentException;
import lotto.generator.NumbersGenerator;

import java.util.List;
import java.util.stream.IntStream;

/**
 * 로또를 생성하는 기계
 */
public class LottoMachine {

    private final NumbersGenerator numbersGenerator;


    public LottoMachine(NumbersGenerator numbersGenerator) {
        this.numbersGenerator = numbersGenerator;
    }

    public Lottos buyLottos(int money) {
        validateMoney(money);

        int quantity = calculateLottoQuantity(money);
        List<Lotto> lottos = createLottos(quantity);

        return new Lottos(lottos);
    }

    private void validateMoney(int money) {
        validateMinimum(money);
        validateMultiple(money);
    }

    private void validateMinimum(int money) {
        if (money < Lotto.PRICE) {
            throw new LottoArgumentException(ErrorStatus.MONEY_RANGE_ERROR);
        }
    }

    private void validateMultiple(int money) {
        if (money % Lotto.PRICE != 0) {
            throw new LottoArgumentException(ErrorStatus.MONEY_UNIT_ERROR);
        }
    }

    private int calculateLottoQuantity(int money) {
        return money / Lotto.PRICE;
    }

    private List<Lotto> createLottos(int quantity) {
        return IntStream.range(0, quantity)
                .mapToObj(i -> createLotto())
                .toList();
    }

    private Lotto createLotto() {
        return new Lotto(numbersGenerator.generate());
    }
}
