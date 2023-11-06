package lotto.config;

import javax.swing.plaf.PanelUI;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum WinningResultConfig {
    THREE("3", 5000),
    FOUR("4", 50000),
    FIVE("5", 1500000),
    FIVE_AND_BONUS("5,보너스 볼", 30000000),
    SIX("6", 2000000000);

    private String resultStatus;
    private int revenueStatus;

    private static final Map<String, WinningResultConfig> BY_LABEL =
            Stream.of(values()).collect(Collectors.toMap(WinningResultConfig::getResultStatus, e -> e));

    WinningResultConfig(String resultStatus, int revenueStatus) {
        this.resultStatus = resultStatus;
        this.revenueStatus = revenueStatus;
    }

    public static WinningResultConfig valueOfLabel(String resultStatus) {
        return BY_LABEL.get(resultStatus);
    }

    public static WinningResultConfig compareResult(Long equalCount, String bonus) {
        if (bonus.contains(FIVE_AND_BONUS.getResultStatus().split(",")[1])
                &&  Long.toString(equalCount).equals(FIVE.getResultStatus())) {
            return WinningResultConfig.FIVE_AND_BONUS;
        }
        return valueOfLabel(Long.toString(equalCount));

    }

    public String getResultStatus() { return resultStatus; }

    public int getRevenueStatus() {
        return revenueStatus;
    }
}
