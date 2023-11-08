package lotto.controller;

import lotto.model.*;

import java.util.List;

public class LottoGameController {
    private final PaymentController paymentController = new PaymentController();
    private final LottoPurchaseController lottoPurchaseController = new LottoPurchaseController();
    private final WinningsInitController winningsInitController = new WinningsInitController();
    private final LottoShop lottoShop = new LottoShop();
    private final WinningsInitializer winningsInitializer = new WinningsInitializer();
    private final HitNumberCalculator hitNumberCalculator = new HitNumberCalculator();
    private final RankStatistics rankStatistics = new RankStatistics();

    public void run() {
        int userPayment = paymentController.getUserPayment();
        List<Lotto> purchasedLotto = lottoPurchaseController.purchase(userPayment);
        Lotto winningLotto = winningsInitController.initWinningLotto();
        int bonusNumber = winningsInitController.initBonusNumber(winningLotto);
        List<LottoRank> lottoRanks = purchasedLotto.stream()
                .map(e -> calculateRank(e, winningLotto, bonusNumber))
                .toList();
        calculateStatistics(lottoRanks);
        double profitRate = calculateProfitRate(userPayment, rankStatistics.getTotalPrize());
    }



    private LottoRank calculateRank(Lotto purchasedLotto, Lotto winningLotto, int bonusNumber) {
        List<Integer> purchasedLottoNumbers = purchasedLotto.getNumbers();
        List<Integer> winningLottoNumbers = winningLotto.getNumbers();
        int hitCount = hitNumberCalculator.hitNumberCounter(
                purchasedLottoNumbers, winningLottoNumbers);
        boolean isBonusIncluded = hitNumberCalculator.isBonusNumberIncluded(
                purchasedLottoNumbers, bonusNumber);
        return LottoRank.getRank(hitCount, isBonusIncluded);
    }

    private void calculateStatistics(List<LottoRank> ranks) {
        ranks.forEach(rankStatistics::add);
    }

    private double calculateProfitRate(int userPayment, int totalPrize) {
        return totalPrize / (double) userPayment;
    }

    private void printStatistics(){

    }
}