package lotto.model.dto;

import lotto.model.domain.Player;

import static lotto.constants.Error.NUMERIC_INVALID;

public class PlayerRequestDto {
    private final int money;

    public PlayerRequestDto(String money) {
        this.money = validateNumber(money);
    }

    public Player toPlayer() {
        return Player.from(money);
    }

    private static int validateNumber(String money) {
        try {
            return Integer.parseInt(money);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NUMERIC_INVALID.getMessage());
        }
    }
}
