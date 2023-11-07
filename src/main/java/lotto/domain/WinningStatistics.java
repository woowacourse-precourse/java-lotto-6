package lotto.domain;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class WinningStatistics {
    private final Map<WinningRecord, Integer> winningStatistics;
    private double totalPrize;

    public WinningStatistics() {
        this.winningStatistics = new EnumMap<>(WinningRecord.class) {{
            put(WinningRecord.FIRST_PLACE, 0);
            put(WinningRecord.SECOND_PLACE, 0);
            put(WinningRecord.THIRD_PLACE, 0);
            put(WinningRecord.FOURTH_PLACE, 0);
            put(WinningRecord.FIFTH_PLACE, 0);
            put(WinningRecord.NONE, 0);
        }};
        this.totalPrize = 0;
    }

    public Map<WinningRecord, Integer> getWinningStatistics() {
        return this.winningStatistics;
    }

    public double getTotalPrize() {
        return totalPrize;
    }

    public String getWinningRate(int amount) {
        double winningRate = (totalPrize / amount) * 100;
        return String.format("%.1f", winningRate);
    }

    public void updateWinningStatistics(List<Lotto> lottos, Lotto winningLotto, int bonusNumber) {
        for (Lotto lotto : lottos) {
            checkOneRandomLotto(getMatchNumber(lotto, winningLotto), isMatchBonus(lotto, bonusNumber));
        }
    }

    private void checkOneRandomLotto(int matchNumbers, boolean matchBonus) {
        WinningRecord placeType = WinningRecord.getPlaceType(matchNumbers, matchBonus);
        winningStatistics.put(placeType, winningStatistics.get(placeType) + 1);
        updateTotalPrize(placeType.getPrize());
    }

    private int getMatchNumber(Lotto lotto, Lotto winningLotto) {
        return (int) lotto.getNumbers().stream()
                .filter(winningLotto.getNumbers()::contains)
                .count();
    }

    private boolean isMatchBonus(Lotto lotto, int bonusNumber) {
        return lotto.getNumbers().contains(bonusNumber);
    }

    private void updateTotalPrize(int prize) {
        this.totalPrize += prize;
    }
}
