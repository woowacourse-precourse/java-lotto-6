package lotto;

import java.util.List;
import java.util.Collections;
import java.util.ArrayList;
import java.util.HashSet;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            System.out.print("[ERROR] 로또 번호의 개수가 모자랍니다.");
            throw new IllegalArgumentException();
        }

        for (int number : numbers) {
            if (number < 1 || number > 45) {
                System.out.print("[ERROR] 로또 번호는 1에서 45 사이의 숫자여야 합니다.");
                throw new IllegalArgumentException();
            }
        }

        if (new HashSet<>(numbers).size() != 6) {
            System.out.print("[ERROR] 로또 번호에 중복된 숫자가 있습니다.");
            throw new IllegalArgumentException();
        }
    }
    public List<Integer> getNumbers() {
        List<Integer> sortedNumbers = new ArrayList<>(numbers);
        Collections.sort(sortedNumbers);
        return sortedNumbers;
    }
}
