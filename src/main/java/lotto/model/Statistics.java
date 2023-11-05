package lotto.model;

public class Statistics {
    private final String valueNumber;
    private int amountOfTickets;

    public Statistics(String valueNumber, int amountOfTickets) {
        this.valueNumber = valueNumber;
        this.amountOfTickets = amountOfTickets;
    }

    public String getValueNumber() {
        return valueNumber;
    }
    public int getAmountOfTickets() {
        return amountOfTickets;
    }
    public void setAmountOfTickets(int amountOfTickets) {
        this.amountOfTickets = amountOfTickets;
    }
}
