package lotto.model;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 입력하신 로또 번호의 개수가 올바르지 않습니다. 정확히 6개의 숫자를 입력해야 합니다.");
        }
        for (Integer number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("[ERROR] 입력하신 로또 번호 중 올바르지 않은 범위의 숫자가 포함되어 있습니다. 로또 번호는 1부터 45 사이의 값이어야 합니다.");
            }
        }
        if (hasDuplicates(numbers)) {
            throw new IllegalArgumentException( "[ERROR] 로또 번호 중 중복이 포함되어 있습니다. 모든 로또 번호는 고유해야 합니다.");
        }
    }

    private boolean hasDuplicates(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        return uniqueNumbers.size() != numbers.size();
    }

    public boolean containsNumber(int number) {
        return numbers.contains(number);
    }

    public int matchCount(Lotto otherLotto) {
        return (int) this.numbers.stream().filter(otherLotto::containsNumber).count();
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }


}
