package lotto.dto;

import lotto.Money;

public record MoneyDto(String money) {
    // 3자리마다 콤마를 찍기 위한 정규식 ex) 1000 -> 1,000원
    private static final String REGEX = "(\\d)(?=(\\d{3})+$)";

    public static MoneyDto from(Money money) {
        return new MoneyDto(String.valueOf(money.getValue())
                .replaceAll(REGEX, "$1,"));
    }
}
