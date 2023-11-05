package lotto.model;

public record WinLotto(Lotto lotto, Integer bonusNumber) {

    public WinLotto {
        if (bonusNumber > 45 || bonusNumber < 1) {
            throw new IllegalArgumentException();
        }
    }
}
