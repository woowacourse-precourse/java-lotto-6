package lotto.validator;

import java.util.List;
import java.util.stream.IntStream;

public class LottoValidator{

    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int LOTTO_SIZE = 6;

    public static void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicate(numbers);
        validateRange(numbers);
        validateSort(numbers);
    }

    private static void validateSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("[ERROR] 로또는 반드시 6개 숫자를 가져야 합니다.");
        }
    }

    private static void validateDuplicate(List<Integer> numbers){
        long duplicateCount = numbers.stream()
                .distinct()
                .count();
       if (duplicateCount != LOTTO_SIZE) {
           throw new IllegalArgumentException("[ERROR] 로또 번호에 중복 숫자가 존재합니다.");
       }
    }
    private static void validateRange(List<Integer> numbers) {
        numbers.stream()
                .forEach(number -> validateRangeHelper(number));
    }

    private static void validateRangeHelper(int number) {
        if (number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER){
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1 ~ 45 사이여야 합니다.");
        }
    }

    private static void validateSort(List<Integer> numbers) {
        boolean IsSort = IntStream.range(0, LOTTO_SIZE)
                .allMatch(i -> numbers.get(i) < numbers.get(i + 1));
        if (!IsSort) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 오름 차순으로 정렬되어야 합니다.");
        }
    }
}
