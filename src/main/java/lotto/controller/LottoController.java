package lotto.controller;

import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoRank;
import lotto.domain.lotto.Lottos;
import lotto.util.LottoFactory;
import lotto.view.input.LottoNumberInputView;
import lotto.view.input.LottoShopInput;
import lotto.view.output.LottoBuyOutputView;
import lotto.view.output.LottoResultOutputView;

import java.util.List;
import java.util.Map;

public class LottoController {

    private final LottoShopInput lottoShopInput;
    private final LottoNumberInputView lottoNumberInputView;
    private final LottoBuyOutputView lottoBuyOutputView;
    private final LottoResultOutputView lottoResultOutputView;

    public LottoController(LottoShopInput lottoShopInput, LottoNumberInputView lottoNumberInputView,
                           LottoBuyOutputView lottoBuyOutputView, LottoResultOutputView lottoResultOutputView) {

        this.lottoShopInput = lottoShopInput;
        this.lottoNumberInputView = lottoNumberInputView;
        this.lottoResultOutputView = lottoResultOutputView;
        this.lottoBuyOutputView = lottoBuyOutputView;
    }

    public void run() {
        //구매 - input
        int amount = requestLottoPurchaseAmount();
        Lottos lottos = buyLottos(amount);

        // 구매한 로또 번호 출력 - output
        printBuyLottos(lottos);

        //당첨 번호랑 보너스 번호
        Lotto winningLotto = requestWinningLotto();
        int bonusLottoNumber = requestBonusLottoNumber(winningLotto);

        //당첨 통계
        Map<LottoRank, Long> lottoRankCountMap = printResult(lottos, winningLotto, bonusLottoNumber);
        //총 수익률
        printTotalProfitRate(amount, lottoRankCountMap);
    }

    private int requestLottoPurchaseAmount() {
        return lottoShopInput.requestLottoPurchaseAmount();
    }

    private Lottos buyLottos(int amount) {
        return lottoShopInput.buyLottos(amount);
    }

    public void printBuyLottos(Lottos lottos) {
        lottoBuyOutputView.printPurchaseLottoCountMessage(lottos);
        lottoBuyOutputView.printAllLottoNumbers(lottos);
    }

    public Lotto requestWinningLotto() {
        List<Integer> winningLottoNumbers = lottoNumberInputView.requestWinningLottoNumbers();
        return LottoFactory.getLotto(winningLottoNumbers);
    }

    public int requestBonusLottoNumber(Lotto winningLotto) {
        return lottoNumberInputView.requestBonusLottoNumber(winningLotto);
    }

    public Map<LottoRank, Long> printResult(Lottos lottos, Lotto winningLotto, int bonus) {
        Map<LottoRank, Long> lottoRankCountMap = lottos.setLottoRankCountMap(winningLotto, bonus);
        printWinningStatisticsStartMessage();
        printDashLine();
        lottoResultOutputView.printLottoAllMatch(lottoRankCountMap);

        return lottoRankCountMap;
    }

    private void printWinningStatisticsStartMessage() {
        lottoResultOutputView.printWinningStatisticsStartMessage();
    }

    private void printDashLine() {
        lottoResultOutputView.printDashLine();
    }

    private void printTotalProfitRate(int amount, Map<LottoRank, Long> lottoRankCountMap) {
        lottoResultOutputView.printTotalProfitRate(amount, lottoRankCountMap);
    }

}
