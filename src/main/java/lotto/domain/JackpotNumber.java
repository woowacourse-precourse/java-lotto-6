package lotto.domain;

public class JackpotNumber {
    private final Lotto jackpot;
    private Integer bonusNumber;

    public JackpotNumber(Lotto jackpot) {
        this.jackpot = jackpot;
        this.bonusNumber = 0;
    }
    public Lotto getJackpot() {
        return jackpot;
    }
    public Integer getBonusNumber() {
        return bonusNumber;
    }
    public void changeBonus(int bonus) {
        this.bonusNumber = bonus;
    }
}
