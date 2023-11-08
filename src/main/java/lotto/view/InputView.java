package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.Set;
import lotto.util.StringUtil;
import lotto.validator.BonusNumberValidator;
import lotto.validator.PurchaseAmountValidator;
import lotto.validator.WinningNumbersValidator;

public class InputView {

    public static String getPlayerInput(String message) {
        OutputView.printMessage(message);
        return Console.readLine().trim();
    }

    public static int getPurchaseAmount() {
        int purchaseAmount;
        do {
            String input = getPlayerInput("구입 금액을 입력해 주세요");
            purchaseAmount = validatePurchaseAmount(input);
        } while (purchaseAmount == 0);
        OutputView.printEmptyLine();
        return purchaseAmount;
    }

    private static int validatePurchaseAmount(String input) {
        try {
            return PurchaseAmountValidator.parseAndValidatePurchaseAmount(input);
        } catch (IllegalArgumentException e) {
            OutputView.printMessage(e.getMessage());
            return 0;
        }
    }

    public static List<Integer> getWinningNumbers() {
        List<Integer> winningNumbers;
        do {
            String input = getPlayerInput("당첨 번호를 입력해 주세요");
            winningNumbers = parseAndValidateWinningNumbers(input);
        } while (winningNumbers == null);
        OutputView.printEmptyLine();
        return winningNumbers;
    }

    private static List<Integer> parseAndValidateWinningNumbers(String input) {
        try {
            return parseWinningNumbers(input);
        } catch (IllegalArgumentException e) {
            OutputView.printMessage(e.getMessage());
            return null;
        }
    }

    private static List<Integer> parseWinningNumbers(String input) {
        WinningNumbersValidator.validateInputFormat(input);
        WinningNumbersValidator.validateWinningNumbers(input);
        return StringUtil.splitAndParse(input, ",");
    }

    public static int getBonusNumber(Set<Integer> winningNumbers) {
        int bonusNumber;
        do {
            String input = getPlayerInput("보너스 번호를 입력해 주세요");
            bonusNumber = validateBonusNumber(input, winningNumbers);
        } while (bonusNumber == 0);
        return bonusNumber;
    }

    private static int validateBonusNumber(String input, Set<Integer> winningNumbers) {
        try {
            return BonusNumberValidator.validateBonusNumber(input, winningNumbers);
        } catch (IllegalArgumentException e) {
            OutputView.printMessage(e.getMessage());
            return 0;
        }
    }
}
