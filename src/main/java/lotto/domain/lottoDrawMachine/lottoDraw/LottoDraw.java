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
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6자리 입니다.");
        }

        if (hasDuplicates(winningNumber)) {
            throw new IllegalArgumentException("[ERROR] 중복값이 없어야 합니다.");
        }

        if (isNumbersOutOfRange(winningNumber)) {
            throw new IllegalArgumentException("[ERROR] 1~45 숫자만 입력 해주세요.");
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
            throw new IllegalArgumentException("[ERROR] 보너스번호는 비어 있을 수 없습니다.");
        }

        if(this.winningNumber.contains(bonusNumber)){
            throw new IllegalArgumentException("[ERROR] 중복값이 없어야 합니다.");
        }

        if( bonusNumber < LottoConstants.MIN_NUMBER_OF_LOTTO.getValue()
                || bonusNumber > LottoConstants.MAX_NUMBER_OF_LOTTO.getValue()){
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1~45 숫자만 입력 해주세요.");
        }
    }

    public List<Integer> getWinningNumber() {
        return winningNumber;
    }

    public Integer getBonusNumber() {
        return bonusNumber;
    }
}
