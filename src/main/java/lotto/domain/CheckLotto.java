package lotto.domain;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class CheckLotto {

    private Map<String, Integer> ranking = new LinkedHashMap<>();

    private void initRanking() {
        for (WinningResult winningResult: WinningResult.values()) {
            ranking.put(winningResult.name(), 0);
        }
    }

    public Map<String, Integer> checkNumber(List<List<Integer>> lottos, List<Integer> numbers, int number) {
        initRanking();
        for (List<Integer> lotto: lottos) {
            int count = 0;
            boolean bonus = false;
            count = checkWinningNumber(lotto, numbers);
            bonus = checkBonusNumber(lotto, number);
            plusRanking(count, bonus);
        }
        return ranking;
    }

    private void plusRanking(int count, boolean bonus) {
        for (WinningResult winningResult: WinningResult.values()) {
            if (winningResult.getCorrectNumberCount() == count && winningResult.isBonus() == bonus) {
                ranking.put(winningResult.name(), ranking.get(winningResult.name()) + 1);
            }
            if (winningResult.getCorrectNumberCount() == 0 && count == 1) {
                ranking.put(winningResult.name(), ranking.get(winningResult.name()) + 1);
            }

            if (winningResult.getCorrectNumberCount() == 0 && count == 2) {
                ranking.put(winningResult.name(), ranking.get(winningResult.name()) + 1);
            }

            if (winningResult.getCorrectNumberCount() == 0 && count == 0 && bonus) {
                ranking.put(winningResult.name(), ranking.get(winningResult.name()) + 1);
            }
        }
    }

    private int checkWinningNumber(List<Integer> lotto, List<Integer> numbers) {
        int count = 0;
        for (int num: numbers) {
            if (lotto.contains(num)) {
                count++;
            }
        }
        return count;
    }

    private boolean checkBonusNumber(List<Integer> lotto, int number) {
        if (lotto.contains(number)) {
            return true;
        }
        return false;
    }
}
