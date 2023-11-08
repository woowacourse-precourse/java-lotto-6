package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import lotto.validator.UserInputValidator;

public class InputView {

    public static int inputPurchaseAmount() {
        String userInput = Console.readLine();
        int purchaseAmount = UserInputValidator.validatePurchaseAmount(userInput);
        return purchaseAmount;
    }

    public static List<Integer> inputWinningNumbers() {
        String userInput = Console.readLine();
        return Arrays.stream(userInput.split(",")).map(Integer::parseInt).toList();
    }

    public static Integer inputBonusNumber() {
        String userInput = Console.readLine();
        return Integer.parseInt(userInput);
    }
}
