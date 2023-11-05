package lotto.controller;

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

    private int getLottoCount(int price) {
        return price / LOTTO_PRICE;
    }

    //전체 게임 여기서 컨트롤
    public void gameStart() {
        //1) 구매 금액 입력받기
        int price = InputView.readLottoPrice();
        int lotto_count = getLottoCount(price);

        //2) 구매 가능한 로또 개수만큼 로또 자동 발급 기능
        List<Lotto> lotto_list = LottoGenerator.generateLottoList(lotto_count);

        //3) 발급한 로또 번호 출력 기능
        OutputView.printLottoCount(lotto_count);
        for (int i = 0; i < lotto_count; i++) {
            OutputView.printCurrentLottoList(lotto_list.get(i));
        }

        //4) 당첨 번호 입력 기능
        List<Integer> winNumbers = InputView.readWinningNumber();

        //5) 보너스 번호 입력 기능
        int bonusNumber = InputView.readBonusNumber(winNumbers);

        WinLotto winLotto = new WinLotto(winNumbers, bonusNumber);

        //6) 당첨에 대한 통계 기능
        Map<Rank, Integer> rankCountMap = GameResultJudge.judge(winLotto, lotto_list);
        OutputView.printResultLottoPrize(rankCountMap);

        //7) 수익률 계산 기능
        double out = GameReturnRateCalculator.getReturnRate(rankCountMap, price);
        OutputView.printPrizePercentResult(out);

    }


}