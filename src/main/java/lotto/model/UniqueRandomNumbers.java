package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UniqueRandomNumbers {
    private static final int UNIQUE_NUMBER = 1;
    private List<Integer> numbers;

    public UniqueRandomNumbers() {
        this.numbers = validateUnique(generator());
    }

    private List<Integer> generator() {
        return new ArrayList<>(Randoms.pickUniqueNumbersInRange(1,45,6));
    }

    private List<Integer> validateUnique(List<Integer> numbers) {
        for (int n : numbers) {
            if (Collections.frequency(numbers,n)!=UNIQUE_NUMBER){
                throw new IllegalArgumentException(ErrorMessage.OVERLAP_NUMBER.getMessage());
            }
        }
        return numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

}
