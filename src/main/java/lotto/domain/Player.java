package lotto.domain;

public class Player {
    private static final int THOUSAND = 1000;
    private int money;

    public Player(String input) {
        this.money = Integer.parseInt(input);
    }

    public void divideMoneyByThousand() {
        int tickets = money / THOUSAND;
        System.out.println(tickets);
    }
}
