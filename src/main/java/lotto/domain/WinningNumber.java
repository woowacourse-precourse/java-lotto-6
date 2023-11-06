package lotto.domain;

public class WinningNumber {
    private Lotto numbers;
    private int bonus;

    public Lotto getNumbers() {
        return numbers;
    }

    public void setNumbers(Lotto numbers) {
        this.numbers = numbers;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }
}
