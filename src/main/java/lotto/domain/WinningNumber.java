package lotto.domain;

public class WinningNumber {
    private Lotto numbers;
    private Integer bonus;

    public Lotto getNumbers() {
        return numbers;
    }

    public void setNumbers(Lotto numbers) {
        this.numbers = numbers;
    }

    public Integer getBonus() {
        return bonus;
    }

    public void setBonus(Integer bonus) {
        this.bonus = bonus;
    }
}
