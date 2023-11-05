package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;

public class WinningLotto {

    private static final String NULL = "";
    private static final String SPACE = " ";
    private static final String COMMA = ",";

    private final Lotto winninglotto;
    private final int bonusNumber;

    public WinningLotto(String winningNumbers, String bonusNumber) {
        winningNumbers = ignoreSpace(winningNumbers);
        validate(winningNumbers, bonusNumber);
        this.winninglotto = convertToLotto(winningNumbers);
        this.bonusNumber = convertToInt(bonusNumber);
    }

    public Lotto getWinninglotto() {
        return winninglotto;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    private Lotto convertToLotto(String winningNumbers) {
        ArrayList<Integer> winningArray = (ArrayList<Integer>) Arrays.stream(winningNumbers.split(COMMA))
                .map(Integer::parseInt).toList();
        return new Lotto(winningArray);
    }

    private int convertToInt(String bonusNumber) {
        return Integer.parseInt(bonusNumber);
    }

    private void validate(String winningNumbers, String bonusNumber) {
        validateNullOrBlank(winningNumbers);
        validateIsNumber(winningNumbers);
        validateNullOrBlank(bonusNumber);
        checkAndThrowIfNotNumeric(bonusNumber);
        validateAlreadyDrawn(winningNumbers, bonusNumber);
    }

    private void validateAlreadyDrawn(String winningNumbers, String bonusNumber) {
        String[] splitNumbers = winningNumbers.split(COMMA);
        for (String splitNumber : splitNumbers) {
            checkAndThrowIfAlreadyDrawn(bonusNumber, splitNumber);
        }
    }

    private static void checkAndThrowIfAlreadyDrawn(String bonusNumber, String splitNumber) {
        if (splitNumber.equals(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.ALREADY_DRAWN.getMessage());
        }
    }

    private void validateIsNumber(String winningNumbers) {
        String[] splitNumbers = winningNumbers.split(COMMA);
        for (String splitNumber : splitNumbers) {
            checkAndThrowIfNotNumeric(splitNumber);
        }
    }

    private void checkAndThrowIfNotNumeric(String splitNumber) {
        try {
            Integer.parseInt(splitNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.NON_NUMERIC.getMessage());
        }
    }

    private void validateNullOrBlank(String winningNumbers) {
        if (isNullOrBlank(winningNumbers)) {
            throw new IllegalArgumentException(ErrorMessage.NULL_OR_BLANK.getMessage());
        }
    }

    private String ignoreSpace(String winningNumbers) {
        return winningNumbers.replaceAll(SPACE, NULL);
    }

    private boolean isNullOrBlank(String winningNumbers) {
        return winningNumbers == null || winningNumbers.isBlank();
    }
}
