package lotto.domain.lotto.dto;

public record BonusNumberDto(String number) {

    public BonusNumberDto {
        if(number == null) {
            throw new IllegalArgumentException("null x");
        }
    }
}
