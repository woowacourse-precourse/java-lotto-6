package lotto.domain.lottery.generator;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import static lotto.domain.constants.LottoConstraint.*;

public class RandomNumberGenerator {
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
                NUMBER_LOWER_BOUND.getValue(), NUMBER_UPPER_BOUND.getValue()
        );
    }
}
