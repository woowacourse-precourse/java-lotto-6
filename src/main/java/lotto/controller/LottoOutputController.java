package lotto.controller;

import lotto.dto.LottoGameInfo;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoRank;
import lotto.domain.lotto.Lottos;
import lotto.dto.LottoResult;
import lotto.view.output.LottoBuyOutputView;
import lotto.view.output.LottoResultOutputView;

import java.util.Map;

public class LottoOutputController {
    private final LottoBuyOutputView lottoBuyOutputView;
    private final LottoResultOutputView lottoResultOutputView;

    public LottoOutputController(LottoBuyOutputView lottoBuyOutputView, LottoResultOutputView lottoResultOutputView) {
        this.lottoBuyOutputView = lottoBuyOutputView;
        this.lottoResultOutputView = lottoResultOutputView;
    }

    public void printBuyLottos(LottoGameInfo lottoGameInfo) {
        // 구매한 로또 번호 출력 - output
        printBuyLottos(lottoGameInfo.getLottos());
    }

    public void resultMessage(LottoGameInfo lottoGameInfo, LottoResult lottoResult) {
        //당첨 통계
        Map<LottoRank, Long> lottoRankCountMap =
                printResult(lottoGameInfo.getLottos(), lottoResult.getWinningLotto(), lottoResult.getBonusNumber());

        //총 수익률
        printTotalProfitRate(lottoGameInfo.getAmount(), lottoRankCountMap);
    }

    private void printBuyLottos(Lottos lottos) {
        lottoBuyOutputView.printPurchaseLottoCountMessage(lottos);
        lottoBuyOutputView.printAllLottoNumbers(lottos);
    }


    private Map<LottoRank, Long> printResult(Lottos lottos, Lotto winningLotto, int bonus) {
        Map<LottoRank, Long> lottoRankCountMap = lottos.setLottoRankCountMap(winningLotto, bonus);
        printStartResultMessage();
        lottoResultOutputView.printLottoAllMatch(lottoRankCountMap);

        return lottoRankCountMap;
    }

    private void printStartResultMessage() {
        lottoResultOutputView.printWinningStatisticsStartMessage();
        lottoResultOutputView.printDashLine();
    }

    private void printTotalProfitRate(int amount, Map<LottoRank, Long> lottoRankCountMap) {
        lottoResultOutputView.printTotalProfitRate(amount, lottoRankCountMap);
    }
}
