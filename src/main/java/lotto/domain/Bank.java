package lotto.domain;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import lotto.domain.enums.Prize;

public class Bank {
    private int extraWinningNumber;
    private List<Integer> winningNumbers;
    private Map<Prize, Integer> prizeCountMap;

    public Bank() {
        this.extraWinningNumber = 0;
        this.winningNumbers = new ArrayList<>();
        this.prizeCountMap = new LinkedHashMap<>();
    }

    public void setExtraWinningNumber(int extraWinningNumber) {
        this.extraWinningNumber = extraWinningNumber;
    }

    public void setWinningNumbers(List<Integer> winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public int countCorrect(Lotto lotto) {
        return (int) lotto.getNumbers().stream()
                .filter(number -> winningNumbers.contains(number))
                .count();
    }

    public boolean isMatchBonus(Lotto lotto) {
        return lotto.getNumbers().contains(extraWinningNumber);
    }

    public Map<Prize, Integer> calculatePrizeCountMap(Player player) {
        for (Lotto lotto : player.getLottos().getLottos()) {
            int correctCount = countCorrect(lotto);
            boolean matchBonus = isMatchBonus(lotto);
            Prize prize = Prize.valueOf(correctCount, matchBonus);
            prizeCountMap.put(prize, prizeCountMap.getOrDefault(prize, 0) + 1);
        }
        return prizeCountMap;
    }

    public int calculateTotalPrizeMoney(Map<Prize, Integer> prizeCountMap) {
        int totalPrizeMoney = 0;
        for (Map.Entry<Prize, Integer> entry : prizeCountMap.entrySet()) {
            totalPrizeMoney += entry.getKey().getPrizeMoney() * entry.getValue();
        }
        return totalPrizeMoney;
    }

    public double calculateEarningRate(int totalPrizeMoney, Player player) {
        return ((double) totalPrizeMoney / (player.getMoney())) * 100;
    }
}
