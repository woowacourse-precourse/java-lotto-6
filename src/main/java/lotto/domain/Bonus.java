package lotto.domain;

import static lotto.ApplicationContext.getDataModel;

import java.util.List;
import lotto.domain.constant.LottoConstant;
import lotto.exception.ExceptionType;
import lotto.exception.InputException;
import lotto.output.MessageType;
import lotto.output.OutputMessage;

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
        return LottoConstant.LOTTO_START_NUMBER > number || LottoConstant.LOTTO_END_NUMBER < number;
    }

    public int sameTicket(List<Integer> ticket) {
        int bonusCount = 0;

        if (ticket.contains(this.number)) {
            bonusCount = 1;
        }

        return bonusCount;
    }

    public void save(){
        getDataModel().saveBonus(this);
    }
}
