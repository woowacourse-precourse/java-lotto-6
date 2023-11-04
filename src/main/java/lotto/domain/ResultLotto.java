package lotto.domain;

import java.util.HashMap;

public class ResultLotto {
    private HashMap<RankingLotto, Integer> score;
    double reward;

    public ResultLotto(HashMap<RankingLotto, Integer> score) {
        this.score = score;
        this.reward = 0;
    }

    public HashMap<RankingLotto, Integer> getScore() {
        return score;
    }

    public void matchTotalLotto(AmountLotto amountLotto, MyLottos myLottos, WinningLotto winningLotto) {
        for (int i = 0; i < amountLotto.calculateAmountLotto(); i++) {
            RankingLotto rankingLotto = winningLotto.matchLotto(myLottos.getLottos().get(i));
            String reward = rankingLotto.getReward().replace(",", "");
            this.reward += Integer.parseInt(reward);
            this.score.put(rankingLotto, this.score.get(rankingLotto) + 1);
        }
    }

    public double totalReward(AmountLotto amountLotto) {
        return ((double) this.reward / (double) amountLotto.getAmount() * 100);
    }
}
