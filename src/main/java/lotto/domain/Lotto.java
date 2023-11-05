package lotto.domain;

import static lotto.common.ErrorMessages.DUPLICATE_NUMBERS_MESSAGE;
import static lotto.common.ErrorMessages.INVALID_NUMBERS_COUNT_MESSAGE;
import static lotto.common.ErrorMessages.INVALID_WINNING_NUMBER_MESSAGE;
import static lotto.common.ErrorMessages.NULL_OR_EMPTY;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import lotto.exception.InputValidationException;
import org.junit.platform.commons.util.StringUtils;

public class Lotto {
    private final List<LottoNumber> lottoNumbers;

    public static Lotto createLotto(List<Integer> numbers) {
        return new Lotto(numbers.stream().map(LottoNumber::new).collect(Collectors.toList()));
    }

    public Lotto(List<LottoNumber> lottoNumbers) {
        validateNumbers(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    public static Lotto createLotto(String winningNumbers) {
        validateWinningNumbers(winningNumbers);

        return new Lotto(Arrays.stream(winningNumbers.split(","))
                .map(LottoNumber::createLottoNumber)
                .collect(Collectors.toList()));
    }

    private static void validateWinningNumbers(String winningNumbers) {
        if (StringUtils.isBlank(winningNumbers)) {
            throw new InputValidationException(NULL_OR_EMPTY);
        }

        if (!winningNumbers.matches("^[0-9,]+$")) {
            throw new InputValidationException(INVALID_WINNING_NUMBER_MESSAGE);
        }
    }

    private void validateNumbers(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != 6) {
            throw new InputValidationException(INVALID_NUMBERS_COUNT_MESSAGE);
        }

        if (lottoNumbers.stream().distinct().count() != lottoNumbers.size()) {
            throw new InputValidationException(DUPLICATE_NUMBERS_MESSAGE);
        }
    }

    public List<LottoNumber> getNumbers() {
        return Collections.unmodifiableList(lottoNumbers);
    }

    public int getCountingMatchingNumbers(Lotto lotto) {
        int count = 0;
        for (int i = 0; i < lottoNumbers.size(); i++) {
            if (containsNumber(lotto.getNumbers().get(i))) {
                count++;
            }
        }
        return count;
    }

    public boolean containsNumber(LottoNumber lottoNumber) {
        return lottoNumbers.contains(lottoNumber);
    }
}
