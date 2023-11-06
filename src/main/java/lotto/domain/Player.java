package lotto.domain;

public class Player {
    private static final int THOUSAND = 1000;
    private int money;

    public Player(String input) {
        this.money = Integer.parseInt(input);
    }
}
