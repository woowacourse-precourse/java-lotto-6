package domain;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
        Collections.sort(this.numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6 || numbers == null || !numbers.stream().allMatch(num -> num >=1 && num <=45)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 6개의 숫자여야 합니다.");
        }

        long uniqueNumbers = numbers.stream().distinct().count();
        if (uniqueNumbers != 6){
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복될 수 없습니다.")
        }
    }

    // 로또 객체가 당첨 번호와 몇 개의 숫자가 일치하는지 확인
    public int countMatchingNumbers(List<Integer> winningNumbers){
        return (int) numbers.stream().filter(winningNumbers::contains).count();
    }

    public List<Integer> getNumbers(){
        return numbers;
    }
}
