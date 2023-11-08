package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.Exception.LottoException;
import lotto.validation.InputValidator;
import lotto.validation.MoneyInputValidator;

public class InputView {

    InputValidator inputValidator = new InputValidator();
    MoneyInputValidator moneyInputValidator = new MoneyInputValidator();
    LottoException lottoException = new LottoException();

    public String inputMoney() {
        String money = "";
        while (true) {
            money = Console.readLine();
            try {
                checkMoneyNumber(money);
                break;
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
                continue;
            }
        }
        return money;
    }

    public void checkMoneyNumber(String money) throws IllegalArgumentException {
        if (!inputValidator.isNumber(money)) {
            lottoException.notNumber();
        }
        checkMoneyThousand(money);
    }

    public void checkMoneyThousand(String money) throws IllegalArgumentException {
        int realMoney = Integer.parseInt(money);
        if (!moneyInputValidator.isDividedThousand(realMoney)) {
            lottoException.notThousand();
        }
    }

    public String inputWinningNumber() {
        return null;
    }

    public String inputBonusNumber() {
        return null;
    }
}
