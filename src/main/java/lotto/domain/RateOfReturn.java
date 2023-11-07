package lotto.domain;

import java.text.NumberFormat;

public class RateOfReturn {
    String rateOfReturnPercent;

    public RateOfReturn() {
    }

    public RateOfReturn(int rateOfReturn) {
        this.rateOfReturnPercent = changeToPercent(rateOfReturn);
    }

    public String getRateOfReturn() {
        return rateOfReturnPercent;
    }

    private String changeToPercent(int num) {
        NumberFormat percentFormat = NumberFormat.getPercentInstance();
        return percentFormat.format(num);
    }
}
