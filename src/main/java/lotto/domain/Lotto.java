package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        checkDuplicate(numbers);
        validateLottoNumbers(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호가 6개가 아닙니다.");
        }

    }
    private void checkDuplicate(List<Integer> numbers){
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호에 중복된 숫자가 있습니다.");
        }
    }

    public void validateLottoNumbers(List<Integer> numbers){
        if (numbers.stream().anyMatch(number-> number <0 || number>45)){
            throw new IllegalArgumentException("[ERROR] 1~45 사이의 번호만 가능합니다.");
        }
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

    public int length(){
        return numbers.size();
    }

    public int get(int i){
        return numbers.get(i);
    }

    public boolean contains(int i) {
        return numbers.contains(i);
    }

}
