package lotto.utils.generator;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.domain.LottoNumbers;

public class LottoGenerator {
    public static final int START_INCLUSIVE = 1;
    public static final int END_INCLUSIVE = 45;
    public static final int LOTTO_COUNT = 6;
    public static final String LOTTO_NUMBERS_DELIMITER = ",";

    public static Lotto generate() {
        return new Lotto(new LottoNumbers(generateNumbers()));
    }

    private static String generateNumbers() {
        return Randoms.pickUniqueNumbersInRange(START_INCLUSIVE, END_INCLUSIVE, LOTTO_COUNT).stream()
                .map(String::valueOf)
                .collect(Collectors.joining(LOTTO_NUMBERS_DELIMITER));
    }
}
