package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.util.Utils;
import lotto.validator.BonusLottoValidator;
import lotto.validator.MoneyValidator;
import lotto.validator.WinningLottoValidator;

import java.util.List;

public class InputView {
    public static long getMoney() {
        String money;
        do {
            money = printMoneyInputMessage();
        } while (validateMoneyInput(money));
        return Utils.convertStringToLong(money);
    }

    private static String printMoneyInputMessage() {
        System.out.println("구입금액을 입력해 주세요.");
        return Console.readLine();
    }

    private static boolean validateMoneyInput(String money) {
        if (MoneyValidator.isNumber(money)
                || MoneyValidator.isValid(money)) {
            return true;
        }
        return false;
    }

    public static List<Integer> getWinningNumber() {
        String winningNumber;
        do {
            System.out.println();
            winningNumber = printWinningNumberInputMessage();
        } while (validateWinningNumberInput(winningNumber));
        return Utils.convertStringToList(winningNumber);
    }

    private static String printWinningNumberInputMessage() {
        System.out.println("당첨 번호를 입력해 주세요.");
        return Console.readLine();
    }

    private static boolean validateWinningNumberInput(String winningNumber) {
        if (WinningLottoValidator.isInvalid(winningNumber)
                || WinningLottoValidator.hasSpecialCharacter(winningNumber)
                || WinningLottoValidator.isInvalidSize(winningNumber)
                || WinningLottoValidator.isDuplicated(winningNumber)
                || WinningLottoValidator.isInvalidNumber(winningNumber)) {
            return true;
        }
        return false;
    }

    public static int getBonusNumber(List<Integer> winningNumber) {
        String bonusNumber;
        do {
            bonusNumber = printBonusNumberInputMessage();
        } while (validateBonusNumberInput(bonusNumber, winningNumber));
        return Utils.convertStringToInt(bonusNumber);
    }

    private static String printBonusNumberInputMessage() {
        System.out.println("보너스 번호를 입력해 주세요.");
        return Console.readLine();
    }

    private static boolean validateBonusNumberInput(String bonusNumber, List<Integer> winningNumber) {
        if (BonusLottoValidator.isInvalid(bonusNumber)
                || BonusLottoValidator.isInvalidNumber(bonusNumber)
                || BonusLottoValidator.isDuplicated(bonusNumber, winningNumber)) {
            return true;
        }
        return false;
    }
}
