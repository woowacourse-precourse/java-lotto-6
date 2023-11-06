package lotto.service;

import static lotto.settings.LottoSettings.PER_lOTTO_PRICE;

import lotto.repository.BuyLottoRepository;
import lotto.repository.WinningLottoRepository;
import lotto.view.View;

public class ResultService {
    private final LotteryTracker lotteryTracker = LotteryTracker.create();
    //등수별 로또가 몇개인지 저장
    public void perLottoTotalCount(BuyLottoRepository buyLottos, WinningLottoRepository winningLotto){
        View.winningStatistics();

        // 로또추적기: 산 로또의 번호가 당첨 번호와 몇개 맞는 지 판단하고 그에 따른 등수 매김
        lotteryTracker.matching(buyLottos,winningLotto);
        lotteryTracker.printResult();
    }

    //총 수익률을 계산
    public void calculateRateOfReturn(int purchaseCount){
        double totalBuyLottos = purchaseCount * (PER_lOTTO_PRICE.getNumber());
        double totalRevenue = lotteryTracker.calculateTotalRevenue();

        double rateOfReturn = (totalRevenue/totalBuyLottos) * 100;
        View.rateOfReturn(rateOfReturn);
    }
}
