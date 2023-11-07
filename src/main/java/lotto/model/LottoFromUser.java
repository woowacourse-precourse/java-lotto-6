package lotto.model;

public class LottoFromUser {
    private final Lotto lotto;
    private final int bonusNumber;

    public LottoFromUser(Lotto lottoFromUser, int bonusNumberFromUser) {
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