package lotto.model;

public class Money {

    private final int money;
    private final static int TICKET_PRICE = 1000;
    private final static int MIN_PRICE = 1000;

    public Money(int money) {
        this.money = money;
    }

    public void validate(int money){
        validateRange(money);
        validateUnit(money);
    }

    public void validateRange(int money){
        if(!(money >MIN_PRICE)){
            throw new IllegalArgumentException();
        }
    }

    public void validateUnit(int money){
        if(!(money % TICKET_PRICE == 0)){
            throw new IllegalArgumentException();
        }
    }

    public int getTicket() {
        return money / TICKET_PRICE;
    }

}
