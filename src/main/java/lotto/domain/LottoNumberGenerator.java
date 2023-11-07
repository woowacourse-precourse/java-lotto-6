package lotto.domain;

import static lotto.constant.NumberConstant.COUNT;
import static lotto.constant.NumberConstant.END_NUMBER;
import static lotto.constant.NumberConstant.START_NUMBER;

import java.util.List;
import java.util.stream.Collectors;
import camp.nextstep.edu.missionutils.Randoms;

public enum LottoNumberGenerator {
    INSTANCE;

    public static List<Integer> generateLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(START_NUMBER.getValue(), END_NUMBER.getValue(), COUNT.getValue())
                .stream()
                .sorted()
                .collect(Collectors.toList());
    }
}
