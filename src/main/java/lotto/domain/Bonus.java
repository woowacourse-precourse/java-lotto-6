package lotto.domain;

import static lotto.ApplicationContext.getDataModel;

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
        if (islottoRange(number)) {
            throw new InputException(ExceptionType.ERROR_LOTTO_RANGE);
        }
    }

    private boolean islottoRange(int number) {
        return LottoConstant.LOTTO_START_NUMBER > number || LottoConstant.LOTTO_END_NUMBER < number;
    }

    public void save(){
        getDataModel().saveBonus(this.number);
    }
}
