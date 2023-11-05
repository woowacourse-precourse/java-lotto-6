package lotto.model;

import java.util.List;
import java.util.stream.Collectors;

public class WinningLotto {
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;

    private final Lotto winningLotto;
    private final int bonusNumber;

    private WinningLotto(Lotto winningLotto, String bonusNumber) {
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumberValidator(bonusNumber);
    }

    public static WinningLotto create(Lotto winningLotto, String bonusNumber) {
        validateNoDuplicateNumber(winningLotto.getNumbers(), bonusNumber);
        return new WinningLotto(winningLotto, bonusNumber);
    }

    public Lotto getWinningLotto() {
        return this.winningLotto;
    }

    public int getBonusNumber() {
        return this.bonusNumber;
    }

    private static void validateNoDuplicateNumber(List<Integer> numbers, String bonusNumberStr) {
        List<String> numbersStr = numbers.stream().map(number -> String.valueOf(number)).collect(Collectors.toList());
        if (numbersStr.contains(bonusNumberStr)) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호와 보너스 번호는 중복될 수 없습니다.");
        }
    }

    private int bonusNumberValidator(String bonusNumberStr) {
        validateEmpty(bonusNumberStr);
        int bonusNumber = validateNotNumber(bonusNumberStr);
        validateInvalidLottoNumberRange(bonusNumber);
        return bonusNumber;
    }

    private void validateEmpty(String bonusNumberStr) {
        if (bonusNumberStr.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호를 입력해 주세요.");
        }
    }

    private int validateNotNumber(String bonusNumberStr) {
        try {
            return Integer.parseInt(bonusNumberStr);
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 숫자여야 합니다.");
        }
    }

    private void validateInvalidLottoNumberRange(int bonusNumber) {
        if (bonusNumber < MIN_LOTTO_NUMBER || bonusNumber > MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1~45 사이의 수여야 합니다.");
        }
    }
}
