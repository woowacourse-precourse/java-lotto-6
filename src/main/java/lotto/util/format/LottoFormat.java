package lotto.util.format;

import java.text.DecimalFormat;
import java.text.Format;

public enum LottoFormat {
    PRICE(new DecimalFormat("#,###")),
    EARNING_RATE(new DecimalFormat("0.0%"));

    private final Format format;

    LottoFormat(final Format format) {
        this.format = format;
    }

    public Format getFormat() {
        return format;
    }
}
