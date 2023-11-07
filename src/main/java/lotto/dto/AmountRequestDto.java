package lotto.dto;

public record AmountRequestDto(String amount) {
    public int amountStringToInteger() {
        return Integer.parseInt(amount);
    }
}
