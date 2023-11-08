package lotto.model;

public class NumbersFromUser {
    private final Lotto lotto;
    private final int bonusNumber;

    public NumbersFromUser(Lotto lottoFromUser, int bonusNumberFromUser) {
        lotto = lottoFromUser;
        bonusNumber = bonusNumberFromUser;
    }

    public Lotto getLotto() {
        return lotto;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}