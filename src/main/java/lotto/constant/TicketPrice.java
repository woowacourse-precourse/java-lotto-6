package lotto.constant;

public enum TicketPrice {
    TICKET_PRICE(1000);

    private final int value;

    TicketPrice(int value){
        this.value = value;
    }
    public int getValue(){
        return value;
    }
}
