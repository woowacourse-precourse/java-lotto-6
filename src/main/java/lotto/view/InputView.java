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
        int purchaseAmount = 0;
        while (purchaseAmount == 0) {
            String input = getPlayerInput("구입 금액을 입력해 주세요");
            try {
                purchaseAmount = PurchaseAmountValidator.parseAndValidatePurchaseAmount(input);
            } catch (IllegalArgumentException e) {
                OutputView.printMessage(e.getMessage());
            }
        }
        OutputView.printEmptyLine();
        return purchaseAmount;
    }

    public static List<Integer> getWinningNumbers() {
        while (true) {
            String input = getPlayerInput("당첨 번호를 입력해 주세요");
            try {
                WinningNumbersValidator.validateInputFormat(input);
                List<Integer> winningNumbers = StringUtil.convertToIntegerList(input, ",");
                WinningNumbersValidator.validateWinningNumbers(input);
                OutputView.printEmptyLine();
                return winningNumbers;
            } catch (IllegalArgumentException e) {
                OutputView.printMessage(e.getMessage());
            }
        }
    }

    public static int getBonusNumber(Set<Integer> winningNumbers) {
        int bonusNumber = 0;
        while (bonusNumber == 0) {
            String input = getPlayerInput("보너스 번호를 입력해 주세요");
            try {
                bonusNumber = BonusNumberValidator.validateBonusNumber(input, winningNumbers);
                OutputView.printEmptyLine();
            } catch (IllegalArgumentException e) {
                OutputView.printMessage(e.getMessage());
            }
        }
        return bonusNumber;
    }
}
