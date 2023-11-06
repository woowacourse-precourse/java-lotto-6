package lotto.service;

import static lotto.settings.LottoSettings.PER_lOTTO_PRICE;

import lotto.repository.BuyLottoRepository;
import lotto.repository.WinningLottoRepository;
import lotto.view.View;

public class ResultService {
    private final LotteryTracker lotteryTracker = LotteryTracker.create();

    public void checkLottoNumbers(BuyLottoRepository buyLottos, WinningLottoRepository winningLotto){
        View.winningStatistics();

        // 로또추적기: 산 로또의 번호가 당첨 번호와 몇개 맞는 지 판단하고 등수 당 몇개인지 확인
        lotteryTracker.matching(buyLottos,winningLotto);
        lotteryTracker.printResultByRank();
    }

    public void calculateRateOfReturn(int purchaseCount){
        double totalBuyLottos = purchaseCount * (PER_lOTTO_PRICE.getNumber());
        double totalRevenue = lotteryTracker.calculateTotalRevenue();

        double rateOfReturn = (totalRevenue/totalBuyLottos) * 100;
        View.rateOfReturn(rateOfReturn);
    }
}
