package View;

import camp.nextstep.edu.missionutils.Console;
import utils.Validator;

public class ConsoleInputView implements InputView {
    private static String ERROR_LOWER_MIN_PHUCHASE_PRICE = "[ERROR] 최소 구매가능 금액은 1000원 입니다.";
    private static String ERROR_INVALID_AMOUNT_FORMAT = "[ERROR] 구매금액은 1,000단위로 입력하여야 합니다.";

    @Override
    public String inputPuchasePrice() {
        String userInput = Console.readLine();
        Validator.validateNumericValue(userInput);
        validateUnderThousand(userInput);
        validateMulitpleOfThousand(userInput);
        return userInput;
    }

    @Override
    public String inputPrizeNumbers() {
        String userInput = Console.readLine();
        return userInput;
    }

    @Override
    public String inputBonusNumber() {
        String userInput = Console.readLine();
        Validator.validateIsEmpty(userInput);
        Validator.validateNumericValue(userInput);
        return userInput;
    }

    private void validateUnderThousand(String userInput) {
        if (Integer.parseInt(userInput) < 1000) {
            throw new IllegalArgumentException(ERROR_LOWER_MIN_PHUCHASE_PRICE);
        }
    }

    private void validateMulitpleOfThousand(String userInput) {
        if (Integer.parseInt(userInput) % 1000 != 0) {
            throw new IllegalArgumentException(ERROR_INVALID_AMOUNT_FORMAT);
        }
    }

}
