package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.function.Predicate;

public class WinningStatistics {
    private static final int ZERO = 0;
    private static final int ONE = 1;
    private static final int HUNDRED = 100;
    private static final double ONE_POINT_ZERO = 1.0;

    private final HashMap<PrizeType, Integer> lottoRecords;
    private double totalReward;

    public WinningStatistics() {
        this.lottoRecords = new HashMap<>() {{
            put(PrizeType.FIRST, 0);
            put(PrizeType.SECOND, 0);
            put(PrizeType.THIRD, 0);
            put(PrizeType.FOURTH, 0);
            put(PrizeType.FIFTH, 0);
            put(PrizeType.NONE, 0);
        }};
        this.totalReward = 0;
    }

    public void calculateNumberOfWins(List<Lotto> lottos, Lotto winningNumbers, int bonusNumber) {
        for (Lotto lotto : lottos) {
            recordWinning(getMatchNumbers(lotto, winningNumbers), isMatchBonusNumber(lotto, bonusNumber));
        }
    }

    private int getMatchNumbers(Lotto lotto, Lotto winningNumbers) {
        return (int) lotto.getNumbers().stream()
                .filter(number -> winningNumbers.getNumbers().stream().anyMatch(Predicate.isEqual(number))).count();
    }

    private boolean isMatchBonusNumber(Lotto lotto, int bonusNumber) {
        return lotto.getNumbers().contains(bonusNumber);
    }

    private void recordWinning(int inputLottoNumbers, boolean inputBonusNumber) {
        PrizeType prizeType = PrizeType.getPrizeType(inputLottoNumbers, inputBonusNumber);
        lottoRecords.put(prizeType, lottoRecords.getOrDefault(prizeType, ZERO) + ONE);
        totalReward += prizeType.getMoney();
    }

    public HashMap<PrizeType, Integer> getLottoRecords() {
        return lottoRecords;
    }

    public double getTotalReward() {
        return totalReward;
    }

    public String calculateRewardRate(long amount) {
        totalReward *= ONE_POINT_ZERO;
        return roundDecimalPlaces((totalReward / amount) * HUNDRED);
    }

    private String roundDecimalPlaces(double rate) {
        return String.format("%.1f", rate);
    }
}
