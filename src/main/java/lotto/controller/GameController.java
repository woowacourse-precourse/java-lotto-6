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
        List<Lotto> userLottos = buyUserLottos();
        WinLotto winLotto = getWinLottoNumbers();
        Map<Rank, Integer> rankingCountResult = showMatchResult(winLotto, userLottos);
        showReturnRate(rankingCountResult);
    }

    //1) 로또 구매 = 로또 개수 카운팅해서 -> 개수만큼 사용자의 로또 생성하여 발급한 로또 출력함
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

    // 2) (당첨번호, 보너스 번호) --> WinLotto 생성
    private WinLotto getWinLottoNumbers() {
        //4) 당첨 번호 입력 기능
        List<Integer> winNumbers = InputView.readWinningNumber();

        //5) 보너스 번호 입력 기능
        int bonusNumber = InputView.readBonusNumber(winNumbers);

        WinLotto winLotto = new WinLotto(winNumbers, bonusNumber);
        return winLotto;
    }

    // 3) WinLotto와 User의 Lotters 들을 각각 비교하여, 당첨 결과 출력
    private Map<Rank, Integer> showMatchResult(WinLotto winLotto, List<Lotto> userLottos) {
        Map<Rank, Integer> rankCountMap = GameResultJudge.judge(winLotto, userLottos);
        OutputView.printResultLottoPrize(rankCountMap);
        return rankCountMap;
    }

    // 4) 수익률 구하여 출력
    private void showReturnRate(Map<Rank, Integer> rankCountMap) {
        BigDecimal out = GameReturnRateCalculator.getReturnRate(rankCountMap, buyPrice);
        OutputView.printPrizePercentResult(out);
    }

}