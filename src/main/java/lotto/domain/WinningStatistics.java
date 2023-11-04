package lotto.domain;

import java.text.DecimalFormat;
import java.util.EnumMap;
import java.util.Map;
import lotto.constants.WinningCriteria;

public class WinningStatistics {

    private final Map<WinningCriteria, Integer> winningInfo;

    public WinningStatistics() {
        winningInfo = new EnumMap(WinningCriteria.class);
        initializeWinningInfo();
    }

    private void initializeWinningInfo() {
        for (WinningCriteria criteria : WinningCriteria.values()) {
            winningInfo.put(criteria, 0);
        }
    }

    public void addResult(WinningCriteria winningCriteria) {
        winningInfo.put(winningCriteria, winningInfo.get(winningCriteria) + 1);
    }

    public int calculateTotalPrizeAmount() {
        int totalPrizeAmount = 0;
        for (WinningCriteria criteria : WinningCriteria.values()) {
            int prizeAmount = criteria.getPrizeAmount();
            int winningCount = winningInfo.get(criteria);
            totalPrizeAmount += prizeAmount * winningCount;
        }
        return totalPrizeAmount;
    }

    private String getMessage(WinningCriteria winningCriteria) {
        DecimalFormat decimalFormat = new DecimalFormat("###,###");
        String formattedPrizeAmount = decimalFormat.format(winningCriteria.getPrizeAmount());
        if (winningCriteria == WinningCriteria.SECOND) {
            return String.format("%d개 일치, 보너스 볼 일치 (%s원) - %d개\n", winningCriteria.getMatchingCount(),
                    formattedPrizeAmount, winningInfo.get(winningCriteria));
        } else {
            return String.format("%d개 일치 (%s원) - %d개\n", winningCriteria.getMatchingCount(), formattedPrizeAmount,
                    winningInfo.get(winningCriteria));
        }
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("당첨 통계\n");
        sb.append("---\n");

        for (WinningCriteria criteria : WinningCriteria.values()) {
            if (criteria == WinningCriteria.LOSE) {
                continue;
            }
            sb.append(getMessage(criteria));
        }
        return sb.toString();
    }
}
