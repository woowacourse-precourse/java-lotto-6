package lotto.util;

import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoNumber;

import java.util.StringJoiner;

public class OutputUtil {

    private OutputUtil() {

    }

    public static String lottoFormat(Lotto lotto) {
        StringJoiner joiner = new StringJoiner(", ", "[", "]");
        lotto.getLottoNumbers()
                .forEach(lottoNumber -> joinNumber(joiner, lottoNumber));
        return joiner.toString();
    }

    private static void joinNumber(StringJoiner joiner, LottoNumber lottoNumber) {
        joiner.add(String.valueOf(lottoNumber.getLottoNumber()));
    }
}
