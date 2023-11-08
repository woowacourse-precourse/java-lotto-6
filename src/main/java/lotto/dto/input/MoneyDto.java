package lotto.dto.input;

import lotto.domain.validator.MoneyValidator;

public record MoneyDto(int money) {
    public static MoneyDto from(String input) {
        int money = Integer.parseInt(input);
        MoneyValidator.verifyMinAmount(money);
        MoneyValidator.verifyMaxAmount(money);
        MoneyValidator.verifyDivisibleBy(money);
        return new MoneyDto(money);
    }
}
