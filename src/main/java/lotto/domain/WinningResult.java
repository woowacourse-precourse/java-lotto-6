package lotto.domain;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;
import java.util.stream.Collectors;

public class WinningResult {
    private static final String RESULT_FORMAT_MESSAGE = "%d개 일치%s (%s원) - %d개";
    private final Map<Rank, Integer> winningResult = new EnumMap<>(Rank.class);

    public void addWinning(Rank rank) {
        winningResult.put(rank, winningResult.getOrDefault(rank, 0) + 1);
    }

    public String getResultMessage() {
        return Arrays.stream(Rank.values())
                .filter(rank -> rank != Rank.FAIL)
                .map(rank -> String.format(RESULT_FORMAT_MESSAGE, rank.getMatchCount(), getSecondMessage(rank), getFormatNumberWithCommas(rank), getMatchCount(rank)))
                .collect(Collectors.joining("\n"));
    }

    private Integer getMatchCount(Rank rank) {
        return winningResult.getOrDefault(rank, 0);
    }

    private String getSecondMessage(Rank rank) {
        if (rank == Rank.SECOND) {
            return ", 보너스 볼 일치";
        }
        return "";
    }

    public String getFormatNumberWithCommas(Rank rank) {
        DecimalFormat decimalFormat = new DecimalFormat("#,###");
        return decimalFormat.format(rank.getReward());
    }
}
