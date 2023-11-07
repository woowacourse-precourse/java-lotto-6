package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.utils.Validator.canDivideByKilo;
import static lotto.utils.Validator.isDigit;
import static lotto.utils.Validator.isMoneyOverKilo;

public class InputView {

    public static int inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        String money = readLine();
        isDigit(money);
        canDivideByKilo(money);
        isMoneyOverKilo(money);
        return Integer.parseInt(money);
    }

    public static String inputWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        return readLine();
    }

    public static int inputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String inputBonusNumber = readLine();
        isDigit(inputBonusNumber);

        return Integer.parseInt(inputBonusNumber);
    }
}