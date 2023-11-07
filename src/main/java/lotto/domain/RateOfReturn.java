package lotto.domain;

public class RateOfReturn {
    private static final int ROUNDING_DIGIT = 1;

    private String rateOfReturnPercent;

    public RateOfReturn() {
    }

    public RateOfReturn(double rateOfReturn) {
        String rateOfReturnPercent = changeToneDecimalPercent(rateOfReturn);

        this.rateOfReturnPercent = rateOfReturnPercent;
    }

    public String getRateOfReturn() {
        return rateOfReturnPercent;
    }

    private String changeToneDecimalPercent(double num) {
        num *= 100; // 백분율로 변환
        num = roundNum(num);

        return num + "%";
    }

    private double roundNum(double num) {
        return Math.round(num * Math.pow(10.0, ROUNDING_DIGIT)) / Math.pow(10.0, ROUNDING_DIGIT);
    }
}
