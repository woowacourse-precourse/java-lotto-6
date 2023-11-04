package lotto.domain;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.constants.Messages;
import lotto.constants.Values;
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
        DecimalFormat decimalFormat = new DecimalFormat(Values.AMOUNT_DECIMAL_FORMAT);
        String formattedPrizeAmount = decimalFormat.format(winningCriteria.getPrizeAmount());
        String winningFormat = Messages.WINNING_MESSAGE;
        if (winningCriteria == WinningCriteria.SECOND) {
            winningFormat = Messages.WINNING_SECOND_MESSAGE;
        }
        return String.format(winningFormat, winningCriteria.getMatchingCount(), formattedPrizeAmount,
                winningInfo.get(winningCriteria));
    }


    @Override
    public String toString() {
        String statistics = Messages.WINNING_STATISTICS + Messages.SEPARATOR_LINE;
        String result = Arrays.stream(WinningCriteria.values())
                .filter(criteria -> criteria != WinningCriteria.LOSE)
                .map(this::getMessage)
                .collect(Collectors.joining());
        return statistics + result;
    }
}
