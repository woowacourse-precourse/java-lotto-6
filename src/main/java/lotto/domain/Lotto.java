package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {

    private static final int LOTTO_SIZE = 6;
    private static final int LOTTO_MAX = 45;
    private static final int LOTTO_MIN = 1;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicate(numbers);
        validateRange(numbers);
        numbers = ascendingNumbers(numbers);
        this.numbers = numbers;
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("[ERROR] 로또 번호가 6개가 아닙니다.");
        }
    }

    private void validateDuplicate(List<Integer> numbers){
        Set<Integer> compareNumbers = new HashSet<>(numbers);
        if(compareNumbers.size() != numbers.size()){
            throw new IllegalArgumentException("[ERROR] 중복된 번호가 있습니다.");
        }
    }

    private void validateNumberRange(int number){
        if(!(number <= LOTTO_MAX && number >= LOTTO_MIN)){
            throw new IllegalArgumentException("[ERROR] 숫자 범위는 1~45까지 입니다.");
        }
    }

    private void validateRange(List<Integer> numbers){
        numbers.forEach(this::validateNumberRange);
    }

    private List<Integer> ascendingNumbers(List<Integer> numbers){
        return numbers.stream()
                .sorted()
                .toList();
    }

    public boolean contains(int number) {
        return numbers.contains(number);
    }

    public int getMatchCount(WinningNumberLotto winningNumberLotto){
        return (int) numbers.stream()
                .filter(winningNumberLotto::isContain)
                .count();
    }
}
