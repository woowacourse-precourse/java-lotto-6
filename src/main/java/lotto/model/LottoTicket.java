package lotto.model;

import java.util.List;

public class LottoTicket extends Lotto {

    public static final int PRICE = 1000;

    public LottoTicket(List<Integer> numbers) {
        super(numbers);
    }

    public static void isNotMultipleOfLottoPrice(final int buyingCost) {
        // 조건문 고칠 수 있으면 고쳐봐
        if (buyingCost < LottoTicket.PRICE || buyingCost % LottoTicket.PRICE != 0) {
            throw new IllegalArgumentException("로또 구입 금액은 로또 가격의 배수여야 합니다.");
        }
    }
}