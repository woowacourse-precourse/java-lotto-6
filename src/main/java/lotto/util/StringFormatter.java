package lotto.util;

import lotto.domain.Lotto;

import java.util.List;

public class StringFormatter {

    private static final String LOTTO_FORMAT = "[%s]";
    private static final String DELIMITER = ", ";

    public String makeLottoLine(Lotto lotto) {
        String line = makeLine(lotto);
        return String.format(LOTTO_FORMAT, line);
    }

    private String makeLine(Lotto lotto) {
        List<String> temp = lotto.getNumbers().stream()
                .map(String::valueOf)
                .toList();
        return String.join(DELIMITER, temp);
    }
}
