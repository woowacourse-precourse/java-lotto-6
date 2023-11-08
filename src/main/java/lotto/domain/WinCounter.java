package lotto.domain;

import lotto.constant.Format;
import lotto.constant.Value;
import lotto.constant.WinType;
import java.text.DecimalFormat;
import java.util.LinkedHashMap;
import java.util.Map;

public class WinCounter {
    private final Map<WinType, Integer> winCounts;

    public WinCounter() {
        winCounts = new LinkedHashMap<>();
        for (WinType winType : WinType.values()) {
            winCounts.put(winType, Value.ZERO.get());
        }
    }

    public int getCount(WinType winType) {
        return winCounts.get(winType);
    }

    public void put(WinType winType, int winCount) {
        winCounts.put(winType, winCount);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        int lineCount = winCounts.size();
        for (Map.Entry<WinType, Integer> winEntry : winCounts.entrySet()) {
            lineCount--;
            WinType winType = winEntry.getKey();
            sb.append(winType.getName())
                    .append(Format.SPACE.get())
                    .append(convertRewardFormat(winType))
                    .append(Format.STATISTICS_JOIN_HYPHEN.get())
                    .append(winEntry.getValue())
                    .append(Format.WIN_COUNT_UNIT.get());
            if (lineCount > 0) {
                sb.append(Format.NEW_LINE.get());
            }
        }
        return sb.toString();
    }

    private String convertRewardFormat(WinType winType) {
        StringBuilder sb = new StringBuilder();
        sb.append(Format.OPEN_BRACKET.get())
                .append(convertMoneyFormat(winType.getReward()))
                .append(Format.MONEY_UNIT.get())
                .append(Format.CLOSE_BRACKET.get());
        return sb.toString();
    }

    private static String convertMoneyFormat(int money) {
        return String.format("%,d", money);
    }

    public String getRateOfReturn(int payedMoney) {
        int sum = 0;
        for (Map.Entry<WinType, Integer> winCase : winCounts.entrySet()) {
            int reward = winCase.getKey().getReward();
            int count = winCase.getValue();
            sum += reward * count;
        }
        return percentFormat((double) sum / payedMoney * 100);
    }

    private String percentFormat(double number) {
        DecimalFormat df = new DecimalFormat("#.##");
        return df.format(number) + Format.PERCENT.get();
    }
}