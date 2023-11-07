package lotto.exception.lotto;

import java.util.List;
import lotto.domain.LottoNumber;

public class LottoNumberSizeException extends IllegalArgumentException {

    private static final String ERROR_MESSAGE = "[ERROR] 로또 번호의 갯수는 6개로 이루어져야만 합니다. : %s";

    public LottoNumberSizeException(List<LottoNumber> numbers) {
        super(String.format(ERROR_MESSAGE, numbers));
    }
}