package lotto.domain;

import java.util.*;

import static lotto.utils.Constants.*;

// 이미 로또 객체 있으므로 매서드명은 부가적이기만 하면 됨.(validate처럼)
public class Lotto {
    private static final String DUPLICATE_NUMBER_ERROR = ERROR_PREFIX + "로또 숫자는 중복을 포함할 수 없습니다.";
    private static final String INVALID_NUMBER_COUNT_ERROR = ERROR_PREFIX + "로또 숫자 6개를 입력해 주십시오.";
    private final List<Integer> numbers;

    //로또 생성시 자동 validate 로직 수행
    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicate(numbers);
        validateRange(numbers);

        // 오름차순 정렬
        // List<Integer>는 인터페이스이기 때문에 sort()시 예외 발생 확률 있음 -> 구현체인 ArrayList<> 인스턴스 생성
        this.numbers = new ArrayList<>(numbers);
        Collections.sort(this.numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            System.out.println(INVALID_NUMBER_COUNT_ERROR);
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            System.out.println(DUPLICATE_NUMBER_ERROR);
            throw new IllegalArgumentException();
        }
    }

    private void validateRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < MIN_NUMBER || number > MAX_NUMBER) {
                System.out.println(INVALID_NUMBER_RANGE_ERROR);
                throw new IllegalArgumentException();
            }
        }
    }
}
