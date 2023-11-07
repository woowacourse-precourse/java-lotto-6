package lotto.domain;

import java.util.List;
import java.util.Map;

public class RunGame {
    public void lottoGame() {
        Input.inputMoneyMessage();

        IssuedLotto issuedLotto = new IssuedLotto();
        List<List<Integer>> lottoTickets = issuedLotto.showLottoTickets();
        for (List<Integer> lottoTicket : lottoTickets) {
            System.out.println(lottoTicket);
        }

        Input.inputLottoMessage();
        Input.inputBonusNumberMessage();

        int bonusNumber = Input.getBonusNumber();
        List<Integer> numbers = Input.getNumbers();
        List<List<Integer>> lottoBundle = issuedLotto.getLottoBundle();

        LottoResult.checkLottoBundle(lottoBundle, numbers, bonusNumber);

        int money = Input.getMoney();
        Map<LottoPrize, Integer> prizeCounts = LottoResult.getPrizeCounts(lottoBundle, numbers, bonusNumber);

        Profit.showProfit(prizeCounts, money);

    }
}
