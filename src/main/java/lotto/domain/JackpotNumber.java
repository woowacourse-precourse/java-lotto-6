package lotto.domain;

public class JackpotNumber {
    private final Lotto jackpot;
    private final Integer bonusNumber;

    public JackpotNumber(Lotto jackpot, Integer bounusNumber) {
        this.jackpot = jackpot;
        this.bonusNumber = bounusNumber;
    }
    public Lotto getJackpot() {
        return jackpot;
    }
    public Integer getBonusNumber() {
        return bonusNumber;
    }
}
