package lotto;

import java.util.List;
import lotto.constants.LottoPrize;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.LottoTicket;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        List<Lotto> lottos = LottoTicket.generate(5);
        OutputView.displayPurchasedLotto(5, lottos);
        LottoResult lottoResult = new LottoResult();
        lottoResult.save(LottoPrize.FIRST);
        System.out.println(lottoResult.getStatistics().keySet());
        OutputView.displayWinningStatistics(lottoResult.getStatistics(), lottoResult.calculateEarningRate(1000));
    }
}
