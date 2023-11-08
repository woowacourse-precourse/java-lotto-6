package lotto;

import lotto.domain.EarnRate;
import lotto.domain.LottoService;
import lotto.domain.LotteryDraw;
import lotto.io.OutputHandler;

public class Application {
    public static void main(String[] args) {
        LottoService lottoService = new LottoService();
        LotteryDraw winnerCheck = new LotteryDraw(lottoService);
        OutputHandler.printPrizeStat(winnerCheck.getMatchCountLotto());
        EarnRate er = new EarnRate(lottoService.getAmount());
        er.getTotalEarning(winnerCheck.getMatchCountLotto());
        OutputHandler.printReturnRate(er.getEarnRate());
    }
}
