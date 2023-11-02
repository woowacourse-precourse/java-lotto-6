package lotto;

import java.util.HashSet;
import java.util.List;
import lotto.constant.LottoRanking;
import lotto.model.LottoNumber;
import lotto.model.WinningNumber;

public class Lotto {

    private static final int LOTTO_NUMBER_SIZE = 6;
    private static final int LOTTO_NUMBER_MIN = 1;
    private static final int LOTTO_NUMBER_MAX = 45;

    private final List<Integer> numbers;
    private final WinningNumber winningNumber;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
        validate();
        this.winningNumber = new WinningNumber(numbers);
    }

    private void validate() {
        validateSize();
        checkIsDuplicated();
        validateRange();
    }

    private void validateSize() {
        if (numbers.size() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    private void checkIsDuplicated() {
        if (new HashSet<>(numbers).size() != numbers.size()) {
            throw new IllegalArgumentException();
        }
    }

    private void validateRange() {
        for (Integer number : numbers) {
            checkIsInValidRange(number);
        }
    }

    private void checkIsInValidRange(int number) {
        if (number < LOTTO_NUMBER_MIN || LOTTO_NUMBER_MAX < number) {
            throw new IllegalArgumentException();
        }
    }

    public LottoRanking calculateLottoRanking(LottoNumber lottoNumber) {
        return winningNumber.compareNumbers(lottoNumber.getNumbers());
    }
}
