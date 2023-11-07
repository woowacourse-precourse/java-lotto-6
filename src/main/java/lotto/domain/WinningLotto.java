package lotto.domain;

public class WinningLotto {
    private final Lotto numbers;
    private final int bonusNum;

    public WinningLotto(Lotto numbers, int bonusNum) {
        this.numbers = numbers;
        this.bonusNum = bonusNum;
    }
    public void printNumbers() {
        numbers.printNumbers();
    }
}
