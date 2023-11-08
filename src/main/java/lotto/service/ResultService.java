package lotto.service;

import static lotto.settings.LottoSettings.ONE_lOTTO_PRICE;

import lotto.repository.BuyLottoRepository;
import lotto.repository.WinningLottoRepository;
import lotto.view.View;

public class ResultService {
    private final LotteryTracker lotteryTracker = LotteryTracker.create();

    public void checkLottoNumbers(BuyLottoRepository buyLottos, WinningLottoRepository winningLottoRepo){
        View.winningStatistics();
        // 로또추적기: 산 로또의 번호가 당첨 번호와 몇개 맞는 지 판단 && 등수안에 들면 해당등수의 인원 증가시킴
        lotteryTracker.matching(buyLottos,winningLottoRepo);
    }

    public void printResultByRank() {
        lotteryTracker.printResultByRank();
    }

    public double calculateRateOfReturn(int purchaseCount){
        double totalBuyLottos = purchaseCount * (ONE_lOTTO_PRICE.getNumber());
        double totalRevenue = lotteryTracker.calculateTotalRevenue();

        return (totalRevenue/totalBuyLottos) * 100;
    }

    public void printRateOfReturn(double rateOfReturn) {
        View.rateOfReturn(rateOfReturn);
    }
}
