package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Bonus;
import lotto.domain.Money;
import lotto.domain.WinningLotto;
import lotto.utils.InputConvertor;
import lotto.utils.InputValidator;

public class InputView implements Viewable {

    private static final InputView inputView = new InputView();
    private static final String MONEY_INPUT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String WINNING_INPUT_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_INPUT_MESSAGE = "보너스 번호를 입력해 주세요.";

    public static Viewable getInstance() {
        return new ProxyInputView(inputView);
    }

    private String getInput(String message) {
        System.out.println(message);
        return InputValidator.validate(Console.readLine());
    }

    public Money getMoneyInput() {
        String money = getInput(MONEY_INPUT_MESSAGE);
        money = InputValidator.validateMoney(money);
        return InputConvertor.convertMoney(money);
    }

    public Bonus getBonusInput() {
        String bonus = getInput(BONUS_INPUT_MESSAGE);
        InputValidator.validateLottoNumber(bonus);
        return InputConvertor.convertBonus(bonus);
    }

    public WinningLotto getWinningInput() {
        String winnings = getInput(WINNING_INPUT_MESSAGE);
        InputValidator.validateWinnings(winnings);
        return InputConvertor.convertWinnings(winnings);
    }

}
