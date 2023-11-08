package lotto.domain;

import lotto.constant.MagicNumber;
import lotto.constant.WinningPrize;
import lotto.dto.AllLotteriesNumbersInfoDTO;

import java.util.*;

public class LottoRank {
    private final List<Integer> rank;

    public LottoRank(AllLotteriesNumbersInfoDTO allLotteriesNumbers) {
        List<Lotto> generateLotteries = allLotteriesNumbers.getGenerateLotteries().getLotteries();
        List<Integer> lotto = allLotteriesNumbers.getLotto().getNumbers();
        int bonusLotto = allLotteriesNumbers.getBonusLotto().getBonusLotto();

        this.rank = calculateLottoResult(generateLotteries, lotto, bonusLotto);
    }

    public List<Integer> getRank() {
        return rank;
    }

    public double calculateProfitPercentage(PurchasePrice purchasePrice) {
        long profitSum = 0;
        int rankIndex = 0;
        for (WinningPrize prize : WinningPrize.values()) {
            profitSum += (long) prize.getAmount() * rank.get(rankIndex);
            rankIndex++;
        }

        return (double) profitSum / purchasePrice.getPurchasePrice() * 100;
    }

    private List<Integer> calculateLottoResult(List<Lotto> generateLotteries, List<Integer> lotto, int bonusLotto) {
        List<Integer> rankCount = rankCountSetUp();

        for (Lotto generateLotto : generateLotteries) {
            int winCount = countDuplicates(lotto, generateLotto.getNumbers());
            boolean isBonusMatching = isBonusDuplicate(bonusLotto, generateLotto.getNumbers());

            int index = calculateRankIndex(winCount, isBonusMatching);
            if (index >= 0) {
                rankCount.set(index, rankCount.get(index) + 1);
            }
        }

        return rankCount;
    }

    private List<Integer> rankCountSetUp() {
        List<Integer> rankCount = new ArrayList<>();
        for (int i = 0; i < MagicNumber.RANK_COUNT.getNumber(); i++) {
            rankCount.add(0);
        }

        return rankCount;
    }

    private int countDuplicates(List<Integer> lotto, List<Integer> generateLotto) {
        Set<Integer> uniqueNumbers = new HashSet<>(lotto);
        uniqueNumbers.addAll(generateLotto);
        return MagicNumber.LOTTO_COUNT.getNumber() * 2 - uniqueNumbers.size();
    }

    private boolean isBonusDuplicate(int bonus, List<Integer> generateLotto) {
        if (generateLotto.contains(bonus)) {
            return true;
        }
        return false;
    }

    private int calculateRankIndex(int winCount, boolean isBonusMatching) {
        if (winCount == 6)  // 1등(6개) index = 0
            return 0;
        if (winCount == 5 && isBonusMatching == true)
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
