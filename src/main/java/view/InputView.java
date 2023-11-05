package view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import message.InformationMessages;
import utils.Converter;

public class InputView {
    private static final String DELIMITER = ",";
    private static final String INPUT_CONTAIN_SPACE = "[ERROR] 입력에 공백이 포함될 수 없습니다.";
    private static final String INPUT_IS_EMPTY = "[ERROR] 입력은 공백일 수 없습니다.";
    private static final String INPUT_INVALID_TYPE = "[ERROR] 입력은 정수값이어야 합니다.";
    InformationMessages messages = new InformationMessages();

    public String inputPurchaseAmount() {
        printMessage(messages.INPUT_PURCHASE_AMOUNT_MESSAGE);
        String input = Console.readLine();
        inputValidation(input);
        notNumber(input);
        return input;
    }

    public String inputWinningNumber() {
        printMessage(messages.INPUT_WINNING_NUMBER);
        String input = Console.readLine();
        inputValidation(input);
        validationNumbers(input);
        return input;
    }

    public String inputBonusNumber() {
        printMessage(messages.INPUT_BONUS_NUMBER);
        String input = Console.readLine();
        notNumber(input);
        return input;
    }

    public void inputValidation(String input) {
        isEmpty(input);
        hasSpace(input);
    }

    public void hasSpace(String input) {
        if (input.contains(" ")) {
            throw new IllegalArgumentException(INPUT_CONTAIN_SPACE);
        }
    }

    public void isEmpty(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException(INPUT_IS_EMPTY);
        }
    }

    public void notNumber(String input) {
        try {
            Converter.stringToInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INPUT_INVALID_TYPE);
        }
    }

    private void validationNumbers(String input) {
        String[] numbers = splitByDelimiter(input);
        Arrays.stream(numbers).forEach(number -> notNumber(number));
    }

    public String[] splitByDelimiter(String input) {
        return input.split(DELIMITER);
    }

    public void printMessage(String message) {
        System.out.println(message);
    }
}
