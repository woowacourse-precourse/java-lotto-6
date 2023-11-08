package lotto.domain.lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Collections;
import java.util.List;

public class RandomNumbersGenerator {

    private static final int START_INCLUSIVE = 1;
    private static final int END_INCLUSIVE = 45;
    private static final int LOTTO_SIZE = 6;

    public List<Integer> generate() {
        try {
            List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(START_INCLUSIVE, END_INCLUSIVE, LOTTO_SIZE);
            validate(randomNumbers);
            return Collections.unmodifiableList(randomNumbers);
        } catch (IllegalArgumentException e) {
            return generate();
        }
    }

    private void validate(List<Integer> randomNumbers) {
        validateDuplicateNumber(randomNumbers);
        validateNumbersCount(randomNumbers);
    }


    private void validateDuplicateNumber(List<Integer> randomNumbers) {
        int distinctCount = getDistinctCount(randomNumbers);
        if (distinctCount != randomNumbers.size()) {
            throw new IllegalArgumentException();
        }
    }

    private int getDistinctCount(List<Integer> randomNumbers){
        return (int)randomNumbers.stream().distinct().count();
    }

    private void validateNumbersCount(List<Integer> randomNumbers) {
        if (randomNumbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException();
        }
    }
}
