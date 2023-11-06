package lotto.domain;

import java.util.List;
import lotto.common.Constant;
import lotto.common.ErrorMessage;

public class AutomaticLottoStorage {

    private List<AutomaticLotto> automaticLottos;
    private final Integer totalPrice;

    public AutomaticLottoStorage(final Integer totalPrice) {
        validate(totalPrice);

        this.totalPrice = totalPrice;
        this.automaticLottos = AutomaticLotto.from(getTicketCount());
    }


    public static AutomaticLottoStorage of(final Integer totalPrice) {
        return new AutomaticLottoStorage(totalPrice);
    }

    public List<AutomaticLotto> getAutomaticLottos() {
        return automaticLottos;
    }

    private Integer getTicketCount() {
        return this.totalPrice / Constant.LOTTO_TICKET_PRICE;
    }

    private void validate(final Integer totalPrice) {
        if (totalPrice % Constant.LOTTO_TICKET_PRICE > 0) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_PURCHASE_AMOUNT_INVALID_ERROR.getMessage());
        }
    }
}
