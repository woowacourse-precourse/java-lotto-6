package lotto.domain;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class WinningCheck {

    private Map<String, Integer> rankingCount = new LinkedHashMap<>();

    private void initRankingCount() {
        for (WinningTable winningTable : WinningTable.values()) {
            rankingCount.put(winningTable.name(), 0);
        }
    }

    public Map<String, Integer> checkCount(List<List<Integer>> boughtLotto, List<Integer> numbers, int bonusNumber) {
        initRankingCount();
        for (List<Integer> lottoNumbers : boughtLotto) {
            int count = 0;
            boolean bonus = false;
            count = checkWinningNumberCount(lottoNumbers, numbers);
            bonus = checkBonusNumber(lottoNumbers, bonusNumber);
            plusRankingCount(count, bonus);
        }
        return rankingCount;
    }

    private void plusRankingCount(int count, boolean bonus) {
        for (WinningTable winningTable : WinningTable.values()) {
            if (winningTable.getCorrectNumberCount() == count && winningTable.getIsBonus() == bonus) {
                rankingCount.put(winningTable.name(), rankingCount.get(winningTable.name()) + 1);
            }

            if (winningTable.getCorrectNumberCount() == 0 && count == 1) {
                rankingCount.put(winningTable.name(), rankingCount.get(winningTable.name()) + 1);
            }

            if (winningTable.getCorrectNumberCount() == 0 && count == 2) {
                rankingCount.put(winningTable.name(), rankingCount.get(winningTable.name()) + 1);
            }

            if (winningTable.getCorrectNumberCount() == 0 && count == 0 && bonus) {
                rankingCount.put(winningTable.name(), rankingCount.get(winningTable.name()) + 1);
            }
        }
    }

    private int checkWinningNumberCount(List<Integer> lottoNumbers, List<Integer> numbers) {
        int count = 0;
        for (int number : numbers) {
            if (lottoNumbers.contains(number)) {
                count++;
            }
        }
        return count;
    }

    private boolean checkBonusNumber(List<Integer> lottoNumbers, int bonusNumber) {
        if (lottoNumbers.contains(bonusNumber)) {
            return true;
        }
        return false;
    }
}