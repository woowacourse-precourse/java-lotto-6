package lotto.model;

import java.text.NumberFormat;
import java.util.Locale;

public class Percent {
    private final double percent;
    public Percent(LottoTicketMoney lottoTicketMoney, PriceMoney priceMoney) {
        percent = priceMoney.div(lottoTicketMoney) * 100.0;
    }

    @Override
    public String toString() {
        NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.US);
        String roundPercent = String.format("%.1f%%", percent);
        return numberFormat.format(roundPercent);
    }
}
