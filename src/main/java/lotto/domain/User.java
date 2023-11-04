package lotto.domain;

import java.util.List;
import lotto.enums.ExceptionMessages;
import lotto.enums.Patterns;

public class User {
    private Integer lottoTicketCount;
    private List<Lotto> lottos;

    public User(String amount) {
        validateAmount(amount);
        this.lottoTicketCount = Integer.valueOf(amount) / 1000;
    }

    private void validateAmount(String amount) {
        if (!isValidAmount(amount)) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_AMOUNT_MESSAGE.getMessage());
        }
    }

    private Boolean isValidAmount(String amount) {
        return Patterns.AMOUNT_CHECK_PATTERN.getPattern().matcher(amount).matches();
    }

    public Integer getLottoTicketCount() {
        return lottoTicketCount;
    }
}
