package lotto.validator;

import java.util.List;
import java.util.stream.IntStream;

public class LottoValidator{

    private static final int LOTTO_SIZE = 6;

    public static void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicate(numbers);
        validateSort(numbers);
    }

    private static void validateSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("[ERROR] 로또는 반드시 6개 숫자를 가져야 합니다.");
        }
    }

    private static void validateDuplicate(List<Integer> numbers){
       if (numbers.stream().count() != LOTTO_SIZE) {
           throw new IllegalArgumentException("[ERROR] 로또 번호에 중복 숫자가 존재합니다.");
       }
    }
    private static void validateContainsComma(List<Integer> numbers) {

    }

    private static void validateSort(List<Integer> numbers) {
        boolean IsSort = IntStream.range(0, LOTTO_SIZE)
                .allMatch(i -> numbers.get(i) < numbers.get(i + 1));
        if (!IsSort) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 오름 차순으로 정렬되어야 합니다.");
        }
    }
}
