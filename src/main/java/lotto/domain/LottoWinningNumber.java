package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoWinningNumber {

    private final Lotto readWinningNumber;

    public LottoWinningNumber(String readWinningNumber) {
        validateNumber(readWinningNumber);
        this.readWinningNumber = lottoParsing(readWinningNumber);
    }

    private void validateNumber(String readWinningNumber) {
        if (!readWinningNumber.matches("([0-9]+,)*[0-9]+")) {
            throw new IllegalArgumentException("당첨 번호는 숫자와 콤마 형식이어야 합니다.");
        }
    }

    private Lotto lottoParsing(String readWinningNumber) {
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
