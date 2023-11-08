package lotto.model;

import lotto.config.LottoConstants;
import lotto.view.Messages;

import java.util.List;
import java.util.stream.Collectors;

public class Bonus {

    private final int number;


    public Bonus(String number, Lotto winningLotto) {
        validate(number, winningLotto);
        this.number = Integer.parseInt(number);
    }

    public int getNumber() {
        return this.number;
    }

    private void validate(String number, Lotto winningLotto) {
        int bonusNumber;

        try {
            bonusNumber = Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Messages.LOTTO_STATE_ERROR_MESSAGE);
        }

        if (bonusNumber < LottoConstants.LOTTO_MIN_NUMBER.getValue() || bonusNumber > LottoConstants.LOTTO_MAX_NUMBER.getValue()) {
            throw new IllegalArgumentException(Messages.LOTTO_NUMBER_OUT_OF_RANGE_ERROR_MESSAGE);
        }

        if (winningLotto.contains(bonusNumber)) {
            throw new IllegalArgumentException(Messages.LOTTO_BONUS_DUPLICATE_MESSAGE);
        }
    }


}
