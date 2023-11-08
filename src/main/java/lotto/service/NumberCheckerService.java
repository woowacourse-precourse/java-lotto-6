package lotto.service;

import static lotto.exception.constants.ErrorMessage.NOT_NUMERIC_LOTTO_NUMBER;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.domain.Bonus;
import lotto.domain.Lotto;
import lotto.domain.NumberChecker;
import lotto.exception.LottoException;

public class NumberCheckerService {
    public NumberChecker generateNumberChecker(final Lotto winningLotto, final Bonus bonus) {
        return NumberChecker.from(winningLotto, bonus);
    }

    public Lotto generateWinningLotto(final String winningLotto) {
        return new Lotto(splitLotto(winningLotto));
    }

    public Bonus generateBonus(final String bonus, final Lotto winningLotto) {
        return Bonus.of(bonus, winningLotto);
    }

    private static List<Integer> splitLotto(String winningLotto) {
        List<Integer> numbers = new ArrayList<>();
        try {
            Arrays.stream(winningLotto.split(","))
                    .map(Integer::parseInt)
                    .forEach(numbers::add);
        } catch (NumberFormatException e) {
            throw LottoException.of(NOT_NUMERIC_LOTTO_NUMBER);
        }
        return numbers;
    }
}
