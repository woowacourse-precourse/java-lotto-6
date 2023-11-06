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
        List<Lotto> lottos = buyLottos();
        WinLotto winLotto = drawLottoNumber();
        Map<Rank, Integer> rankCountMap = matchResult(winLotto, lottos);
        returnRate(rankCountMap);
    }
    
    private List<Lotto> buyLottos() {
        //1) 구매 금액 입력받기
        buyPrice = InputView.readLottoPrice();
        BigDecimal lottoCount = getLottoCount(buyPrice);

        //2) 구매 가능한 로또 개수만큼 로또 자동 발급 기능
        List<Lotto> lottos = LottoGenerator.generateLottoList(lottoCount);

        //3) 발급한 로또 번호 출력 기능
        OutputView.printLottos(lottos);
        return lottos;
    }

    private BigDecimal getLottoCount(BigDecimal price) {
        return price.divide(BigDecimal.valueOf(LOTTO_PRICE));
    }

    // 번호 추첨 (당첨번호 입력)
    private WinLotto drawLottoNumber() {
        //4) 당첨 번호 입력 기능
        List<Integer> winNumbers = InputView.readWinningNumber();

        //5) 보너스 번호 입력 기능
        int bonusNumber = InputView.readBonusNumber(winNumbers);

        WinLotto winLotto = new WinLotto(winNumbers, bonusNumber);
        return winLotto;
    }

    // 당첨 결과
    private Map<Rank, Integer> matchResult(WinLotto winLotto, List<Lotto> lottos) {
        Map<Rank, Integer> rankCountMap = GameResultJudge.judge(winLotto, lottos);
        OutputView.printResultLottoPrize(rankCountMap);
        return rankCountMap;
    }

    // 수익률
    private void returnRate(Map<Rank, Integer> rankCountMap) {
        BigDecimal out = GameReturnRateCalculator.getReturnRate(rankCountMap, buyPrice);
        OutputView.printPrizePercentResult(out);
    }

}