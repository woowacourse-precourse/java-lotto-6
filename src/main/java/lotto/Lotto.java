package lotto;


import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

import java.util.HashSet;
import java.util.List;

public class Lotto {
    /**
     * Implementing Restrictions numbers should remain private Can't add *instance* variable
     */
    private static int LOTTO_NUM_MIN = 1;
    private static int LOTTO_NUM_MAX = 45;
    private static int LOTTO_NUM_IN_A_TICKET = 6;

    private static long LOTTO_PRICE = 1000;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또는 " + LOTTO_NUM_IN_A_TICKET + " 자리입니다.");
        }
        if (new HashSet<Integer>(numbers).size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또에 중복되는 숫자가 사용되었습니다.");
        }
        int numberOfValidElements =
                (int)numbers.stream()
                        .filter(n -> n <= LOTTO_NUM_MAX && n >= LOTTO_NUM_MIN)
                        .count();
        if (numberOfValidElements != 6) {
            throw new IllegalArgumentException("[ERROR] 로또에 유효하지 않은 숫자가 사용되었습니다.");
        }
    }

    public static List<Integer> generateLottoNumbers() {
        return pickUniqueNumbersInRange(LOTTO_NUM_MIN, LOTTO_NUM_MAX, LOTTO_NUM_IN_A_TICKET);
    }

    public int countMatchingNumbers(List<Integer> targetNumbers) {
        return (int)numbers.stream()
                .filter(new HashSet<>(targetNumbers)::contains)
                .count();
    }
    public boolean numbersContain(Integer targetNumber) {
        return numbers.contains(targetNumber);
    }

    public static long getPrice() {
        return LOTTO_PRICE;
    }
}
