package lotto.service;

import lotto.constants.ErrorMessage;
import lotto.constants.Value;
import lotto.domain.Lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ValidationService {

    public void amountValidation(int amount) {
        if (amount < Value.LOTTO_TICKET_PRICE) {
            throw new IllegalArgumentException(ErrorMessage.AMOUNT_INVALID.getMessage());
        }

        if (amount % Value.LOTTO_TICKET_PRICE != 0) {
            throw new IllegalArgumentException(ErrorMessage.AMOUNT_UNIT.getMessage());
        }
    }

    public void winningLottoNumberValidation(Lotto winningLotto) {
        if (winningLotto.getNumbers().size() < Value.LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException();
        }

        for (int number : winningLotto.getNumbers()) {
            if (number < Value.LOTTO_START_NUMBER || number > Value.LOTTO_END_NUMBER) {
                throw new IllegalArgumentException();
            }
        }

        Set<Integer> lottoNumbers = new HashSet<>(winningLotto.getNumbers());
        if (lottoNumbers.size() != winningLotto.getNumbers().size()) {
            throw new IllegalArgumentException();
        }
    }

    public void bonusNumberValidation(int bonusNumber, Lotto winningLotto) {

        if (bonusNumber < Value.LOTTO_START_NUMBER || bonusNumber > Value.LOTTO_END_NUMBER) {
            throw new IllegalArgumentException();
        }


        List<Integer> winningNumber = winningLotto.getNumbers();

        for (int number : winningNumber) {
            if (bonusNumber == number) {
                throw new IllegalArgumentException();
            }
        }
    }
}
