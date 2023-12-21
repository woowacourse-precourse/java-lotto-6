package lotto.dto;

public class BonusNumberRequestDto {

    private final int number;

    public BonusNumberRequestDto(String number) {
        this.number = validateNumberFormat(number);
    }

    private int validateNumberFormat(String input) {
        try {
            return Integer.parseInt(input.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    public int getNumber() {
        return number;
    }
}
