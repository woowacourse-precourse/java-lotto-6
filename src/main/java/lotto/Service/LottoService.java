package lotto.Service;

public class LottoService {
    private final int TICKET_PRICE = 1000;
    public int getTicketCount(int money) {
        if (money % TICKET_PRICE == 0) return money / TICKET_PRICE;
        throw new IllegalArgumentException("1000원으로 나누어 떨어지지 않습니다.");
    }
}
