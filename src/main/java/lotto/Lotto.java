package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }
    
    private void validate(List<Integer> numbers) {
        if (numbers.size() != Constants.LOTTONUMBER) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
    public List<Integer> getNumbers() {
        return this.numbers;
    }
    
    public Integer checkScore(Lotto numbers, Integer bonusNumber) {
        long count = this.numbers.stream()
                .filter(numbers.numbers::contains)
                .count();
        if (this.numbers.contains(bonusNumber)){
            count += 1;
        }
        return Math.toIntExact(count);
    }
}
