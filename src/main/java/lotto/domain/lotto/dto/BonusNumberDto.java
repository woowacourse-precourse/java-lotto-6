package lotto.domain.lotto.dto;

import static lotto.global.constant.exception.ExceptionMessage.INPUT_CANNOT_BE_NULL;

public record BonusNumberDto(String number) {

    public BonusNumberDto {
        if(number == null) {
            throw new IllegalArgumentException(INPUT_CANNOT_BE_NULL.getMessage());
        }
    }
}
