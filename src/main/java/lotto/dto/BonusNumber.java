package lotto.dto;

public record BonusNumber(Integer number) {
    public BonusNumber {
        validateNull(number);
        validateNumbersRange(number);
    }

    private void validateNull(Integer numbers) {
        if (numbers == null) {
            throw new IllegalArgumentException();
        }
    }

    private void validateNumbersRange(Integer number) {
        if (number > 45 || number < 1) {
            throw new IllegalArgumentException("");
        }
    }
    public Integer getNumber() {
        return number;
    }
}
