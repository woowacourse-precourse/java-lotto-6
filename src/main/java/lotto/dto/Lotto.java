package lotto.dto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        checkValidateCnt(numbers);
        checkValidateRange(numbers);
        checkDuplicatedNum(numbers);
        numbers = sorted(numbers);
        this.numbers = numbers;
    }

    private void checkDuplicatedNum(List<Integer> numbers) {
        Set<Integer> nonDuplicateNumbers = new HashSet<>(numbers);
        if (nonDuplicateNumbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 중복된 숫자가 존재하는 로또입니다. ");
        }
    }

    private void checkValidateRange(List<Integer> numbers) {
        for ( int num : numbers){
            if ( num < 1 || num > 45 ){
                throw new IllegalArgumentException("[ERROR] 지정된 범위에 벗어나는 숫자입니다.");
            }
        }
    }

    private void checkValidateCnt(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호 개수는 6개여야 합니다.");
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public List<Integer> sorted(List<Integer> numbers) {
        return numbers.stream().sorted().collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return numbers + "";
    }

}
