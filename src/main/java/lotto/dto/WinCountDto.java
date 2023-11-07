package lotto.dto;

import lotto.constant.Format;
import lotto.constant.Value;
import lotto.constant.WinStrategy;

import java.util.LinkedHashMap;
import java.util.Map;

public class WinCountDto {
    private final Map<String, Integer> winCounts;

    public WinCountDto() {
        winCounts = new LinkedHashMap<>();
        for (WinStrategy strategy : WinStrategy.values()) {
            winCounts.put(strategy.getWinType(), Value.ZERO.get());
        }
    }

    public int getCount(String winType) {
        return winCounts.get(winType);
    }

    public void put(String winType, int winCount) {
        winCounts.put(winType, winCount);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Integer> winEntry : this.winCounts.entrySet()) {
            sb.append(winEntry.getKey())
                    .append(Format.STATISTICS_JOIN_HYPHEN.get())
                    .append(winEntry.getValue())
                    .append(Format.WIN_COUNT_UNIT.get())
                    .append(Format.NEW_LINE.get());
        }
        return sb.toString();
    }
}