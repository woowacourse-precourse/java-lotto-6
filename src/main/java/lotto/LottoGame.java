package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class LottoGame {
    private List<Lotto> lottos;
    private MoneyToBuy moneyToBuy;

    public LottoGame() {
    }

    public void run() {
        requestMoneyToBuy();

    }

    private void requestMoneyToBuy() {
        System.out.println(OutputMessage.REQUEST_MONEY_TO_BUY.getMessage());
        String string = Console.readLine();
        moneyToBuy = MoneyToBuy.stringToMoney(string);
    }
}
