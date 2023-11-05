package lotto.domain;

public class Player {

    private Lotto winningNumber;
    private int bonusNumber;
    private final int price;
    private final int quantity;

    public Player(Lotto lotto, int bonus, int price, int quantity){
        this.winningNumber = lotto;
        this.price  = price;
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
