package lotto.domain;


public class Player {
    private int money;

    public Player(String input) {
        this.money = Integer.parseInt(input);
    }

    public void divideMoneyByThousand() {
        int tickets = money / ConstantValue.THOUSAND;
        System.out.println(tickets);
    }
}
