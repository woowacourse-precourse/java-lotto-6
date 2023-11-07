package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.view.ExceptionMessage.NUMBER_AND_COMMA_FORMAT_EXCEPTION;

public class LottoWinningNumber {

    private final Lotto readWinningNumber;

    public LottoWinningNumber(String readWinningNumber) {
        validateNumberAndCommaFormat(readWinningNumber);
        this.readWinningNumber = convertStringToLottoFormat(readWinningNumber);
    }

    private void validateNumberAndCommaFormat(String readWinningNumber) {
        if (!readWinningNumber.matches("([0-9]+,)*[0-9]+")) {
            throw new IllegalArgumentException(NUMBER_AND_COMMA_FORMAT_EXCEPTION.getMessage());
        }
    }

    private Lotto convertStringToLottoFormat(String readWinningNumber) {
        List<Integer> lottoNumber = Arrays.stream(readWinningNumber.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        return new Lotto(lottoNumber);
    }

    public Lotto getReadWinningNumber() {
        return this.readWinningNumber;
    }
}
