package lotto.dto;

public class BonusNumberForm {

    private final int number;

    public BonusNumberForm(String number) {
        this.number = validateNumberFormat(number);
    }

    private int validateNumberFormat(String input) {
        try {
            return Integer.parseInt(input.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR]");
        }
    }

    public int getNumber() {
        return number;
    }
}
