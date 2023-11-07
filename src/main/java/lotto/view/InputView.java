package lotto.view;


import static lotto.configurations.LottoConfigurations.getSeparator;
import static lotto.configurations.ErrorMessages.*;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static class SingletonInputView {
        private static final InputView INPUT_VIEW = new InputView();
    }

    public static InputView getInstance() {
        return SingletonInputView.INPUT_VIEW;
    }

    private InputView() {
    }

    public Long inputPurchaseAmount() {
        Long purchaseAmount;

        String userInput = Console.readLine();
        validateContainSpace(userInput);
        validateInteger(userInput);

        purchaseAmount = Long.parseLong(userInput);
        return purchaseAmount;
    }


    public List<Integer> inputWinningNumbers() {
        List<Integer> winningNumbers = new ArrayList<>();

        String userInput = Console.readLine();
        validateContainSpace(userInput);
        validateContainComma(userInput);

        List<String> splitedInput = Arrays.asList(userInput.split(getSeparator()));
        for (String number : splitedInput) {
            validateInteger(number);

            Integer integer = Integer.parseInt(number);
            winningNumbers.add(integer);
        }

        return winningNumbers;
    }

    public Integer inputBonusNumber() {
        Integer bonusNumber;

        String userInput = Console.readLine();
        validateContainSpace(userInput);
        validateInteger(userInput);

        bonusNumber = Integer.parseInt(userInput);
        return bonusNumber;
    }

    private void validateContainSpace(String userInput) {
        if (userInput.contains(" ")) {
            throw new IllegalArgumentException(ERROR_HEADER.get() + NO_SPACE_MESSAGE.get());
        }
    }

    private void validateInteger(String userInput) {
        for (char c : userInput.toCharArray()) {
            if (c < '0' || c > '9') {
                throw new IllegalArgumentException(ERROR_HEADER.get() + ONLY_INTEGER_MESSAGE.get());
            }
        }
    }

    private void validateContainComma(String userInput) {
        if (!userInput.contains(getSeparator())) {
            throw new IllegalArgumentException(ERROR_HEADER.get() + getSeparator() + INPUT_SEPARATOR_MESSAGE.get());
        }
    }
}
