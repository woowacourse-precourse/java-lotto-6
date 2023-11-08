package lotto.domain;

import static lotto.constant.LottoConstant.*;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class LottoNumbersMaker {

    public static List<Integer> getLottoNumbers() {
        List<Integer> numbers = new ArrayList<>(
                Randoms.pickUniqueNumbersInRange(
                        LOTTO_START_NUMBER,
                        LOTTO_END_NUMBER,
                        LOTTO_NUMBER_SIZE
                )
        );

        numbers.sort(Comparator.naturalOrder());

        return numbers;
    }
}
