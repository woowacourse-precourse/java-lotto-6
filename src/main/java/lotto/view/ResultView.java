package lotto.view;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.service.LottoService;

public class ResultView {
    private static final LottoService lottoService = new LottoService();

    public List<Lotto> showPurchasedLottos(int purchaseAmount) {
        System.out.println(purchaseAmount / 1000 + "개를 구매했습니다.");
        List<Lotto> lottos = lottoService.provideLotto(purchaseAmount / 1000);
        lottoService.printLottos(lottos);
        System.out.println();
        return lottos;
    }

    public void showWinningResult(List<Lotto> lottos, Lotto winningNumbers, int bonusNumber, int purchaseAmount) {
        System.out.println("당첨 통계");
        System.out.println("---");
        LottoResult lottoResult = lottoService.lotteryStatistics(lottos, winningNumbers, bonusNumber);
        showLottoResult(lottoResult);
        showROI(purchaseAmount, lottoResult.total());
    }

    public void showLottoResult(LottoResult lottoResult) {
        int[] countResult = lottoResult.getLottoResult();
        System.out.println("3개 일치 (5,000원) - " + countResult[0] + "개");
        System.out.println("4개 일치 (50,000원) - " + countResult[1] + "개");
        System.out.println("5개 일치 (1,500,000원) - " + countResult[2] + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + countResult[4] + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + countResult[3] + "개");
    }

    public void showROI(int purchaseAmount, int total) {
        System.out.printf("총 수익률은 %.1f%%입니다.\n", lottoService.getROI(purchaseAmount, total));
    }
}
