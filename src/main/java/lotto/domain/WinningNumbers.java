package lotto.domain;

import lotto.GameUtils;
import org.junit.platform.commons.util.StringUtils;

import java.util.List;

public class WinningNumbers {
    private static final String WINNING_LOTTO_DELIMITER = ",";
    public static final String WINNING_LOTTO_NOT_NUMBER_EXCEPTION = "당첨 번호는 숫자여야 합니다. (번호는 " + WINNING_LOTTO_DELIMITER + "를 기준으로 구분)";
    public static final String BONUS_LOTTO_NOT_NUMBER_EXCEPTION = "보너스 번호는 숫자여야 합니다.";
    public static final String BONUS_NUMBER_RANGE_INVALID_EXCEPTION = "보너스 번호는 " + Lotto.LOTTO_RANGE_MIN + "부터 " + Lotto.LOTTO_RANGE_MAX + " 사이의 숫자여야 합니다.";
    public static final String BONUS_NUMBER_DUPLICATE_EXCEPTION = "보너스 번호는 당첨 번호와 중복되면 안됩니다.";
    private Lotto winningLotto;
    private int bonusNumber;

    public void initWinningLotto(String input) {
        validateNotBlank(input);
        List<String> rawNumbers = GameUtils.splitStringByDelimiter(input, WINNING_LOTTO_DELIMITER);
        rawNumbers.forEach(this::validateNumberWinningLotto);
        List<Integer> numbers = rawNumbers.stream()
                .map(GameUtils::convertToNumber)
                .toList();
        this.winningLotto = GameUtils.createManualLotto(numbers);
    }

    public void initBonusNumber(String input) {
        validateNumberBonusNumber(input);
        int number = GameUtils.convertToNumber(input);
        validateRange(number);
        validateDuplicate(number);
        this.bonusNumber = number;
    }

    public int getMatchNumber(Lotto lotto) {
        return winningLotto.getMatchNumber(lotto);
    }

    public boolean hasBonusNumber(Lotto lotto) {
        return lotto.hasNumber(bonusNumber);
    }

    private void validateNotBlank(String input) {
        if (StringUtils.isBlank(input)) {
            throw new IllegalArgumentException(WINNING_LOTTO_NOT_NUMBER_EXCEPTION);
        }
    }

    private void validateNumberWinningLotto(String input) {
        if (GameUtils.isNotNumber(input)) {
            throw new IllegalArgumentException(WINNING_LOTTO_NOT_NUMBER_EXCEPTION);
        }
    }

    private void validateNumberBonusNumber(String input) {
        if (GameUtils.isNotNumber(input)) {
            throw new IllegalArgumentException(BONUS_LOTTO_NOT_NUMBER_EXCEPTION);
        }
    }

    private void validateRange(int number) {
        if (number < Lotto.LOTTO_RANGE_MIN || Lotto.LOTTO_RANGE_MAX < number) {
            throw new IllegalArgumentException(BONUS_NUMBER_RANGE_INVALID_EXCEPTION);
        }
    }

    private void validateDuplicate(int number) {
        if (winningLotto.hasNumber(number)) {
            throw new IllegalArgumentException(BONUS_NUMBER_DUPLICATE_EXCEPTION);
        }
    }
}
