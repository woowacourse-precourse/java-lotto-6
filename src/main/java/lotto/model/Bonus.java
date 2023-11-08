package lotto.model;

import lotto.config.LottoConstants;
import lotto.view.Messages;

import java.util.List;

public class Bonus {

    private final int number;


    public Bonus(String number, List<Integer> winningLotto) {
        validate(number, winningLotto);
        this.number = Integer.parseInt(number);
    }

    private void validate(String number, List<Integer> winningLotto) {
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
