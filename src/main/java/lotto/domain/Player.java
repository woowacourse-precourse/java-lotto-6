package lotto.domain;

public class Player {

    private final Lotto winningNumber;
    private final int bonusNumber;
    private final int quantity;

    public Player(Lotto lotto, int bonus, int quantity){
        this.winningNumber = lotto;
        this.bonusNumber = bonus;
        this.quantity = quantity;
    }

    public Lotto getWinningNumber(){
        return this.winningNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

}
