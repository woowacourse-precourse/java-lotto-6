package lotto;

import lotto.object.Host;
import lotto.object.Lotto;
import lotto.object.User;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        User user = new User();
        Host host = new Host();
        user.purchaseAmountInput();
        host.lottoIssuance(user);
        user.lottoWinningNumberInput();
        user.bonusNumberInput();
        host.winningStatistics(user);

    }
}
