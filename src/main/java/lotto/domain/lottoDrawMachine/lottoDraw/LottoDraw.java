package lotto.domain.lottoDrawMachine.lottoDraw;

import lotto.constants.LottoConstants;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoDraw {
    private List<Integer> winningNumber;
    private Integer bonusNumber;

    private LottoDraw(List<Integer> winningNumber, Integer bonusNumber) {
        validate(winningNumber);
        this.winningNumber = winningNumber;

        validateBonusNumber(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public static LottoDraw of(List<Integer> winningNumber, Integer bonusNumber) {
        return new LottoDraw(winningNumber,bonusNumber);
    }

    private void validate(List<Integer> winningNumber) {
        if (winningNumber.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨번호는 ");
        }

        if (hasDuplicates(winningNumber)) {
            throw new IllegalArgumentException();
        }

        if (isNumbersOutOfRange(winningNumber)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean hasDuplicates(List<Integer> winningNumber) {
        Set<Integer> numbersSet = new HashSet<>(winningNumber);
        return numbersSet.size() != winningNumber.size();
    }

    private boolean isNumbersOutOfRange(List<Integer> winningNumber) {
        return winningNumber
                .stream()
                .anyMatch(number
                        -> number < LottoConstants.MIN_NUMBER_OF_LOTTO.getValue()
                        || number > LottoConstants.MAX_NUMBER_OF_LOTTO.getValue());
    }

    private void validateBonusNumber(Integer bonusNumber) {
        if (bonusNumber == null) {
            throw new IllegalArgumentException("[ERROR] 당첨번호는 ");
        }

        if(this.winningNumber.contains(bonusNumber)){
            throw new IllegalArgumentException("[ERROR] 당첨번호는 ");
        }

        if( bonusNumber < LottoConstants.MIN_NUMBER_OF_LOTTO.getValue()
                || bonusNumber > LottoConstants.MAX_NUMBER_OF_LOTTO.getValue()){
            throw new IllegalArgumentException("[ERROR] 당첨번호는 ");
        }
    }

    public List<Integer> getWinningNumber() {
        return winningNumber;
    }

    public Integer getBonusNumber() {
        return bonusNumber;
    }
}
