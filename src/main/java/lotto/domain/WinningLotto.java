package lotto.domain;

import java.util.ArrayList;

import static lotto.service.Validator.*;

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
        ArrayList<Integer> winningArray = new ArrayList<>();
        String[] splitArray = winningNumbers.split(COMMA);
        for (String split : splitArray) {
            winningArray.add(Integer.parseInt(split));
        }
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
        checkAndThrowIfOutOfRange(bonusNumber);
        validateAlreadyDrawn(winningNumbers, bonusNumber);
    }

    private void checkAndThrowIfOutOfRange(String bonusNumber) {
        int convertedBonusNumber = Integer.parseInt(bonusNumber);
        if (isOutOfRange(convertedBonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.OUT_OF_RANGE_NUMBER.getMessage());
        }
    }

    private static boolean isOutOfRange(int convertedBonusNumber) {
        return convertedBonusNumber < LottoConstants.NUMBER_MIN.getValue() || convertedBonusNumber > LottoConstants.NUMBER_MAX.getValue();
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

    private String ignoreSpace(String winningNumbers) {
        return winningNumbers.replaceAll(SPACE, NULL);
    }
}
