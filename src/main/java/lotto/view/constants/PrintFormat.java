package lotto.view.constants;

import java.text.DecimalFormat;

public enum PrintFormat {
    SEPARATOR_FORMAT(new DecimalFormat("#,##0")),
    SEPARATOR_WITH_POINT_FORMAT(new DecimalFormat("#,##0.0"));

    private final DecimalFormat format;

    PrintFormat(DecimalFormat format) {
        this.format = format;
    }

    public DecimalFormat getFormat() {
        return format;
    }
}
