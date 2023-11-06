package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoNumbersMaker {

    private static final int LOTTO_START_NUM = LottoConstant.LOTTO_START_NUMBER.getValue();
    private static final int LOTTO_END_NUM = LottoConstant.LOTTO_END_NUMBER.getValue();
    private static final int LOTTO_SIZE = LottoConstant.LOTTO_NUMBER_SIZE.getValue();

    static List<Integer> getLottoNumbers() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(LOTTO_START_NUM, LOTTO_END_NUM, LOTTO_SIZE);

        while (validateDuplicateNumbers(numbers)) {
            numbers = Randoms.pickUniqueNumbersInRange(LOTTO_START_NUM, LOTTO_END_NUM, LOTTO_SIZE);
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
