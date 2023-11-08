package lotto.model;

import java.util.HashSet;
import java.util.Set;

public class Judgement {
    public enum Prize {
        SECOND(30000000),
        NO_PRIZE(0),
        FIFTH(5000),
        FOURTH(50000),
        THIRD(1500000),
        FIRST(2000000000);

        private final int prizeAmount;

        Prize(int prizeAmount) {
            this.prizeAmount = prizeAmount;
        }

        public int getPrizeAmount() {
            return prizeAmount;
        }
    }

    private class WinningInformation {
        int numOfMatches;
        boolean bonusMatch;

        public void setWinningInformation(int numOfMatches, boolean bonusMatch) {
            this.numOfMatches = numOfMatches;
            this.bonusMatch = bonusMatch;
        }
    }

    public static WinningInformation countMatchingNumbers(Lotto winnerLotto, Lotto userLotto, int bonusNumber, LottoRankRecorder recorder) {
        Set<Integer> winnerSet = new HashSet<>(winnerLotto.getNumbers());
        Set<Integer> userSet = new HashSet<>(userLotto.getNumbers());

        winnerSet.retainAll(userSet);
        WinningInformation winningInformation = new Judgement().new WinningInformation();
        winningInformation.setWinningInformation(winnerSet.size(), userSet.contains(bonusNumber));
        return winningInformation;
    }

    public static int getPrizeAmount(Lotto winnerLotto, Lotto userLotto, int bonusNumber, LottoRankRecorder recorder) {
        WinningInformation winningInformation = countMatchingNumbers(winnerLotto, userLotto, bonusNumber, recorder);
        if (winningInformation.bonusMatch) {
            recorder.recordRank(getRank(winningInformation.numOfMatches, true));
            return getRank(winningInformation.numOfMatches, true).getPrizeAmount();
        }
        recorder.recordRank(getRank(winningInformation.numOfMatches, false));
        return getRank(winningInformation.numOfMatches).getPrizeAmount();
    }

    public static Prize getRank(int numOfMatches, boolean bonusNumber) {
        if (numOfMatches == 5 && bonusNumber == true)
            return Prize.SECOND;
        else
            return getRank(numOfMatches);
    }

    public static Prize getRank(int numOfMatches) {
        if (numOfMatches < 3)
            return Prize.NO_PRIZE;
        return Prize.values()[numOfMatches - 1];
    }
}
