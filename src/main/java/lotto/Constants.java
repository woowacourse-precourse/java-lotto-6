package lotto;

public enum Constants {
    TICKET(1000);

    private int price;

    private Constants(int p){
        price=p;
    }
    public int getPrice(){
        return price;
    }
}
