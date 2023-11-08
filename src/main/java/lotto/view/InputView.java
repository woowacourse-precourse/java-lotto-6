package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.stream.Collectors;
import java.util.Arrays;
import java.util.List;

public class InputView {
    private static final String PROMPT_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String PROMPT_WINNING_NUMBERS = "당첨 번호를 입력해 주세요.";
    private static final String PROMPT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    public int getUserInputPurchaseAmount() {
        System.out.println(PROMPT_PURCHASE_AMOUNT);
        String userInput = Console.readLine();
        System.out.println();

        InputValidator.validateNonSpaced(userInput);
        InputValidator.validateNonZeroLeadingParsableNumber(userInput);
        int purchaseAmount = Integer.parseInt(userInput);
        InputValidator.validatePurchaseAmount(purchaseAmount);
        return purchaseAmount;
    }

    public List<Integer> getUserInputWinningNumbers() {
        System.out.println(PROMPT_WINNING_NUMBERS);
        String userInput = Console.readLine();
        System.out.println();

        InputValidator.validateNonSpaced(userInput);
        InputValidator.validateLottoNumbersPattern(userInput);
        return Arrays.stream(userInput.split(","))
                .map(Integer::parseInt)
                .peek(InputValidator::validateLottoNumber)
                .collect(Collectors.toList());
    }

    public int getUserInputBonusNumber() {
        System.out.println(PROMPT_BONUS_NUMBER);
        String userInput = Console.readLine();
        System.out.println();

        InputValidator.validateNonSpaced(userInput);
        InputValidator.validateNonZeroLeadingParsableNumber(userInput);
        int bonusNumber = Integer.parseInt(userInput);
        InputValidator.validateLottoNumber(bonusNumber);
        return bonusNumber;
    }
}
