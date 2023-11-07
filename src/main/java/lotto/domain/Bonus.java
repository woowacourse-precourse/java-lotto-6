package lotto.domain;

import java.util.List;
import lotto.config.exception.ExceptionType;
import lotto.config.exception.InputException;
import lotto.config.output.MessageType;
import lotto.config.output.OutputMessage;
import lotto.domain.constant.LottoConstant;

public class Bonus {
    private final int number;

    public Bonus(int number) {
        validate(number);
        this.number = number;

        OutputMessage.printf(MessageType.INPUT_BUYER_FORMAT, this.number);
    }

    private void validate(int number) {
        if (isLottoRange(number)) {
            throw new InputException(ExceptionType.ERROR_LOTTO_RANGE);
        }
    }

    private boolean isLottoRange(int number) {
        return isHight(number) || isLower(number);
    }

    private static boolean isHight(Integer number) {
        return LottoConstant.LOTTO_END_NUMBER < number;
    }

    private static boolean isLower(Integer number) {
        return LottoConstant.LOTTO_START_NUMBER > number;
    }

    public int sameTicket(List<Integer> ticket) {
        int bonusCount = 0;

        if (ticket.contains(this.number)) {
            bonusCount = 1;
        }

        return bonusCount;
    }
}
