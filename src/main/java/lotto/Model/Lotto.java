package lotto.Model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) throws IllegalArgumentException {
        size_check(numbers);
        duplication_check(numbers);
        number_check(numbers);

        this.numbers = numbers;
    }

    private void size_check(List<Integer> numbers) {
        if (numbers.size() != 6) {
            System.out.println("[ERROR] 로또 번호는 6개의 수를 입력해주세요.");
            throw new IllegalArgumentException();
        }

    }

    private void number_check(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < 1 || number > 45) {
                System.out.println("[ERROR] 로또 번호 1부터 45까지의 수로 입력해주세요.");
                throw new IllegalArgumentException();
            }
        }

    }

    private void duplication_check(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>(numbers);
        if (set.size() != 6) {
            System.out.println("[ERROR] 로또 수는 중복 없이 입력해주세요.");
            throw new IllegalArgumentException();
        }
    }

}
