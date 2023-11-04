package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import static lotto.domain.constants.LottoConstraint.LOTTO_PICK_COUNT;

public class RandomNumberGenerator {
    private static final int LOTTO_NUMBER_LOWER_BOUND = 1;
    private static final int LOTTO_NUMBER_UPPER_BOUND = 45;

    private RandomNumberGenerator() {
    }

    public static List<Integer> generateLottoNumbers() {
        Set<Integer> pickedNumbers = new TreeSet<>();
        while (LOTTO_PICK_COUNT.isSmaller(pickedNumbers.size())) {
            int randomNumber = RandomNumberGenerator.generateLottoNumber();
            pickedNumbers.add(randomNumber);
        }
        return pickedNumbers.stream().toList();
    }

    private static int generateLottoNumber() {
        return Randoms.pickNumberInRange(
                LOTTO_NUMBER_LOWER_BOUND, LOTTO_NUMBER_UPPER_BOUND);
    }
}
