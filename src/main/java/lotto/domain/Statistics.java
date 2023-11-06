package lotto.domain;

import java.util.List;
import java.util.stream.IntStream;

import static lotto.domain.Rank.*;

public class Statistics {
    public static Statistics statistics;
    public static int firstCount, secondCount, thirdCount, fourthCount, fifthCount;

    private Statistics() {
    }

    public static Statistics getInstance() {
        if (statistics == null) {
            return statistics = new Statistics();
        }
        return statistics;
    }

    public void getResult(List<RandomNumber> multiRandomNumbers, Lotto lotto, int bonusNumber) {
        for (RandomNumber rn : multiRandomNumbers) {
            int sameWinningNum = 0;
            sameWinningNum = (int) IntStream.range(0, lotto.getNumbers().size())
                    .filter(i -> rn.getRandomNumbers().contains(lotto.getNumbers().get(i))).count();

            boolean sameBonusNum = rn.getRandomNumbers().contains(bonusNumber);
            getTotalRank(sameWinningNum, sameBonusNum);
        }
    }

    private void getTotalRank(int sameWinningNum, boolean sameBonusNum) {
        if (sameWinningNum == 6) {
            firstCount += 1;
            return;
        }
        if (sameWinningNum == 5 && sameBonusNum) {
            secondCount += 1;
            return;
        }
        if (sameWinningNum == 5) {
            thirdCount += 1;
            return;
        }
        if (sameWinningNum == 4) {
            fourthCount += 1;
            return;
        }
        if (sameWinningNum == 3) {
            fifthCount += 1;
        }
    }

    public float getRateOfReturn(int totalReward, int purchaseAmount) {
        float rateOfReturn = ((float) totalReward / purchaseAmount) * 100;
        return (float) Math.round(rateOfReturn * 10) / 10;
    }

    public int getTotalReward() {
        return (firstCount * FIRST.getWinnings()) + (secondCount * SECOND.getWinnings()) +
                (thirdCount * THIRD.getWinnings()) + (fourthCount * FOURTH.getWinnings()) +
                (fifthCount * FIFTH.getWinnings());
    }
}
