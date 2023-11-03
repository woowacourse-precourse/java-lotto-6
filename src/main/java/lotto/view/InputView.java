package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Objects;

public class InputView {
    private static final String BUYING_PRICE_INPUT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String WINNING_NUMBERS_INPUT_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_INPUT_MESSAGE = "보너스 번호를 입력해 주세요.";

    private static final String BLANK_ERROR_MESSAGE = "[ERROR] 공백은 입력할 수 없습니다.";
    private static final String INTEGER_ERROR_MESSAGE = "[ERROR] 정수만 입력해야 합니다.";
    private static final String POSITIVE_INTEGER_ERROR_MESSAGE = "[ERROR] 양수만 입력해야 합니다.";

    public static int inputBuyingPrice() {
        System.out.println(BUYING_PRICE_INPUT_MESSAGE);
        String buyingPriceInput = Console.readLine();

        validateBlank(buyingPriceInput);
        int buyingPrice = validateAndConvertInteger(buyingPriceInput);
        validateNegativeInteger(buyingPrice);
        return buyingPrice;
    }

    public static String inputWinningNumbers() {
        System.out.println(WINNING_NUMBERS_INPUT_MESSAGE);
        String winningNumbers = Console.readLine();

        validateBlank(winningNumbers);
        return winningNumbers;
    }

    public static int inputBonusNumber() {
        System.out.println(BONUS_NUMBER_INPUT_MESSAGE);
        String bonusNumberInput = Console.readLine();

        validateBlank(bonusNumberInput);
        int bonusNumber = validateAndConvertInteger(bonusNumberInput);
        validateNegativeInteger(bonusNumber);
        return bonusNumber;
    }

    public static void validateBlank(String input) {
        if (Objects.isNull(input)) {
            throw new IllegalArgumentException(BLANK_ERROR_MESSAGE);
        }
        if (input.isBlank()) {
            throw new IllegalArgumentException(BLANK_ERROR_MESSAGE);
        }
    }

    private static int validateAndConvertInteger(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INTEGER_ERROR_MESSAGE);
        }
    }

    public static void validateNegativeInteger(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException(POSITIVE_INTEGER_ERROR_MESSAGE);
        }
    }
}
