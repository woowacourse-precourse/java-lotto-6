package lotto.domain;

public class Amount {
    private final int total;
    private int count;

    public Amount(int total, int ticketPrice) {
        this.total = total;
        count = calculateCount(total,ticketPrice);
    }

    public int getCount(){
        return count;
    }

    private int calculateCount(int total,int ticketPrice) {
        return total/ticketPrice;
    }



    //TODO : 예외처리
}
