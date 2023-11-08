package view;

import static org.mockito.ArgumentMatchers.matches;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import message.ErrorMessages;
import message.InformationMessages;
import message.InputSign;
import utils.Converter;

public class InputView {


    public String inputPurchaseAmount() {
        printMessage(InformationMessages.INPUT_PURCHASE_AMOUNT_MESSAGE);
        String input = Console.readLine();
        inputValidation(input);
        notNumber(input);
        return input;
    }

    public String inputWinningNumber() {
        printMessage(InformationMessages.INPUT_WINNING_NUMBER);
        String input = Console.readLine();
        inputValidation(input);
        validationNumbers(input);
        System.out.println();
        return input;
    }

    public String inputBonusNumber() {
        printMessage(InformationMessages.INPUT_BONUS_NUMBER);
        String input = Console.readLine();
        notNumber(input);
        System.out.println();
        return input;
    }

    public void inputValidation(String input) {
        isEmpty(input);
        hasSpace(input);
    }

    public void hasSpace(String input) {
        if (input.contains(" ")) {
            throw new IllegalArgumentException(ErrorMessages.INPUT_CONTAIN_SPACE);
        }
    }

    public void isEmpty(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException(ErrorMessages.INPUT_IS_EMPTY);
        }
    }

    public void notNumber(String input) {
        if(!input.matches("\\d+")){
            throw new IllegalArgumentException(ErrorMessages.INPUT_INVALID_TYPE);
        }
    }

    private void validationNumbers(String input) {
        String[] numbers = splitByDelimiter(input);
        Arrays.stream(numbers).forEach(number -> notNumber(number));
    }

    public String[] splitByDelimiter(String input) {
        return input.split(InputSign.DELIMITER);
    }

    public void printMessage(String message) {
        System.out.println(message);
    }
}
