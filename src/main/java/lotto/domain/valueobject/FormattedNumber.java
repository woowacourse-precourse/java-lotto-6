package lotto.domain.valueobject;

public class FormattedNumber {
    private final int number;

    public FormattedNumber(int number) {
        this.number = number;
    }

    public String getThousandsSeparator() {
        return String.format("%,d", number);
    }
}
