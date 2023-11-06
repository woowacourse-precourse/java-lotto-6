package lotto.domain;

public class Customer {
    private final Integer TICKET_UNIT = 1000;

    public int BUDGET;
    public int NUMBER_OF_TICKETS;
    public Float RATE_OF_RETURN;

    public Customer(Integer budget) {
        this.BUDGET = budget;
        this.NUMBER_OF_TICKETS = BUDGET / TICKET_UNIT;
    }

    @Override
    public String toString() {
        return System.out.printf("%d개를 구매했습니다.", NUMBER_OF_TICKETS).toString();
    }
}
