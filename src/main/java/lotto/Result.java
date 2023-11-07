package lotto;

import java.util.ArrayList;
import java.util.List;

public class Result {
    public List<Integer> calculateResult(List<Lotto> lottos, Lotto winningLotto, Integer bonusNumber) {
        List<Integer> result = new ArrayList<>(List.of(0, 0, 0, 0, 0));
        List<Integer> winningNumber = winningLotto.getLotto();

        for (Lotto lotto : lottos) {
            int matchingNumberCount = lotto.countMatchingNumbers(winningNumber);
            boolean isBonusMatch = lotto.hasBonusNumber(bonusNumber);

            if (matchingNumberCount == 6) {
                result.set(4, result.get(4) + 1);
                continue;
            }

            if (matchingNumberCount == 5 && isBonusMatch) {
                result.set(3, result.get(3) + 1);
                continue;
            }

            if (matchingNumberCount == 5) {
                result.set(2, result.get(2) + 1);
                continue;
            }

            if (matchingNumberCount == 4) {
                result.set(1, result.get(1) + 1);
                continue;
            }

            if (matchingNumberCount == 3) {
                result.set(0, result.get(0) + 1);
            }
        }

        return result;
    }

    public double calculateRateOfReturn(List<Integer> result, int purchase) {
        long prizeAmount = 0;
        double rateOfReturn;

        prizeAmount = prizeAmount + (Prize.FIFTH_PRIZE.getPrizeAmount() * result.get(0));
        prizeAmount = prizeAmount + (Prize.FOURTH_PRIZE.getPrizeAmount() * result.get(1));
        prizeAmount = prizeAmount + (Prize.THIRD_PRIZE.getPrizeAmount() * result.get(2));
        prizeAmount = prizeAmount + (Prize.SECOND_PRIZE.getPrizeAmount() * result.get(3));
        prizeAmount = prizeAmount + (Prize.FIRST_PRIZE.getPrizeAmount() * result.get(4));

        rateOfReturn = ((double) prizeAmount / purchase) * 100;

        return rateOfReturn;
    }
}
