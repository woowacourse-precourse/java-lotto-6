package lotto.domain;

import static lotto.constant.ExceptionMessage.*;
import static lotto.constant.LottoConstant.*;
import static lotto.domain.LottoNumbersMaker.getLottoNumbers;

import java.util.ArrayList;
import java.util.List;

public class Wallet {

    private int balance = 0;
    private final List<Lotto> lottos = new ArrayList<>();

    public int getBalance() {
        return balance;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public void addBalance(int money) {
        validateNumber(money);
        this.balance = money;
    }

    public void buyAllLotto() {

        while (this.balance > 0) {
            List<Integer> numbers = getLottoNumbers();

            buyLotto(numbers);

            this.balance -= MIN_AMOUNT_OF_LOTTO;
        }
    }

    public void buyLotto(List<Integer> numbers) {
        Lotto lotto = new Lotto(numbers);
        this.lottos.add(lotto);
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
            throw new IllegalArgumentException(ERROR_NOT_AMOUNT_RANGE);
        }
    }
}
