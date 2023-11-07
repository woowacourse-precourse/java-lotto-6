package lotto.domain;

import java.util.List;
import lotto.common.Constant;
import lotto.common.ErrorMessage;
import lotto.util.LottoGamePrinter;
import lotto.util.TextBuilder;

public class AutomaticLottoStorage {

    private List<AutomaticLotto> automaticLottos;


    private final Integer totalPrice;

    private AutomaticLottoStorage(final Integer totalPrice) {
        validate(totalPrice);

        this.totalPrice = totalPrice;
        this.automaticLottos = AutomaticLotto.from(getTicketCount());
    }

    public static AutomaticLottoStorage from(final Integer totalPrice) {
        return new AutomaticLottoStorage(totalPrice);
    }

    public void showAutomaticLottosResult() {
        TextBuilder textBuilder = TextBuilder.fromString(getTicketCount() + "개를 구매했습니다.").appendLineSeparator();

        automaticLottos.forEach(
                automaticLotto -> textBuilder
                        .append(automaticLotto.getAutomaticLottoNumbers().toString())
                        .appendLineSeparator());
        LottoGamePrinter.println(textBuilder.build());
    }

    public List<AutomaticLotto> getAutomaticLottos() {
        return automaticLottos;
    }

    private Integer getTicketCount() {
        return this.totalPrice / Constant.LOTTO_TICKET_PRICE;
    }

    public Integer getTotalPrice() {
        return totalPrice;
    }

    private void validate(final Integer totalPrice) {
        if (totalPrice % Constant.LOTTO_TICKET_PRICE > 0) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_PURCHASE_AMOUNT_INVALID_ERROR.getMessage());
        }
    }
}
