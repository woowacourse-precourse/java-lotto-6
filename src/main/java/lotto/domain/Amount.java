package lotto.domain;

import lotto.view.ExceptionMessage;

import java.util.List;

public class Amount {
    private final int total;
    private int count;

    public Amount(int total, int ticketPrice) {
        validateSize(total);
        validateStyle(total);

        this.total = total;
        count = calculateCount(total,ticketPrice);
    }

    public int getCount(){
        return count;
    }

    public int getTotal(){
        return total;
    }

    private int calculateCount(int total,int ticketPrice) {
        return total/ticketPrice;
    }

    private void validateSize(int total) {
        if (total<1000) {
            ExceptionMessage.setAmountSizeError();
        }
    }

    private void validateStyle(int total) {
        if (total%1000!=0) {
            ExceptionMessage.setAmountStyleError();
        }
    }
}
