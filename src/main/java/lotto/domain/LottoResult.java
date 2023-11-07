package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoResult {

    private final static int BONUS_CONDITION = 5;
    private List<Rank> ranks;

    public LottoResult() {
        this.ranks = new ArrayList<>();
    }

    public static Rank calculateResult(Lotto lotto, WinningNumber winningNumber) {
        int count = getCount(lotto, winningNumber.getLotto().getNumbers());
        boolean bonus = false;

        if (count == BONUS_CONDITION) {
            bonus = lotto.hasMatchedNumber(winningNumber.getBonusNumber());
        }
        return getRank(count, bonus);
    }

    private static int getCount(Lotto lotto, List<Integer> numbers) {
        int count = 0;
        for (Integer number : lotto.getNumbers()) {
            if (numbers.contains(number)) {
                count++;
            }
        }
        return count;
    }

    private static Rank getRank(int matchCount, boolean bonus) {
        for (Rank rank : Rank.values()) {
            if (rank.getCount() == matchCount && rank.isBonus() == bonus) {
                return rank;
            }
        }
        return Rank.NOTHING;
    }

    public List<Rank> getRanks(List<Lotto> lottoList, WinningNumber winningNumber) {
        for (Lotto lotto : lottoList) {
            Rank rank = calculateResult(lotto, winningNumber);
            this.ranks.add(rank);
        }

        return this.ranks;
    }

    public static List<Rank> getRankValues() {
        List<Rank> rankValues = new ArrayList<>();
        for (Rank rank : Rank.values()) {
            if (rank != Rank.NOTHING) {
                rankValues.add(rank);
            }
        }
        return rankValues;
    }

    public static long rankCount(Rank rank, List<Rank> results) {
        long count = 0;
        for (Rank resultRank : results) {
            if (rank.getCount() == resultRank.getCount() && rank.isBonus() == resultRank.isBonus()) {
                count++;
            }
        }
        return count;
    }

    public static double totalEarningRate(List<Rank> results) {
        long earnings = 0;
        for (Rank rank : results) {
            earnings += rank.getPrize();
        }
        return earnings;
    }
}
