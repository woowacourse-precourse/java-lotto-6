package lotto.controller;

import lotto.domain.lotto.Cash;
import lotto.domain.lotto.LottoRank;
import lotto.dto.LottoGameInfo;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.Lottos;
import lotto.dto.LottoResult;
import lotto.util.LottoShop;
import lotto.view.input.ConsoleInput;
import lotto.view.output.LottoBuyOutputView;
import lotto.view.output.LottoResultOutputView;

import java.util.Map;

public class LottoGameController {

    private final ConsoleInput inputView;
    private final LottoBuyOutputView lottoBuyOutputView;
    private final LottoResultOutputView lottoResultOutputView;

    public LottoGameController(ConsoleInput inputView, LottoBuyOutputView lottoBuyOutputView,
                               LottoResultOutputView lottoResultOutputView) {

        this.inputView = inputView;
        this.lottoBuyOutputView = lottoBuyOutputView;
        this.lottoResultOutputView = lottoResultOutputView;
    }

    public LottoGameInfo startLottoGame() {
        Cash cash = inputView.requestLottoCash();
        Lottos lottos = LottoShop.buyLottos(cash);
        LottoGameInfo lottoGameInfo = new LottoGameInfo(cash, lottos);

        printBuyLottos(lottoGameInfo);
        return lottoGameInfo;
    }

    public void printLottoResult(LottoGameInfo lottoGameInfo) {
        Lotto winningLotto = inputView.requestWinningLotto();
        int bonusLottoNumber = inputView.requestBonusLottoNumber(winningLotto);
        LottoResult lottoResult = new LottoResult(winningLotto, bonusLottoNumber);

        resultMessage(lottoGameInfo, lottoResult);
    }

    private void printBuyLottos(LottoGameInfo lottoGameInfo) {
        Lottos lottos = lottoGameInfo.getLottos();
        lottoBuyOutputView.printPurchaseLottoCountMessage(lottos);
        lottoBuyOutputView.printAllLottoNumbers(lottos);
    }

    public void resultMessage(LottoGameInfo lottoGameInfo, LottoResult lottoResult) {
        Map<LottoRank, Long> lottoRankCountMap =
                printResult(lottoGameInfo.getLottos(), lottoResult);

        lottoResultOutputView.printTotalProfitRate(lottoGameInfo.getCash(), lottoRankCountMap);
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

}
