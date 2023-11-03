package lotto.dto;

public record BonusRequestDto(String bonus) {
    public int bonusStringToInteger() {
        return Integer.parseInt(bonus);
    }
}
