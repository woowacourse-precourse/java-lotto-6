package lotto.domain;

import lotto.GameUtils;
import org.junit.platform.commons.util.StringUtils;

import java.util.List;

public class AllWinningNumbers {
    private static final String WINNING_LOTTO_DELIMITER = ",";
    public static final String WINNING_LOTTO_NOT_NUMBER_EXCEPTION = "당첨 번호는 숫자여야 합니다. (번호는 " + WINNING_LOTTO_DELIMITER + "를 기준으로 구분)";
    private Lotto winningLotto;

    public void initWinningLotto(String input) {
        validateNotNullNeitherEmpty(input);
        List<String> rawNumbers = GameUtils.splitStringByDelimiter(input, WINNING_LOTTO_DELIMITER);
        rawNumbers.forEach(this::validateNumber);
        List<Integer> numbers = rawNumbers.stream()
                .map(GameUtils::convertStringToInt)
                .toList();
        this.winningLotto = GameUtils.createManualLotto(numbers);
    }

    private void validateNotNullNeitherEmpty(String input) {
        if (StringUtils.isBlank(input)) {
            throw new IllegalArgumentException(WINNING_LOTTO_NOT_NUMBER_EXCEPTION);
        }
    }

    private void validateNumber(String input) {
        if (GameUtils.isNotNumber(input)) {
            throw new IllegalArgumentException(WINNING_LOTTO_NOT_NUMBER_EXCEPTION);
        }
    }
}
