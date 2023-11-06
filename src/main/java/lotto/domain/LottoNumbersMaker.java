package lotto.domain;

import static lotto.constant.LottoConstant.*;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoNumbersMaker {

    public static List<Integer> getLottoNumbers() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(LOTTO_START_NUMBER, LOTTO_END_NUMBER, LOTTO_NUMBER_SIZE);

        while (validateDuplicateNumbers(numbers)) {
            numbers = Randoms.pickUniqueNumbersInRange(LOTTO_START_NUMBER, LOTTO_END_NUMBER, LOTTO_NUMBER_SIZE);
        }

        Collections.sort(numbers);

        return numbers;
    }

    private static boolean validateDuplicateNumbers(List<Integer> numbers) {

        Set<Integer> notDuplicateNumber = new HashSet<>(numbers);

        if (notDuplicateNumber.size() != numbers.size()) {
            return true;
        }

        return false;
    }
}
