package lotto.domain;

import java.util.List;

public class BonusNumber {

    private static final String NULL = "";
    private static final String SPACE = " ";

    private final int bonusNumber;
    private final List<Integer> winningNumbers;

    private ExceptionHandler exceptionHandler;
    private TypeConverter typeConverter;

    public BonusNumber(String bonusNumberInput, List<Integer> winningNumbers){
        this.exceptionHandler = new ExceptionHandler();
        this.typeConverter = new TypeConverter();
        bonusNumberInput = removeSpaces(bonusNumberInput);
        validateInputBonusNumber(bonusNumberInput);
        this.bonusNumber = typeConverter.stringToInt(bonusNumberInput);
        this.winningNumbers = winningNumbers;
        validateConvertedIntBonusNumber(this.bonusNumber);
        checkForDuplicateLottoNumbers(this.bonusNumber, this.winningNumbers);
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    private String removeSpaces(String bonusNumberInput) {
        return bonusNumberInput.replace(SPACE, NULL);
    }

    private void validateInputBonusNumber(String bonusNumberInput) {
        try {
            exceptionHandler.checkNotNull(bonusNumberInput);
            exceptionHandler.checkInteger(bonusNumberInput);
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }

    private void validateConvertedIntBonusNumber(int bonusNumber) {
        try {
            exceptionHandler.checkNonNegativeAmount(bonusNumber);
            exceptionHandler.checkInRange(bonusNumber);
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }

    private void checkForDuplicateLottoNumbers(int bonusNumber, List<Integer> winningNumbers) {
        try {
            exceptionHandler.checkForDuplicateLottoNumbersAndBonus(bonusNumber, winningNumbers);
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }
}