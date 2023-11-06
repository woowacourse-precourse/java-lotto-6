package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.utils.DuplicateException;
import lotto.utils.ErrorMessage;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Lotto {
    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = 45;
    private static final int SIZE = 6;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public static Lotto createLotto() {
        List<Integer> pickedNumbers = Randoms.pickUniqueNumbersInRange(MIN_VALUE, MAX_VALUE, SIZE);
        uniqueValidate(pickedNumbers);

        //todo: 다른 식으로 구현할 수 있을까? -> 너무 레거시스러움
        Collections.sort(pickedNumbers, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });

        return new Lotto(pickedNumbers);
    }

    public String getLottoNumbers() {
        return numbers.toString();
    }

    private static void uniqueValidate(List<Integer> pickedNumbers) {
        boolean[] alreadyChecked = new boolean[MAX_VALUE + 1];

        for (int number : pickedNumbers) {
            if (alreadyChecked[number]) {
                throw new DuplicateException(ErrorMessage.DUPLICATED_VALUES.getErrorMessage());
            }

            alreadyChecked[number] = true;
        }
    }
}
