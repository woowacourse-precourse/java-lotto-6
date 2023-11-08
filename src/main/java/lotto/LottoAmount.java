package lotto;

public class LottoAmount {
    private int money;
    private int tickets;

    public LottoAmount() {
        this.money = 0;
        this.tickets = 0;
    }

    public int getMoney() {
        return money;
    }

    public int getTickets() {
        setTickets();
        return tickets;
    }

    public void setMoney(int money) {
        isDivisibleBy1000(money);
        this.money = money;
    }

    private void setTickets() {
        if (money != 0)
            this.tickets = money / 1000;
    }

    private static void isDivisibleBy1000(int input) {
        if ((input % 1000) != 0 || input <= 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위로 입력해야 합니다.");
        }
    }
}
