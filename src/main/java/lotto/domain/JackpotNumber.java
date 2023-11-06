package lotto.domain;

public class JackpotNumber {
    private final Lotto jackpot;

    public JackpotNumber(Lotto jackpot) {
        this.jackpot = jackpot;
    }
    public Lotto getJackpot() {
        return jackpot;
    }
}
