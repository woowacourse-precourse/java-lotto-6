package lotto.vo.response;

public class ProfitResponse {
    private static final String OUTPUT_FORM = "총 수익률은 %,d%s%%입니다.";

    private final int integerPart;
    private final double decimalPart;

    public ProfitResponse(double value) {
        this.integerPart = (int)value;
        this.decimalPart = value % 1;
    }

    public String createMessage() {
        String decimalFrom = String.format("%.1f", decimalPart).replace("0.", ".");
        return String.format(OUTPUT_FORM, integerPart, decimalFrom);
    }
}
