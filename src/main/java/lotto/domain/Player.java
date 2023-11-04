package lotto.domain;


public class Player {
    private final Lottos lottos;
    private final int inputAmount;


    private int winnings;

    public Player(Lottos lottos, int amount) {
        this.lottos = lottos;
        this.inputAmount = amount;
    }
}
