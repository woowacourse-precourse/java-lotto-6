package lotto.domain.result;

import lotto.domain.lotto.Lotto;

import java.util.List;

public class Result {

    public void showTotalResult(List<Lotto> lottoTicketList, List<Integer> userLottoNumbers, Integer userBonusNumber, Integer quantity) {
        LottoResult lottoResult = new LottoResult();
        Profit profit = new Profit();

        List<Integer> prizeCounts = lottoResult.announceLottoResult(lottoTicketList, userLottoNumbers, userBonusNumber);

        profit.announceProfitResult(prizeCounts, quantity);
    }
}
