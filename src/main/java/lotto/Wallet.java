package lotto;

import static lotto.LottoNumbersMaker.getLottoNumbers;

import java.util.ArrayList;
import java.util.List;

public class Wallet {

    private static final int MIN_AMOUNT_OF_LOTTO = LottoConstant.MIN_AMOUNT_OF_LOTTO.getValue();
    private static final int MAX_AMOUNT_OF_LOTTO = LottoConstant.MAX_AMOUNT_OF_LOTTO.getValue();
    private static final String ERROR_NOT_MULTIPLES_NUMBER = Message.ERROR_NOT_MULTIPLES_NUMBER.getValue();
    private static final String ERROR_NOT_NUMBER_RANGE = Message.ERROR_NOT_NUMBER_RANGE.getValue();

    private int balance = 0;
    private final List<Lotto> lottos = new ArrayList<>();

    public int getBalance() {
        return balance;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    void addBalance(int money) {
        validateNumber(money);
        this.balance = money;
    }

    void buyAllLotto() {

        while (this.balance > 0) {
            List<Integer> numbers = getLottoNumbers();
            Lotto lotto = new Lotto(numbers);

            this.lottos.add(lotto);
            this.balance -= MIN_AMOUNT_OF_LOTTO;
        }
    }


    private void validateNumber(int number) {
        validateNumberByMultiplesOfThousand(number);
        validateNumberRange(number);
    }

    private void validateNumberByMultiplesOfThousand(int number) {
        if (number % MIN_AMOUNT_OF_LOTTO != 0) {
            throw new IllegalArgumentException(ERROR_NOT_MULTIPLES_NUMBER);
        }
    }

    private void validateNumberRange(int number) {
        if (number < MIN_AMOUNT_OF_LOTTO || number > MAX_AMOUNT_OF_LOTTO) {
            throw new IllegalArgumentException(ERROR_NOT_NUMBER_RANGE);
        }
    }
}
