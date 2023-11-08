package lotto.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.util.stream.IntStream;

public class Player {
    private final List<Lotto> lottos;
    private final Map<Rank, Integer> winningDetails = new LinkedHashMap<>();

    {
        Arrays.stream(Rank.values())
                .sorted(Comparator.reverseOrder())
                .forEach(rank -> winningDetails.put(rank, 0));
    }

    public Player(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    private long calculatePrizeMoney() {
        return winningDetails.entrySet().stream()
                .mapToLong(entry -> entry.getKey().getWinningAmount() * entry.getValue())
                .sum();
    }

    public double calculateRateOfReturn(int inputAmount) {
        BigDecimal purchaseAmount = new BigDecimal(inputAmount);
        BigDecimal totalPrizeMoney = new BigDecimal(calculatePrizeMoney());
        BigDecimal percentage = new BigDecimal("0.01");

        return totalPrizeMoney.divide(
                purchaseAmount.multiply(percentage), 1, RoundingMode.HALF_UP)
                .doubleValue();
    }

    public void checkWinning(Lotto winningNumber, int bonusNumber) {
        int correctCount;
        boolean isBonus;
        Rank rank;

        for (int i = 0; i < lottos.size(); i++) {
            List<Integer> lotto = lottos.get(i).getNumbers();

            correctCount = checkCorrectCount(lotto, winningNumber.getNumbers());
            isBonus = checkCorrectBonus(lotto, bonusNumber);

            rank = Rank.findByRank(correctCount, isBonus);
            winningDetails.put(rank, winningDetails.get(rank) + 1);
        }
    }

    private boolean checkCorrectBonus(List<Integer> lotto, int bonusNumber) {
        return lotto.contains(bonusNumber);
    }

    private int checkCorrectCount(List<Integer> lotto, List<Integer> winningNumber) {
        return (int) IntStream.range(0, winningNumber.size())
                .filter(index -> lotto.contains(winningNumber.get(index)))
                .count();
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public Map<Rank, Integer> getWinningDetails() {
        return winningDetails;
    }
}
