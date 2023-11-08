package lotto.domain;

import java.util.List;

public class Result {
    private final List<Lotto> lottoList;
    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    public static final int PRIZE_THREE_MATCH = 5000;
    public static final int PRIZE_FOUR_MATCH = 50000;
    public static final int PRIZE_FIVE_MATCH = 1500000;
    public static final int PRIZE_FIVE_MATCH_WITH_BONUS = 30000000;
    public static final int PRIZE_SIX_MATCH = 2000000000;
    public static final int PRICE_PER_TICKET = 1000;

    public Result(List<Lotto> lottoList, List<Integer> winningNumbers, int bonusNumber) {
        this.lottoList = lottoList;
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    private int countMatchingNumbers(Lotto lotto) {
        List<Integer> lottoNumbers = lotto.getNumbers();
        int numberOfMatches = 0;

        for (Integer number : lottoNumbers) {
            if (winningNumbers.contains(number)) {
                numberOfMatches++;
            }
        }

        boolean hasBonusNumber = lottoNumbers.contains(bonusNumber);

        if (numberOfMatches == 5 && hasBonusNumber) {
            return 6; // 5개 일치 + 보너스 번호 맞춤
        }

        return numberOfMatches;
    }


    private int calculateTotalPrize(int numberOfMatches) {
        switch (numberOfMatches) {
            case 3:
                return PRIZE_THREE_MATCH;
            case 4:
                return PRIZE_FOUR_MATCH;
            case 5:
                return PRIZE_FIVE_MATCH;
            case 6:
                return PRIZE_SIX_MATCH;
            default:
                return 0;
        }
    }

    public int getThreeMatchCount() {
        int count = 0;
        for (Lotto lotto : lottoList) {
            if (countMatchingNumbers(lotto) == 3) {
                count++;
            }
        }
        return count;
    }

    public int getFourMatchCount() {
        int count = 0;
        for (Lotto lotto : lottoList) {
            if (countMatchingNumbers(lotto) == 4) {
                count++;
            }
        }
        return count;
    }

    public int getFiveMatchCount() {
        int count = 0;
        for (Lotto lotto : lottoList) {
            if (countMatchingNumbers(lotto) == 5) {
                count++;
            }
        }
        return count;
    }

    public int getFiveMatchWithBonusCount() {
        int count = 0;
        for (Lotto lotto : lottoList) {
            if (countMatchingNumbers(lotto) == 6) {
                count++;
            }
        }
        return count;
    }

    public int getSixMatchCount() {
        int count = 0;
        for (Lotto lotto : lottoList) {
            if (countMatchingNumbers(lotto) == 6) {
                count++;
            }
        }
        return count;
    }

    public double getProfitRate() {
        int totalPrize = 0;
        for (Lotto lotto : lottoList) {
            totalPrize += calculateTotalPrize(countMatchingNumbers(lotto));
        }
        int purchaseAmount = lottoList.size() * PRICE_PER_TICKET;
        return (double) totalPrize / purchaseAmount * 100;
    }
}
