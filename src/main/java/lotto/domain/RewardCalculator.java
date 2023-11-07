package lotto.domain;

import lotto.Lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.util.Collections.binarySearch;

public class RewardCalculator {
    private List<Lotto> lottos;
    private List<Integer> winningLotto;
    private int bonusNumber;
    private List<Integer> winCount;
    private int reward;
    private double profit;

    public RewardCalculator(List<Lotto> lottos) {
        this.lottos = lottos;
        this.winningLotto = WinningLotto.lotto.getNumbers();
        this.bonusNumber = WinningLotto.bonus;
        this.winCount  = new ArrayList<>(List.of(0, 0, 0, 0, 0, 0));
        this.reward = 0;
    }

    public void getResults() {
        calculateWinCount();
        calculateReward();
        calculateProfit();
    }

    public List<Integer> getWinCount() {
        return this.winCount;
    }

    private void calculateWinCount() {
        for (Lotto lotto : lottos) {
            List<Integer> lottoNumbers = lotto.getNumbers();
            int matches = countNumOfMatches(lottoNumbers, winningLotto);
            boolean isBonusMatch = lottoNumbers.contains(bonusNumber);

            Optional<Rewards> rewards = Rewards.getRewardByValues(matches, isBonusMatch);
            int i = 0;
            if (rewards.isPresent()){
                i = rewards.get().ordinal();
            }
            winCount.set(i, winCount.get(i) + 1);
        }
    }

    public int countNumOfMatches(List<Integer> lotto, List<Integer> winning) {
        int count = 0;
        for(int i : lotto) {
            if (binarySearch(winning, i) >= 0) {
                count++;
            }
        }

        return count;
    }

    private void calculateReward() {

    }

    private void calculateProfit() {
    }
}
