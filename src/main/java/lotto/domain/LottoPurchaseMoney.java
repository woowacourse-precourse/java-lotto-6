package lotto.domain;

public class LottoPurchaseMoney {
    private static final int TICKET_PRICE = 1000;


    public LottoPurchaseMoney() {
    }

    public int getTicketCount(int money){
        if (money % TICKET_PRICE != 0){
            throw new IllegalArgumentException("[ERROR] 1000원으로 나누어 떨어지는 수여야 합니다.");
        }
        return money / TICKET_PRICE;
    }
}
