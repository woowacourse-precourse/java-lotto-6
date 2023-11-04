package lotto.model;

import lotto.utils.Util;
import java.util.List;

public class WinningNumber {

    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private Lotto winningNumber;
    private int bonusNumber;

    private WinningNumber(Lotto winningNumber, int bonusNumber) {
        this.winningNumber = winningNumber;
        this.bonusNumber = bonusNumber;
    }

    public static WinningNumber from(String[] inputNumbers, int bonusNumber) {
        List<Integer> numbers = Util.stringToIntegerList(inputNumbers);
        Lotto winningNumber = new Lotto(numbers);
        validateDuplicatedNumber(winningNumber, bonusNumber);
        validateNumberRange(bonusNumber);
        return new WinningNumber(winningNumber, bonusNumber);
    }

    private static void validateDuplicatedNumber(Lotto winningNumber, int bonusNumber) {
        if (winningNumber.hasNumber(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }

    private static void validateNumberRange(int number) {
        if (number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException("[ERROR] 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    public Lotto getWinningNumber() {
        return winningNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
