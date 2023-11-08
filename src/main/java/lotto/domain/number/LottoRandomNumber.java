package lotto.domain.number;

import static camp.nextstep.edu.missionutils.Randoms.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoRandomNumber {

    public static final int START_RANGE = 1;
    public static final int LIMIT_RANGE = 45;
    public static final int LOTTO_SIZE = 6;

    public List<Integer> getLottoRandomNumbers() {
        var result = pickUniqueNumbersInRange(START_RANGE, LIMIT_RANGE, LOTTO_SIZE);
        return result.stream().sorted().collect(Collectors.toList());
    }
}