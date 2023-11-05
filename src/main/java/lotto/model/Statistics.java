package lotto.model;

public class Statistics {
    private final String value;
    private final int valueNumber;
    private int amountOfTickets;

    public Statistics(String value, int valueNumber, int amountOfTickets) {
        this.value = value;
        this.valueNumber = valueNumber;
        this.amountOfTickets = amountOfTickets;
    }

    public String getValue() {
        return value;
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
