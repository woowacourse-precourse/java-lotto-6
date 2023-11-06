package lotto;

import java.util.List;
import lotto.input.InputUtil;
import lotto.lotto.Draw;

public class Application {
    public static void main(String[] args) {
        final long money = InputUtil.inputMoney();

        final User user = new User(money);
        user.printMyLotto();

        final List<Integer> winningNumbers = InputUtil.inputWinningNumbers();
        final int bonusNumber = InputUtil.inputBonusNumber(winningNumbers);

        final Draw draw = new Draw(winningNumbers, bonusNumber);
        user.doDraw(draw);
    }
}
