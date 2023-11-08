package lotto;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        Collections.sort(numbers);
        this.numbers = numbers;
    }

    public static void validate(List<Integer> numbers) {
        Set<Integer> setNumbers = new HashSet<>(numbers);
        if (numbers.size() != 6) {
            System.out.println("[ERROR] 로또 번호 개수는 6개어야 합니다.");
            throw new IllegalArgumentException();
        }

        for (Integer number : numbers) {
            if (number > 45 || number < 1) {
                System.out.println("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
                throw new IllegalArgumentException();
            }
        }

        if (setNumbers.size() != numbers.size()){
            throw new IllegalArgumentException();
        }
    }


    public List<Integer> getNumbers(Lotto lotto){
        return lotto.numbers;
    }
}
