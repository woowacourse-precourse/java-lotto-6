package lotto.state;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.stream.Collectors;

public record WinningStatisticsState(double profit, List<MessagePerCount> message) {

    public String toResult() {
        return message.stream()
                .map(messagePerCount -> String.format("%s - %s개", messagePerCount.message, messagePerCount.count))
                .collect(Collectors.joining("\n"));
    }

    public String getProfitResult() {
        return String.format("%,.1f%%", BigDecimal.valueOf(profit).setScale(1, RoundingMode.HALF_UP));
    }


    public record MessagePerCount(String message, long count) {

    }
}
