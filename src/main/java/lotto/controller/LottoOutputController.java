package lotto.controller;

import lotto.dto.LottoGameInfo;
import lotto.domain.lotto.LottoRank;
import lotto.domain.lotto.Lottos;
import lotto.dto.LottoResult;
import lotto.view.output.LottoBuyOutputView;
import lotto.view.output.LottoResultOutputView;

import java.util.Map;

public class LottoOutputController {
    private final LottoBuyOutputView lottoBuyOutputView;
    private final LottoResultOutputView lottoResultOutputView;

    public LottoOutputController() {
        this.lottoBuyOutputView = new LottoBuyOutputView();
        this.lottoResultOutputView = new LottoResultOutputView();
    }

    public void printBuyLottos(LottoGameInfo lottoGameInfo) {
        Lottos lottos = lottoGameInfo.getLottos();
        lottoBuyOutputView.printPurchaseLottoCountMessage(lottos);
        lottoBuyOutputView.printAllLottoNumbers(lottos);
    }

    public void resultMessage(LottoGameInfo lottoGameInfo, LottoResult lottoResult) {
        //당첨 통계
        Map<LottoRank, Long> lottoRankCountMap =
                printResult(lottoGameInfo.getLottos(), lottoResult);

        //총 수익률
        printTotalProfitRate(lottoGameInfo.getAmount(), lottoRankCountMap);
    }


    private Map<LottoRank, Long> printResult(Lottos lottos, LottoResult lottoResult) {
        Map<LottoRank, Long> lottoRankCountMap = lottos.getLottoRankCountMap(lottoResult);
        printStartResultMessage();
        lottoResultOutputView.printLottoAllMatch(lottoRankCountMap);

        return lottoRankCountMap;
    }

    private void printStartResultMessage() {
        lottoResultOutputView.printWinningStatisticsStartMessage();
        lottoResultOutputView.printDashLine();
    }

    private void printTotalProfitRate(long amount, Map<LottoRank, Long> lottoRankCountMap) {
        lottoResultOutputView.printTotalProfitRate(amount, lottoRankCountMap);
    }
}
