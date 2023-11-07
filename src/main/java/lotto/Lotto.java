package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = new ArrayList<>(numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
        for (int number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1 부터 45 사이여야 합니다.");
            }
        }
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복되지 않아야 합니다.");
        }
    }

    public List<Integer> getNumbersInAscendingOrder() {
        List<Integer> sortedNumbers = new ArrayList<>(numbers);
        Collections.sort(sortedNumbers);
        return sortedNumbers;
    }

    public boolean containsNumber(int number) {
        for (int lottoNumber : numbers) {
            if (lottoNumber == number) {
                return true;
            }
        }
        return false;
    }
}