package lotto;

import lotto.controller.Money;
import lotto.utils.LottoUtil;
import lotto.view.LottoView;

import java.util.ArrayList;
import java.util.List;

public class Application {
    static LottoView lottoView = new LottoView();
    static LottoUtil lottoUtil = new LottoUtil();
    public static void main(String[] args) {
        lottoView.printBuyLottomMoneyMessage();
        Money money = new Money();
        lottoView.printLottoTicketCount(money.getCount());
        List<List<Integer>> lottos = lottoUtil.getLottos(money.getCount());
        lottoView.printLottoNumbers(lottos);

    }

}
