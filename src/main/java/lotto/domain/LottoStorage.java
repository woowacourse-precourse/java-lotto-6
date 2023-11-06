package lotto.domain;


import lotto.common.Constant;
import lotto.common.ErrorMessage;

public class LottoStorage {

    private final WinningLotto winningLotto;
    private final Integer totalPrice;


    public LottoStorage(final WinningLotto winningLotto, final Integer totalPrice) {
        validate(totalPrice);

        this.winningLotto = winningLotto;
        this.totalPrice = totalPrice;
    }

    public Integer getTicketCount() {
        return this.totalPrice / Constant.LOTTO_TICKET_PRICE;
    }

    private void validate(final Integer totalPrice) {
        if (totalPrice % Constant.LOTTO_TICKET_PRICE > 0) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_PURCHASE_AMOUNT_INVALID_ERROR.getMessage());
        }
    }
}
