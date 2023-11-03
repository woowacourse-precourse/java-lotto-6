package lotto.model.dto;

import lotto.model.domain.Player;

import static lotto.constants.Error.NUMERIC_INVALID;

public class MoneyRequestDto {
    private final int money;

    public MoneyRequestDto(String money) {
        this.money = validateNumber(money);
    }

    public Player toPlayer() {
        return new Player(money);
    }

    private int validateNumber(String money) {
        try {
            return Integer.parseInt(money);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NUMERIC_INVALID.getMessage());
        }
    }
}
