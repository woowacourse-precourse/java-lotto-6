package lotto.controller;

import lotto.model.*;

import java.util.List;

public class LottoGameController {
    private final PaymentController paymentController = new PaymentController();
    private final LottoPurchaseController lottoPurchaseController = new LottoPurchaseController();
    private final WinningsInitController winningsInitController = new WinningsInitController();
    private final HitNumberCalculator hitNumberCalculator = new HitNumberCalculator();
    private final RankStatistics rankStatistics = new RankStatistics();

    public void run() {
        int userPayment = paymentController.getUserPayment();
        List<Lotto> purchasedLotto = lottoPurchaseController.purchase(userPayment);
        Lotto winningLotto = winningsInitController.initWinningLotto();
        int bonusNumber = winningsInitController.initBonusNumber(winningLotto);
        List<Rank> ranks = purchasedLotto.stream()
                .map(e -> calculateRank(e, winningLotto, bonusNumber))
                .toList();
        calculateStatistics(ranks);
        double profitRate = calculateProfitRate(userPayment, rankStatistics.getTotalPrize());
    }



    private Rank calculateRank(Lotto purchasedLotto, Lotto winningLotto, int bonusNumber) {
        List<Integer> purchasedLottoNumbers = purchasedLotto.getNumbers();
        List<Integer> winningLottoNumbers = winningLotto.getNumbers();
        int hitCount = hitNumberCalculator.hitNumberCounter(
                purchasedLottoNumbers, winningLottoNumbers);
        boolean isBonusIncluded = hitNumberCalculator.isBonusNumberIncluded(
                purchasedLottoNumbers, bonusNumber);
        return Rank.getRank(hitCount, isBonusIncluded);
    }

    private void calculateStatistics(List<Rank> ranks) {
        ranks.forEach(rankStatistics::add);
    }

    private double calculateProfitRate(int userPayment, int totalPrize) {
        return totalPrize / (double) userPayment;
    }

    private void printStatistics(){

    }
}