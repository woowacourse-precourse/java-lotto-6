package lotto.domain;

public class Bonus {
    private int num;

    public Bonus(int num, Lotto winningLotto) {
        validate(num, winningLotto);
        this.num = num;
    }

    public int getNum() {
        return this.num;
    }

    private void validate(int num, Lotto winningLotto) {
        if (winningLotto.getNumbers().contains(num))
            throw new IllegalArgumentException();
    }
}
