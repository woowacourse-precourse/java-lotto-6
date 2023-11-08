package lotto.domain;

import java.util.HashMap;
import java.util.List;

public class WinningStatistics {

    private HashMap<Integer, Integer> winningStatistics;
    private HashMap<Integer, Integer> bonusStatistics;

    public WinningStatistics() {
        initWinningStatistics();
        initBonusStatistics();
    }

    private void initWinningStatistics() {
        this.winningStatistics = new HashMap<>();
        winningStatistics.put(3, LottoConstants.ZERO.getValue());
        winningStatistics.put(4, LottoConstants.ZERO.getValue());
        winningStatistics.put(6, LottoConstants.ZERO.getValue());
    }

    private void initBonusStatistics() {
        this.bonusStatistics = new HashMap<>();
        bonusStatistics.put(0, LottoConstants.ZERO.getValue());
        bonusStatistics.put(1, LottoConstants.ZERO.getValue());
    }

    public void calculateWinning(IssuedLotto issuedLotto, WinningLotto winningLotto) {
        for (Lotto lotto : issuedLotto.getLottos()) {
            countPrize(lotto.getNumbers(), winningLotto.getWinninglotto().getNumbers(), winningLotto.getBonusNumber());
        }
    }

    private void countPrize(List<Integer> numbers, List<Integer> winningNumbers, int bonusNumber) {
        int countEqual = LottoConstants.ZERO.getValue();
        for (int number : numbers) {
            countEqual = getCountEqual(winningNumbers, number, countEqual);
        }
        updateStatistics(numbers, bonusNumber, countEqual);
    }

    private void updateStatistics(List<Integer> numbers, int bonusNumber, int countEqual) {
        if (countEqual < 3) {
            return;
        }
        if (countEqual == 5) {
            updateWinningStatisticsIfCountEqualIs5(numbers, bonusNumber);
            return;
        }
        updateWinningStatistics(countEqual);
    }

    private void updateWinningStatisticsIfCountEqualIs5(List<Integer> numbers, int bonusNumber) {
        int bonusEqual = LottoConstants.ZERO.getValue();
        for (int number : numbers) {
            if (number == bonusNumber) {
                bonusEqual++;
                break;
            }
        }
        int count = bonusStatistics.get(bonusEqual) + 1;
        bonusStatistics.replace(bonusEqual, count);
    }

    private void updateWinningStatistics(int countEqual) {
        int count = winningStatistics.get(countEqual) + 1;
        winningStatistics.replace(countEqual, count);
    }

    private static int getCountEqual(List<Integer> winningNumbers, int number, int countEqual) {
        if (winningNumbers.contains(number)) {
            countEqual++;
        }
        return countEqual;
    }

    public HashMap<Integer, Integer> getWinningStatistics() {
        return winningStatistics;
    }

    public HashMap<Integer, Integer> getBonusStatistics() {
        return bonusStatistics;
    }
}
