package lotto.view;

import static lotto.config.GameTextConfig.LOTTO_NUMBER_SEPARATOR;
import static lotto.exception.ErrorMessage.VALIDATE_INPUT_NUMBER;
import static lotto.view.constants.OutputMessage.INPUT_PURCHASE_PRICE_MESSAGE;
import static lotto.view.constants.OutputMessage.INPUT_WINNING_NUMBER_MESSAGE;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import lotto.view.validator.InputValidator;
import lotto.view.validator.PurchasePriceValidator;

public class InputView {
    private InputView() {
    }

    public static int inputPurchasePrice() {
        String inputPrice;
        do {
            OutputView.printMessage(INPUT_PURCHASE_PRICE_MESSAGE.getMessage());
            inputPrice = Console.readLine();
        } while (!PurchasePriceValidator.validatePurchasePrice(inputPrice));
        return Integer.parseInt(inputPrice);
    }

    public static List<Integer> inputWinningNumber() {
        OutputView.printMessage(INPUT_WINNING_NUMBER_MESSAGE.getMessage());

        String input = Console.readLine();
        InputValidator.validateWinningNumber(input);
        return parseWinningNumber(input);

    }

    private static List<Integer> parseWinningNumber(String input) {
        List<String> splitInput = splitBySeparator(input);
        List<Integer> numbers = parseIntList(splitInput);
        Collections.sort(numbers);
        return numbers;
    }

    public static List<String> splitBySeparator(String input) {
        return Arrays.asList(input.split(LOTTO_NUMBER_SEPARATOR.getText()));
    }

    public static List<Integer> parseIntList(List<String> input){
        try {
            return new ArrayList<>(input.stream()
                    .map(Integer::parseInt)
                    .toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(VALIDATE_INPUT_NUMBER.getMessage());
        }
    }
}
