package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    public static final int LOTTO_SIZE = 6;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        checkSizeOfLotto(numbers);
        numbers.stream().forEach(number -> checkRangeOfLottoNumber(number));
    }

    private void checkSizeOfLotto(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>(numbers);
        if (set.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(ErrorMessage.INCORRECT_SIZE_OF_LOTTO);
        }
    }

    private static void checkRangeOfLottoNumber(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException(ErrorMessage.OUT_OF_RANGE_ERROR);
        }
    }

    public static Lotto makeRandomNumbersForLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto(numbers);
    }



}
