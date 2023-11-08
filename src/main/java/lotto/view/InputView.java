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

    public static List<Integer> getWinningLotto() {
        String winningLotto;
        do {
            System.out.println();
            winningLotto = printWinningLottoInputMessage();
        } while (validateWinningLottoInput(winningLotto));
        return Utils.convertStringToList(winningLotto);
    }

    private static String printWinningLottoInputMessage() {
        System.out.println("당첨 번호를 입력해 주세요.");
        return Console.readLine();
    }

    private static boolean validateWinningLottoInput(String winningLotto) {
        if (WinningLottoValidator.isInvalid(winningLotto)
                || WinningLottoValidator.hasSpecialCharacter(winningLotto)
                || WinningLottoValidator.isInvalidSize(winningLotto)
                || WinningLottoValidator.isDuplicated(winningLotto)
                || WinningLottoValidator.isInvalidNumber(winningLotto)) {
            return true;
        }
        return false;
    }

    public static int getBonusLotto(List<Integer> winningLotto) {
        String bonusLotto;
        do {
            bonusLotto = printBonusLottoInputMessage();
        } while (validateBonusLottoInput(bonusLotto, winningLotto));
        return Utils.convertStringToInt(bonusLotto);
    }

    private static String printBonusLottoInputMessage() {
        System.out.println("보너스 번호를 입력해 주세요.");
        return Console.readLine();
    }

    private static boolean validateBonusLottoInput(String bonusLotto, List<Integer> winningLotto) {
        if (BonusLottoValidator.isInvalid(bonusLotto)
                || BonusLottoValidator.isInvalidNumber(bonusLotto)
                || BonusLottoValidator.isDuplicated(bonusLotto, winningLotto)) {
            return true;
        }
        return false;
    }
}
