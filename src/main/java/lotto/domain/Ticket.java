package lotto.domain;

public class Ticket {

    private Lotto lotto;

    public void setTicket(Lotto numbers) {
        this.lotto = numbers;
    }

    public Lotto getLotto() {
        return lotto;
    }

    @Override
    public String toString() {
        return lotto.toString();
    }

}
