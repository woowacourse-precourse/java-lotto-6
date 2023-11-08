package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Calculation {

    private static int bonusMatchCount;
    private int[] matchCounts;


    public Calculation(int bonusMatchCount, int[] matchCounts) {
        this.bonusMatchCount = bonusMatchCount;
        this.matchCounts = matchCounts;
    }

    static Calculation winningStatistics(List<List<Integer>> saveLottoNumbers, List<Integer> numbers, int bonusNumber) {
        int[] matchCounts = new int[7];
        int bonusMatchCount = 0;

        for (List<Integer> nums : saveLottoNumbers) {
            int matchCount = addMatchCount(nums, numbers, bonusNumber);
            matchCounts[matchCount]++;
            if (matchCount == 5 && nums.contains(bonusNumber)) {
                bonusMatchCount++;
                matchCounts[5]--;
            }
        }

        return new Calculation(bonusMatchCount, matchCounts);
    }

    private static int addMatchCount(List<Integer> nums, List<Integer> numbers, int bonusNumber) {
        int matchCount = 0;
        for (int num : nums) {
            if (numbers.contains(num)) {
                matchCount++;
            }
        }
        return matchCount;
    }

    public int getBonusMatchCount() {
        return bonusMatchCount;
    }

    public int[] getMatchCounts() {
        return matchCounts;
    }

    public static int winningAmount(int[] matchCounts) {

        // 수익 계산
        int winningAmount = 0;
        for (Rank.Prize prize : Rank.Prize.values()) {

            if (prize.getMatchCount() == 5 && prize.hasBonus()) {
                winningAmount += bonusMatchCount * prize.getPrizeAmount();
            }
            winningAmount += matchCounts[prize.getMatchCount()] * prize.getPrizeAmount();

        }

        return winningAmount;
    }


}
