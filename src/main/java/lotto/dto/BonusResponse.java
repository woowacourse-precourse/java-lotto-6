package lotto.dto;

public record BonusResponse(
        int bonusNumber
) {
    public int getResponse() {
        return bonusNumber;
    }
}
