package lotto.model;

public class User {
    private final Lotto lotto;
    private final int bonusNumber;

    public User(Lotto lotto, int bonusNumber) {
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }
}
