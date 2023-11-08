package lotto.controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import lotto.domain.GameResultJudge;
import lotto.domain.GameReturnRateCalculator;
import lotto.domain.LottoGenerator;
import lotto.domain.Rank;
import lotto.view.InputView;
import lotto.view.OutputView;
import lotto.vo.Lotto;
import lotto.vo.WinLotto;

public class GameController {
    private static final int LOTTO_PRICE = 1000;

    private BigDecimal buyPrice;

    public void start() {
        List<Lotto> userLottoes = buyUserLottos();
        WinLotto winLotto = getWinLottoNumbers();
        Map<Rank, Integer> rankingCountResult = showMatchResult(winLotto, userLottoes);
        showReturnRate(rankingCountResult);
    }

    private List<Lotto> buyUserLottos() {
        buyPrice = InputView.readLottoPrice();
        BigDecimal lottoCount = getLottoCount(buyPrice);

        List<Lotto> lottoes = LottoGenerator.generateLottoes(lottoCount);

        OutputView.printLottoes(lottoes);
        return lottoes;
    }

    private BigDecimal getLottoCount(BigDecimal price) {
        return price.divide(BigDecimal.valueOf(LOTTO_PRICE));
    }

    private WinLotto getWinLottoNumbers() {
        List<Integer> winNumbers = InputView.readWinningNumber();
        int bonusNumber = InputView.readBonusNumber(winNumbers);

        return new WinLotto(winNumbers, bonusNumber);
    }

    private Map<Rank, Integer> showMatchResult(WinLotto winLotto, List<Lotto> userLottos) {
        Map<Rank, Integer> rankCountMap = GameResultJudge.judge(winLotto, userLottos);
        OutputView.printResultLottoPrize(rankCountMap);
        return rankCountMap;
    }

    private void showReturnRate(Map<Rank, Integer> rankingCountResult) {
        BigDecimal out = GameReturnRateCalculator.getReturnRate(rankingCountResult, buyPrice);
        OutputView.printPrizePercentResult(out);
    }
}