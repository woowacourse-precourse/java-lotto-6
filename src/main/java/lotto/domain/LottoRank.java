package lotto.domain;

import lotto.constant.WinningPrize;
import lotto.dto.AllLotteriesNumbersInfoDTO;

import java.util.*;

public class LottoRank {
    private final List<Integer> rank;

    public LottoRank(AllLotteriesNumbersInfoDTO allLotteriesNumbers) {
        this.rank = calculateLottoResult(allLotteriesNumbers);
    }

    public List<Integer> getRank() {
        return rank;
    }

    public double calculateProfitPercentage(PurchasePrice purchasePrice) {
        int profitSum = 0;
        int rankIndex = 0;
        for (WinningPrize prize : WinningPrize.values()) {
            profitSum += prize.getAmount() * rank.get(rankIndex++);
        }

        return (double) profitSum / purchasePrice.getPurchasePrice() * 100;
    }

    private List<Integer> calculateLottoResult(AllLotteriesNumbersInfoDTO allLotteriesNumbers) {
        List<Integer> lotto = allLotteriesNumbers.getLotto().getNumbers();
        int bonusLotto = allLotteriesNumbers.getBonusLotto().getBonusLotto();
        List<Lotto> generateLotteries = allLotteriesNumbers.getGenerateLotteries().getLotteries();

        List<Integer> rankCount = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            rankCount.add(0);
        }

        int index = 0;
        int winCount = 0;
        int bonusCount = 0;
        for (Lotto generateLotto : generateLotteries) {
            List<Integer> answerLotto = generateLotto.getNumbers();
            Set<Integer> uniqueNumbers = new HashSet<>(answerLotto);
            uniqueNumbers.addAll(lotto);

            winCount = 12 - uniqueNumbers.size();
            if (answerLotto.contains(bonusLotto)) {
                bonusCount = 1;
            }

            if (winCount >= 3) {
                index = calculateRankIndex(winCount, bonusCount);
                rankCount.set(index, rankCount.get(index) + 1);
            }
        }

        return rankCount;
    }

    private int calculateRankIndex(int winCount, int bonusCount) {
        if (winCount == 6)  // 1등(6개) index = 0
            return 0;
        if (winCount == 5 && bonusCount == 1)
            return 1;
        if (winCount == 5)
            return 2;
        if (winCount == 4)
            return 3;
        if (winCount == 3)
            return 4;
        return -1;  // 순위에 없음
    }
}
