package lotto.model;

public class Statistics {
    private final int valueNumber;
    private int amountOfTickets;

    public Statistics(int valueNumber, int amountOfTickets) {
        this.valueNumber = valueNumber;
        this.amountOfTickets = amountOfTickets;
    }

    public int getValueNumber() {
        return valueNumber;
    }
    public int getAmountOfTickets() {
        return amountOfTickets;
    }
    public void setAmountOfTickets(int amountOfTickets) {
        this.amountOfTickets = amountOfTickets;
    }
}
