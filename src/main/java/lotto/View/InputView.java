package lotto.View;

import camp.nextstep.edu.missionutils.Console;
import lotto.Validator.BonusNumberValidator;
import lotto.Validator.MoneyValidator;
import lotto.Validator.WinningNumberValidator;

public class InputView {

    public static String inputPurchaseAmount() {
        while (true) {
            System.out.println("구입금액을 입력해 주세요.");
            String input = Console.readLine();
        }
    }

    public static String inputWinningNumber() {
        while (true) {
            System.out.println("당첨 번호를 입력해 주세요.");
            String input = Console.readLine();
        }
    }

    public static String inputBonusNumber() {
        while (true) {
            System.out.println("보너스 번호를 입력해 주세요.");
            String input = Console.readLine();
        }
    }
}