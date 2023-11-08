package lotto.domain;

import lotto.validator.PlayerInputValidator;

public class Player {
    public static final int LOTTO_PRICE = 1000;
    private final int count;

    public Player(String count) {
        int countNumber = PlayerInputValidator.validateNumber(count);
        this.count = countNumber;
    }

    public int getCount() {
        return count / LOTTO_PRICE;
    }
}
