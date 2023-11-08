package lotto.dto;

import lotto.constants.Config;
import lotto.constants.Message;

public record BonusNumber(Integer number) {
    public BonusNumber {
        validateNull(number);
        validateNumbersRange(number);
    }

    private void validateNull(Integer numbers) {
        if (numbers == null) {
            throw new IllegalArgumentException(Message.BONUS_NUMBER_NULL_INIT_EXCEPTION);
        }
    }

    private void validateNumbersRange(Integer number) {
        if (number > Config.MAX_LOTTO_NUMBER || number < Config.MIN_LOTTO_NUMBER) {
            throw new IllegalArgumentException(Message.LOTTO_NUMBER_RANGE_EXCEPTION);
        }
    }
    public Integer getNumber() {
        return number;
    }
}
