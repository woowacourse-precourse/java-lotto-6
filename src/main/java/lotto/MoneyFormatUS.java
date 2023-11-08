package lotto;

import java.text.NumberFormat;
import java.util.Locale;

public class MoneyFormatUS {

    public String moneyFormat(long money) {
        NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.US);
        return numberFormat.format(money);
    }
}
