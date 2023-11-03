package lotto.domain;

import java.util.List;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LotteryStore {
    private static final int lotteryPrice = 1000;
    private static List<Integer> winningNumber;
    private static int bonusNumber;

    public void buyLotto() {
        OutputView.print("BUY_CASH");
        int cash = Integer.parseInt(InputView.getInput("number"));
        checkCash(cash);
        int buyCount = cash / 1000;
        OutputView.print_value_front("GET_LOTTO", String.valueOf(buyCount));
        for (int i = 0; i < buyCount; i++) {
            Player.addLotto();
        }

    }

    private void checkCash(int cash) {
        if (cash % 1000 > 0) {
            throw new IllegalArgumentException("[ERROR] 1000원 단위로 입력해 주세요.");
        }
    }

}
