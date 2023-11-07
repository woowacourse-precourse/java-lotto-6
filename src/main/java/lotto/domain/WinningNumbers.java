package lotto.domain;

import lotto.util.Validator;

import java.util.List;

/**
 * 당첨 번호를 포함한 클래스.
 */
public class WinningNumbers extends Lotto {
    private final int bonusNumber;

    /**
     * WinningNumbers 객체를 생성한다.
     * @param numbers 로또 번호가 담긴 리스트. 번호의 개수는 6개여야 한다.
     *                번호에 중복이 없어야 한다. 각 번호의 범위는 1~45에 속해야 한다.
     * @param bonusNumber 보너스 번호. 번호의 범위는 1~45에 속해야 한다.
     */
    public WinningNumbers(List<Integer> numbers, int bonusNumber) {
        super(numbers);
        this.bonusNumber = bonusNumber;
        Validator.validateRangeOfBonusNumber(bonusNumber);
    }

    /**
     * 보너스 번호를 반환한다.
     * @return 보너스 번호.
     */
    public int getBonusNumber() {
        return this.bonusNumber;
    }
}
