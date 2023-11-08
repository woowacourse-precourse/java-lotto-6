package lotto.dto.request;

import static lotto.common.ErrorMessages.INVALID_WINNING_NUMBER_MESSAGE;
import static lotto.common.ErrorMessages.NULL_OR_EMPTY;
import static org.junit.platform.commons.util.StringUtils.isBlank;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.exception.InputValidationException;

public class LottoRequest {
    public static final String DELIMITER = ",";
    public static final String LOTTO_NUMBER_PATTERN = "^[0-9,]+$";

    private List<Integer> lotto;

    public LottoRequest(String lottoNumbersString) {
        validateLottoNumberString(lottoNumbersString);
        this.lotto = createLotto(lottoNumbersString);
    }

    private void validateLottoNumberString(String lottoNumbersString) {
        if (isBlank(lottoNumbersString)) {
            throw new InputValidationException(NULL_OR_EMPTY);
        }

        if (!lottoNumbersString.matches(LOTTO_NUMBER_PATTERN)) {
            throw new InputValidationException(INVALID_WINNING_NUMBER_MESSAGE);
        }
    }

    public List<Integer> getLotto() {
        return lotto;
    }

    public List<Integer> createLotto(String lottoNumbersString) {
        return Arrays.stream(lottoNumbersString.split(DELIMITER))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public boolean contains(int lottoNumber) {
        return lotto.contains(lottoNumber);
    }
}
