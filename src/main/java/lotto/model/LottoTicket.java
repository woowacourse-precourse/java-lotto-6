package lotto.model;

import java.util.List;

public class LottoTicket extends Lotto {

    public static final int PRICE = 1000;
    public static final String INVALID_BUYING_COST_MESSAGE = "로또 구입 금액은 로또 가격의 배수여야 합니다";


    public LottoTicket(final List<Integer> numbers) {
        super(numbers);
    }

    public static void isNotMultipleOfLottoPrice(final int buyingCost) {
        if (buyingCost < LottoTicket.PRICE || buyingCost % LottoTicket.PRICE != 0) {
            throw new IllegalArgumentException(INVALID_BUYING_COST_MESSAGE);
        }
    }
}