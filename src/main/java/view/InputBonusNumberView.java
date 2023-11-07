package view;

import camp.nextstep.edu.missionutils.Console;
import exception.InvalidLottoNumberRangeException;
import exception.NonNumericException;

public class InputBonusNumberView {
    private static final String INTEGER_REGEX = "^\\d+$";
    private static final String NEW_LINE = "\n";
    private static final String BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";
    private static final int MIN_RANGE = 1;
    private static final int MAX_RANGE = 45;

    public int getValue() {
        System.out.println(NEW_LINE + BONUS_NUMBER_MESSAGE);
        String bonusNumberInput = Console.readLine();

        validate(bonusNumberInput);

        return Integer.parseInt(bonusNumberInput);
    }

    public void validate(String inputValue) {
        validateNonNumeric(inputValue);
        validateNumberRange(inputValue);
    }

    private void validateNumberRange(String inputValue) {
        int intInputValue = Integer.parseInt(inputValue);
        if (!(MIN_RANGE <= intInputValue && intInputValue <= MAX_RANGE)) {
            throw new InvalidLottoNumberRangeException();
        }
    }

    private void validateNonNumeric(String inputValue) {
        if (!inputValue.matches(INTEGER_REGEX)) {
            throw new NonNumericException();
        }

    }


}
