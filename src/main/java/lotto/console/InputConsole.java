package lotto.console;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.Lotto;
import lotto.model.Capital;
import lotto.utils.StringUtil;

public class InputConsole {
    public static Capital getPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");

        String input = Console.readLine();

        try {
            return StringUtil.stringToMoney(input);
        } catch (IllegalArgumentException exception) {
            return getPurchaseAmount();
        }
    }

    public static Lotto getWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");

        String input = Console.readLine();

        try {
            return StringUtil.stringToLottery(input);
        } catch (IllegalArgumentException exception) {
            return getWinningNumbers();
        }
    }

    public static int getBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");

        String input = Console.readLine();

        try {
            return StringUtil.stringToInt(input);
        } catch (IllegalArgumentException exception) {
            return getBonusNumber();
        }
    }
}
