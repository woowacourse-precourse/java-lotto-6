package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Bonus;
import lotto.domain.Money;
import lotto.domain.WinningLotto;
import lotto.utils.InputConvertor;
import lotto.utils.InputValidator;

public class InputView {
    private static final String MONEY_INPUT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String WINNING_INPUT_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_INPUT_MESSAGE = "보너스 번호를 입력해 주세요.";

    private static String getInput(final String message) {
        System.out.println(message);
        try {
            return InputValidator.validate(Console.readLine());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getInput(message);
        }
    }

    public static Money getMoneyInput() {
        String money = getInput(MONEY_INPUT_MESSAGE);
        try {
            money = InputValidator.validateMoney(money);
            return InputConvertor.convertMoney(money);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getMoneyInput();
        }
    }

    public static Bonus getBonusInput() {
        String bonus = getInput(BONUS_INPUT_MESSAGE);
        try {
            InputValidator.validateLottoNumber(bonus);
            return InputConvertor.convertBonus(bonus);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getBonusInput();
        }
    }

    public static WinningLotto getWinningInput() {
        String winnings = getInput(WINNING_INPUT_MESSAGE);
        try {
            InputValidator.validateWinnings(winnings);
            return InputConvertor.convertWinnings(winnings);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getWinningInput();
        }
    }

}
