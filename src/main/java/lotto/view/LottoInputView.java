package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.util.Parser;
import lotto.validator.InputValidator;
import lotto.validator.MoneyValidator;

public class LottoInputView {

    public long inputUserMoney() {
        System.out.println("구입금액을 입력해 주세요.");

        String money = Console.readLine();
        InputValidator.validateMoney(money);

        MoneyValidator moneyValidator = new MoneyValidator(money);
        moneyValidator.validateAll();

        return Long.parseLong(money);
    }

    public List<Integer> inputWinningNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");

        String winningNumber = Console.readLine();
        return Parser.parseStringToInteger(winningNumber);
    }

    public int inputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");

        String bonusNumber = Console.readLine();
        InputValidator.validateBonusNumber(bonusNumber);
        return Integer.parseInt(bonusNumber);
    }

}
