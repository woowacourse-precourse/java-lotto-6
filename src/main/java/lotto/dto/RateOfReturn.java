package lotto.dto;

import java.text.DecimalFormat;

public record RateOfReturn(double value) {
    private static final DecimalFormat decimalFormat = new DecimalFormat("#,##0.0");

    @Override
    public String toString() {
        return String.format("총 수익률은 %s%%입니다.", decimalFormat.format(value));
    }
}
