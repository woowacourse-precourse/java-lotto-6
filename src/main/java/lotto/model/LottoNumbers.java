package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.stream.Collectors;
import lotto.utils.Constants;

public class LottoNumbers {

    public static List<Integer> generateRandomNum() {
        return Randoms.pickUniqueNumbersInRange(Constants.MIN_LOTTO_NUMBER, Constants.MAX_LOTTO_NUMBER, Constants.CNT_LOTTO_NUMBER)
                .stream()
                .sorted()
                .collect(Collectors.toList());
    }
}
