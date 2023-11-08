package lotto.domain;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;
import java.util.Map.Entry;

public class WinningResult {
    private Map<WinningType, Integer> winningResult;

    private WinningResult(final Lottos lottos, final DrawnNumbers drawnNumbers) {
        this.winningResult = new EnumMap<>(WinningType.class);
        initializeWinningResult();
        generateWinningResult(lottos, drawnNumbers);
    }

    public static WinningResult of(final Lottos lottos, final DrawnNumbers drawnNumbers) {
        return new WinningResult(lottos, drawnNumbers);
    }

    private void generateWinningResult(final Lottos lottos, final DrawnNumbers drawnNumbers) {
        for (Lotto lotto : lottos.getLottos()) {
            LottoResultDto lottoResultDto = drawnNumbers.compare(lotto);
            WinningType winningType = WinningType.findWinningType(
                    lottoResultDto.getWinningCount(),
                    lottoResultDto.hasBonusNumber());
            countWinningType(winningType);
        }
    }

    private void countWinningType(final WinningType winningType) {
        winningResult.put(winningType, winningResult.get(winningType) + 1);
    }

    private void initializeWinningResult() {
        Arrays.stream(WinningType.values())
                .forEach(winning -> winningResult.put(winning, 0));
    }

    public Integer getValue(final WinningType winningType) {
        return winningResult.get(winningType);
    }

    public double calculateEarningsRate(final int cost) {
        return getEarnings() / cost;
    }

    private double getEarnings() {
        int earnings = (int) winningResult.entrySet()
                .stream()
                .mapToDouble(entry -> calculateWinningPrice(entry))
                .sum();
        return earnings;
    }

    private int calculateWinningPrice(final Entry<WinningType, Integer> entry) {
        return entry.getKey().getPrice() * entry.getValue();
    }
}
