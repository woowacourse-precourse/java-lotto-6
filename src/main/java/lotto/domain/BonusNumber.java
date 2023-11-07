package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.constant.ExceptionConstant;
import lotto.constant.NumberConstant;

public class BonusNumber {

    private final int number;

    private BonusNumber(String bonusNumber, Lotto winningLotto) {
        validateDuplication(bonusNumber, winningLotto);
        validateNumberSize(bonusNumber);
        this.number = convertStrToInt(bonusNumber);
    }

    public static BonusNumber of(String bonusNumber, Lotto winningLotto) {
        return new BonusNumber(bonusNumber, winningLotto);
    }

    private void validateDuplication(String bonusNumber, Lotto winningLotto) {
        Set<Integer> winningLottoNumbers = new HashSet<>(winningLotto.getNumbers());
        winningLottoNumbers.add(convertStrToInt(bonusNumber));

        if (winningLottoNumbers.size() == NumberConstant.LOTTO_COUNT.getNumber()) {
            throw new IllegalArgumentException(ExceptionConstant.LOTTO_NUMBER_DUPliCATE.getMessage());
        }
    }

    private void validateNumberSize(String number) {
        int bonusNumber = convertStrToInt(number);

        if (bonusNumber < NumberConstant.LOTTO_MIN_NUMBER.getNumber()
                || NumberConstant.LOTTO_MAX_NUMBER.getNumber() < bonusNumber) {
            throw new IllegalArgumentException(ExceptionConstant.LOTTO_NUMBER_SIZE.getMessage());
        }
    }

    private int convertStrToInt(String bonusNumber) {
        return Integer.parseInt(bonusNumber);
    }

    public int getNumber() {
        return number;
    }
}
