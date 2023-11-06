package lotto.domain.valueobject;

public class FormattedNumber {
    private final static String FORMAT = "%,d";
    private final int number;

    public FormattedNumber(int number) {
        this.number = number;
    }

    public String getThousandsSeparator() {
        return String.format(FORMAT, number);
    }
}
