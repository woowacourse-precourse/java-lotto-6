package lotto;

import lotto.controller.Money;
import lotto.utils.LottoUtil;
import lotto.view.LottoView;

public class Application {
    private static LottoView lottoView = new LottoView();

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        lottoView.printBuyLottomMoneyMessage();
        Money money = new Money();
        lottoView.printLottoTicketCount(money.getCount());

    }

}
