package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import camp.nextstep.edu.missionutils.Randoms;

public enum LottoNumberGenerator {
    INSTANCE;
    public static final int START_NUMBER = 1;
    public static final int END_NUMBER = 45;
    public static final int COUNT = 6;

    public static List<Integer> generateLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(START_NUMBER, END_NUMBER, COUNT)
                .stream()
                .sorted()
                .collect(Collectors.toList());
    }
}
