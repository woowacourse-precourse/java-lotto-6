package lotto.engine.domain;

import static lotto.engine.LottoSystemConstant.LOTTO_NUMBER_LENGTH;
import static lotto.engine.LottoSystemConstant.LOTTO_NUMBER_MAXIMUM_VALUE;
import static lotto.engine.LottoSystemConstant.LOTTO_NUMBER_MINIMUM_VALUE;

import java.util.List;
import lotto.engine.LottoSystemConstant.TextMessage;

public class Customer {
    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    public Customer(List<Integer> winningNumbers, int bonusNumber) {
        validWinningNumbers(winningNumbers);
        validBonusNumber(bonusNumber);

        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    int getBonusNumber() {
        return bonusNumber;
    }

    private void validWinningNumbers(List<Integer> winningNumbers) {
        long count = winningNumbers.stream().distinct()
                .count();
        if (count != LOTTO_NUMBER_LENGTH.value()) {
            throw new IllegalArgumentException(TextMessage.ERROR_PREFIX.getMessage() + "유효하지 않는 번호입니다.");
        }
    }

    private void validBonusNumber(int bonusNumber) {
        if (bonusNumber < LOTTO_NUMBER_MINIMUM_VALUE.value() && bonusNumber > LOTTO_NUMBER_MAXIMUM_VALUE.value()) {
            throw new IllegalArgumentException(TextMessage.ERROR_PREFIX.getMessage() + "유효하지 않는 보너스 번호입니다.");
        }
    }

}
