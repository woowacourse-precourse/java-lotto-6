package lotto.domain;

public class WinLotto {
    private Lotto numbers;
    private int bonusNumber;

    public WinLotto(Lotto numbers, int bonusNumber) {
        this.numbers = numbers;
        this.bonusNumber = bonusNumber;
    }
}
