package lotto.domain;

import lotto.view.ExceptionMessage;

public class Amount {

    private final int total;
    private int count;

    public Amount(int total, int ticketPrice) {
        validateSize(total,ticketPrice);
        validateStyle(total,ticketPrice);

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

    private void validateSize(int total, int minTicketPrice) {
        if (total<minTicketPrice) {
            ExceptionMessage.setAmountSizeError();
        }
    }

    private void validateStyle(int total, int ticketPrice) {
        if (total%ticketPrice!=0) {
            ExceptionMessage.setAmountStyleError();
        }
    }
}
