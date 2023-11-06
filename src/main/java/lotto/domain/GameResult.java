package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class GameResult {
    private List<Ranking> rankings = new ArrayList<>();

    public void setRankingNumbers(Lotto winningLotto, Lotto lotto, boolean hasBonusNumber) {
        int winCount = lotto.getWins(winningLotto);
        Ranking currentRanking = Ranking.NO_WINS;

        currentRanking = currentRanking.setRanking(winCount, hasBonusNumber);
        rankings.add(currentRanking);
    }

    public boolean hasBonusNumber(Lotto lotto, BonusNumber bonusNumber) {
        for (int i = 0; i < 6; i++) {
            if (lotto.getNumbers().get(i) == bonusNumber.getBonusNumber()) {
                return true;
            }
        }
        return false;
    }

    public int getRankCounts(Ranking ranking) {
        int rankCount = 0;

        for (int i = 0; i < rankings.size(); i++) {
            if (rankings.get(i) == ranking) {
                rankCount++;
            }
        }

        return rankCount;
    }

    public List<Ranking> getRankings() {
        return rankings;
    }
}
