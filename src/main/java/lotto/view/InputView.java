package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import lotto.validator.LottoNumberValidator;
import lotto.validator.UserInputValidator;

public class InputView {

    public static int inputPurchaseAmount() {
        String userInput = Console.readLine();
        int purchaseAmount = UserInputValidator.validatePurchaseAmount(userInput);
        return purchaseAmount;
    }

    public static List<Integer> inputWinningNumbers() {
        String userInput = Console.readLine();
        List<Integer> numbers = Arrays.stream(userInput.split(",")).map(Integer::parseInt).toList();
        return numbers;
    }

    public static Integer inputBonusNumber(List<Integer> numbers) {
        String userInput = Console.readLine();
        LottoNumberValidator.validateBonusNumber(numbers, userInput);
        return Integer.parseInt(userInput);
    }


}
