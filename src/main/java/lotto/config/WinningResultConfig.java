package lotto.config;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum WinningResultConfig {
    THREE("3", 5000),
    FOUR("4", 50000),
    FIVE("5", 1500000),
    FIVE_AND_BONUS("5,보너스 볼", 30000000),
    SIX("6", 2000000000);

    private final String resultStatus;
    private final int revenueStatus;

    WinningResultConfig(String resultStatus, int revenueStatus) {
        this.resultStatus = resultStatus;
        this.revenueStatus = revenueStatus;
    }

    private static final Map<String, WinningResultConfig> byEqual =
            Stream.of(values()).collect(Collectors.toMap(WinningResultConfig::getResultStatus, e -> e));

    public static WinningResultConfig objectOfEqual(String equal) {
        return byEqual.get(equal);
    }

    public static WinningResultConfig findWinningResultConfig(int equalCount, String bonus) {
        if (bonus.contains(FIVE_AND_BONUS.getResultStatus().split(",")[1])
                &&  Integer.toString(equalCount).equals(FIVE.getResultStatus())) {
            return WinningResultConfig.FIVE_AND_BONUS;
        }
        return objectOfEqual(Long.toString(equalCount));

    }

    public String getResultStatus() { return resultStatus; }

    public int getRevenueStatus() {
        return revenueStatus;
    }
}
