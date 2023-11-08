package lotto.engine.domain;

import static lotto.engine.LottoSystemConstant.LOTTO_NUMBER_LENGTH;
import static lotto.engine.LottoSystemConstant.LOTTO_NUMBER_MAXIMUM_VALUE;
import static lotto.engine.LottoSystemConstant.LOTTO_NUMBER_MINIMUM_VALUE;
import static lotto.engine.LottoSystemConstant.TextMessage.ERROR_PREFIX;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    public Customer(List<Integer> winningNumbers, int bonusNumber) {
        valid(winningNumbers, bonusNumber);
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    int getBonusNumber() {
        return bonusNumber;
    }

    private void valid(List<Integer> winningNumbers, int bonusNumber) {
        validWinningNumbers(winningNumbers);
        validBonusNumber(bonusNumber);

        validNotDuplicateNumber(winningNumbers, bonusNumber);
    }

    private void validNotDuplicateNumber(List<Integer> winningNumbers, int bonusNumber) {
        List<Integer> totals=new ArrayList<>(winningNumbers);
        totals.add(bonusNumber);

        int count =(int) totals.stream().distinct()
                .count();

        boolean isExistDuplicateNumber = count <= LOTTO_NUMBER_LENGTH.value();
        if(isExistDuplicateNumber){
            throw new IllegalArgumentException(ERROR_PREFIX.getMessage()+"보너스 넘버가 당첨번호와 중복됩니다.");
        }
    }

    private void validWinningNumbers(List<Integer> winningNumbers) {
        long count = winningNumbers.stream().distinct().count();
        if (count != LOTTO_NUMBER_LENGTH.value()) {
            throw new IllegalArgumentException(ERROR_PREFIX.getMessage() + "유효하지 않는 번호로 이루어져 있습니다.");
        }
    }

    private void validBonusNumber(int bonusNumber) {
        if (bonusNumber < LOTTO_NUMBER_MINIMUM_VALUE.value() && bonusNumber > LOTTO_NUMBER_MAXIMUM_VALUE.value()) {
            throw new IllegalArgumentException(ERROR_PREFIX.getMessage() + "유효하지 않는 보너스 번호입니다.");
        }
    }

}
