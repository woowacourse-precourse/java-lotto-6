package lotto.domain;

public class Ticket {

    private Lotto numbers;

    public void setTicket(Lotto numbers) {
        this.numbers = numbers;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

}
