package lotto.domain;

public class Player {
    private int money;
    private int quantity;
    private double prize;

    private int change;

    public Player(String money) {
        int parsingMoney = checkMoney(money);
        shortCheckMoney(parsingMoney);
        this.money = parsingMoney;
        this.quantity = parsingMoney / 1000;
        this.change = parsingMoney % 1000;
        this.prize = 0;
    }

    private int checkMoney(String money) {
        try {
            return Integer.parseInt(money);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 금액을 올바르게 입력 하세요.");
        }
    }

    private void shortCheckMoney(int money) {
        if (money < 1000)
            throw new IllegalArgumentException("[ERROR] 1000원 이상의 금액을 입력해 주세요.");
    }

    public void sumPrize(int prize) {
        this.prize = this.prize + prize;
    }

    public double getPercent() {
        return 100.0 * prize / money;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getChange() {
        return change;
    }
}