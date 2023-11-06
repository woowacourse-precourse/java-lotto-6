package lotto.domain;

import java.util.List;

public class Amount {

    private final String INPUT_SIZE_ERROR = "[ERROR] 입력 금액은 1,000원 이상이어야 합니다.";
    private final String INPUT_STYLE_ERROR = "[ERROR] 입력 금액은 1,000원 단위여야 합니다.";
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
            throw new IllegalArgumentException(INPUT_SIZE_ERROR);
        }
    }

    private void validateStyle(int total) {
        if (total%1000!=0) {
            throw new IllegalArgumentException(INPUT_STYLE_ERROR);
        }
    }



    //TODO : 예외처리
}
