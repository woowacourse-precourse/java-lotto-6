package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    // 로또 생성자 : 3개의 validation 거침
    public Lotto(List<Integer> numbers) { // 함수 받기전에 Int만 주도록 하였음
        validate(numbers);                // 6개여야 함
        validate_range(numbers);          // 1~45사이 수여야 함
        validate_duplicate(numbers);      // 중복 수가 없어야 함
        this.numbers = numbers;
    }

    // private field getter
    public List<Integer> getNumbers() {
        return numbers;
    }

    // 6개의 수 validate
    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            System.out.print("[ERROR] 로또 번호는 6개의 정수여야 합니다.\n");
            throw new IllegalArgumentException();
        }
    }

    // 1~45 수 validate
    // validate_range에 range_check 사용
    private void validate_range(List<Integer> numbers) {
        for (Integer num : numbers) {
            range_check(num);
        }
    }

    public static void range_check(int num) {
        if (num < 1 || num > 45) {
            System.out.print("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.\n");
            throw new IllegalArgumentException();
        }
    }

    // 중복 숫자가 있는지 validate
    private void validate_duplicate(List<Integer> numbers) {
        Set<Integer> numSet = new HashSet<>(numbers);
        if (numSet.size() != numbers.size()) {
            System.out.print("[ERROR] 로또 번호에 중복 값이 없어야 합니다.\n");
            throw new IllegalArgumentException();
        }
    }
}
