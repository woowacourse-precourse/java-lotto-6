package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Input {
    private static final String PURCHASE_PRICE_INPUT_MESSAGE = "구입 금액을 입력해 주세요.";
    private static final String WINNING_NUMBERS_INPUT_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_INPUT_MESSAGE = "보너스 번호를 입력해 주세요.";

    Exception exception = new Exception();

    public int inputPurchasePrice() {
        System.out.println(PURCHASE_PRICE_INPUT_MESSAGE);
        String purchasePrice = consoleReadLine();
        exception.validatePurchasePrice(purchasePrice);
        return Integer.parseInt(purchasePrice);
    }

    public Winning inputWinning() {
        List<Integer> winningNumbers = inputWinningNumbers();
        int bonusNumber = inputBonusNumber();
        return new Winning(winningNumbers, bonusNumber);
    }

    private List<Integer> inputWinningNumbers() {
        System.out.println(WINNING_NUMBERS_INPUT_MESSAGE);
        String winningNumbers = consoleReadLine();
        List<String> winningNumber = Arrays.asList(winningNumbers.split(","));
        exception.validateWinningNumbersInput(winningNumber);
        return convertStringListToIntegerList(winningNumber);
    }

    private int inputBonusNumber() {
        System.out.println(BONUS_NUMBER_INPUT_MESSAGE);
        String bonusNumber = consoleReadLine();
        exception.validateNumberInput(bonusNumber);
        return Integer.parseInt(bonusNumber);
    }

    private String consoleReadLine() {
        String input = Console.readLine();
        System.out.println();
        return input;
    }

    private List<Integer> convertStringListToIntegerList(List<String> inputs) {
        List<Integer> convertInput = new ArrayList<>();
        for (String input: inputs) {
            convertInput.add(Integer.parseInt(input));
        }
        return convertInput;
    }
}
