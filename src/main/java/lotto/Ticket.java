package lotto;

public class Ticket {
    private Lotto lotto;
    private Bonus bonus;

    Ticket(Lotto lotto, Bonus bonus) {
        validate(lotto, bonus);

        this.lotto = lotto;
        this.bonus = bonus;
    }

    private void validate(Lotto lotto, Bonus bonus) {
        if (lotto.getNumbers().contains(bonus.getNumber())) {
            throw new IllegalArgumentException("보너스 번호가 로또 번호에 이미 존재합니다.");
        }
    }

    public Lotto getLotto() {
        return lotto;
    }

    public Bonus getBonus() {
        return bonus;
    }
}
