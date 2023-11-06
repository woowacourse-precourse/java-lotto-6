package lotto.domain;

import static lotto.validator.PlayerInputValidator.validate;

public class Player {
    public static final int LOTTO_PRICE = 1000;
    private final int count;

    public Player(String count) {
        int countNumber = validate(count);
        this.count = countNumber;
    }

    public int getCount() {
        return count / LOTTO_PRICE;
    }
}
