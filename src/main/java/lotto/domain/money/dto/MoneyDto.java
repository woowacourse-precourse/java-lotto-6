package lotto.domain.money.dto;

import java.util.Objects;

import static lotto.global.constant.exception.ExceptionMessage.INPUT_CANNOT_BE_NULL;

public record MoneyDto(String money) {
    public MoneyDto {
        if(money == null) {
            throw new IllegalArgumentException(INPUT_CANNOT_BE_NULL.getMessage());
        }
    }
}
