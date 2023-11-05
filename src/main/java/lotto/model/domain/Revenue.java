package lotto.model.domain;

import java.text.DecimalFormat;
import lotto.constance.PrintConst;

public class Revenue {
    double revenue;

    public Revenue(long prize, int money) {
        this.revenue = (100.0 * prize) / money;
    }

    @Override
    public String toString() {
        return String.format(PrintConst.FORMAT_REVENUE,
                new DecimalFormat(PrintConst.DECIMAL_FORMAT_REVENUE).format(revenue));
    }
}
