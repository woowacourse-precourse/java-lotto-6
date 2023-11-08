package lotto.view;

import static lotto.constant.MessageConstants.REQUEST_BONUS_NUMBER;
import static lotto.constant.MessageConstants.REQUEST_INPUT_MONEY;
import static lotto.constant.MessageConstants.REQUEST_WINNING_NUMBER;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.util.Parser;
import lotto.validator.InputValidator;
import lotto.validator.MoneyValidator;

public class LottoInputView {

    public long inputUserMoney() {
        System.out.println(REQUEST_INPUT_MONEY);

        String money = Console.readLine();
        InputValidator.validateMoney(money);

        MoneyValidator moneyValidator = new MoneyValidator(money);
        moneyValidator.validateAll();

        return Long.parseLong(money);
    }

    public List<Integer> inputWinningNumber() {
        System.out.println(REQUEST_WINNING_NUMBER);

        String winningNumber = Console.readLine();
        return Parser.parseStringToInteger(winningNumber);
    }

    public int inputBonusNumber() {
        System.out.println(REQUEST_BONUS_NUMBER);

        String bonusNumber = Console.readLine();
        InputValidator.validateBonusNumber(bonusNumber);
        return Integer.parseInt(bonusNumber);
    }

}
