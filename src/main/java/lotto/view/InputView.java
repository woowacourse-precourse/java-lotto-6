package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.utils.InputParser;

public class InputView {
    private final InputParser inputParser = new InputParser();

    public int inputPurchaseAmount() {
        String purchaseAmount = inputLine();
        return inputParser.validatePurchaseAmount(purchaseAmount);
    }

    public List<Integer> inputWinningNumbers() {
        return inputParser.parseAndValidateWinningNumbers(inputLine());
    }

    public int inputBonusNumber() {
        String bonus = inputLine();
        return inputParser.validateBonusNumber(bonus);
    }

    private String inputLine() {
        String input = Console.readLine();
        System.out.println();
        return input;
    }
}
