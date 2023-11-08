package lotto.view;

import java.util.List;
import lotto.constant.InputMessage;
import lotto.util.InputUtil;
import lotto.validator.Validator;

public class InputView {
    public static String inputMoney() {
        System.out.println(InputMessage.REQUEST_MONEY_MESSAGE.getMessage());
        String money = InputUtil.readInput();
        OutputView.printNextLine();
        try {
            Validator.validateMoney(money);
        } catch (IllegalArgumentException e) {
            return inputMoney();
        }
        return money;
    }

    public static String readLotto() {
        System.out.println(InputMessage
                .REQUEST_WINNING_NUMBERS_MESSAGE.getMessage());
        String lotto = InputUtil.readInput();
        OutputView.printNextLine();
        try {
            Validator.validateLotto(lotto);
        } catch (IllegalArgumentException e) {
            return readLotto();
        }
        return lotto;
    }

    public static String readBonusNumber(List<Integer> winningNumber) {
        System.out.println(InputMessage.REQUEST_BONUS_NUMBER_MESSAGE.getMessage());
        String bonusNumber = InputUtil.readInput();
        OutputView.printNextLine();
        try {
            Validator.validateBonusNumber(bonusNumber, winningNumber);
        } catch (IllegalArgumentException e) {
            return readBonusNumber(winningNumber);
        }
        return bonusNumber;
    }
}
