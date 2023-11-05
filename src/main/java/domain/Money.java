package domain;

public class Money {
    private final int money;

    public Money(int money) {
        validateMoney(money);
        this.money = money;
    }

    public int getTicketCount() {
        return money / LottoTickets.TICKET_COST;
    }

    private void validateMoney(int money) {
        if (money < LottoTickets.TICKET_COST) {
            throw new IllegalArgumentException();
        }
        if (money % LottoTickets.TICKET_COST != 0) {
            throw new IllegalArgumentException();
        }
    }

    public double getRateOfReturn(int sumOfWinningPrize) {
        validateMoney();
        return (double) sumOfWinningPrize / money * 100;
    }

    private void validateMoney() {
        if (money <= 0) {
            throw new RuntimeException();
        }
    }
}
