package lotto;

import lotto.domain.EarnRate;
import lotto.domain.LottoService;
import lotto.domain.LotteryDraw;

public class Application {
    public static void main(String[] args) {
        LottoService lottoService = new LottoService();
        LotteryDraw winnerCheck = new LotteryDraw(lottoService);
        winnerCheck.printDrawResult();
        EarnRate earnRate = new EarnRate(lottoService.getAmount(), winnerCheck.getMatchCountLotto());
        earnRate.printEarnRate();
    }
}
