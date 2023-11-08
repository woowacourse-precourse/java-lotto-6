package lotto.domain;

import lotto.exception.lotto.NonNumberFormatException;
import lotto.util.Utils;

public class Game {
    private static final String ONLY_NUMBER_REGEX = "[0-9]+";
    private Lotto winningNumbers;

    public Game(String winningNumbers) {
        validate(winningNumbers);
        this.winningNumbers = new Lotto(Utils.stringToIntegerList(winningNumbers));
    }

    private void validate(String winningNumbers) {
        validateNumberFormat(winningNumbers);
    }

    private void validateNumberFormat(String winningNumbers) {
        if (!winningNumbers.matches(ONLY_NUMBER_REGEX)) {
            throw new NonNumberFormatException();
        }
    }
}
