package lotto.model;

import static lotto.constants.LottoDetails.LOTTO_PRICE;

import java.math.BigDecimal;

public class Money {

    private final int price;

    public Money(int price) {
        validatePrice(price);
        this.price = price;
    }

    private void validatePrice(int price) {
        if (price % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException();
        }
    }

    public int numberOfLottoTickets() {
        return price / LOTTO_PRICE;
    }

    public void buyLottos(RandomLottoTickets randomLottoTickets) {
        for (int i = 0; i < numberOfLottoTickets(); i++) {
            randomLottoTickets.generateLottoTicket();
        }
    }

    public BigDecimal divideByMoney(BigDecimal sum) {
        return sum.divide(new BigDecimal(price));
    }
}
