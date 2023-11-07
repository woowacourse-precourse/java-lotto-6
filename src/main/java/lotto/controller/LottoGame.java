package lotto.controller;

import lotto.model.Lotto;
import lotto.model.Rank;
import lotto.view.LottoUI;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class LottoGame {

    private final static int LOTTO_PRICE = 1000;
    private final int purchaseAmount;

    public LottoGame(int purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }

    public void play() {
        int lottoCnt = purchaseAmount / LOTTO_PRICE;
        List<Lotto> lottos = getRandomLottos(lottoCnt);
        LottoUI.printRandomLottos(lottos, lottoCnt);
        Lotto winningLotto = LottoUI.getWinningLotto();
        int bonusNum = LottoUI.getBonusNumber(winningLotto);
        List<Rank> ranks = checkRanks(lottos, winningLotto, bonusNum);
        double earningRate = calculateEarningRate(purchaseAmount, ranks);
        LottoUI.printWinningStatistics(ranks, earningRate);
    }

    public List<Lotto> getRandomLottos(int lottoCnt) {
        List<Lotto> lottos = new ArrayList<>();
        for(int i=0;i<lottoCnt;i++){
            lottos.add(Lotto.generateRandomLotto());
        }
        return lottos;
    }

    public List<Rank> checkRanks(List<Lotto> userLottos, Lotto winningLotto, int bonusNumber) {
        List<Rank> ranks = new ArrayList<>();
        for(Lotto userLotto : userLottos){
            int matchCount = getMatchCount(userLotto.getNumbers(), winningLotto.getNumbers());
            boolean matchBonus = winningLotto.getNumbers().contains(bonusNumber);
            ranks.add(Rank.valueOf(matchCount, matchBonus));
        }
        return ranks;
    }

    private int getMatchCount(List<Integer> userNumbers, List<Integer> winningNumbers) {
        return (int) userNumbers.stream().filter(winningNumbers::contains).count();
    }

    public double calculateEarningRate(int purchaseAmount, List<Rank> ranks) {
        int totalEarnings = ranks.stream()
                .mapToInt(Rank::getPrize)
                .sum();

        double profitRate = (double) totalEarnings / purchaseAmount * 100;

        return Math.round(profitRate * 10) / 10.0;
    }
}
