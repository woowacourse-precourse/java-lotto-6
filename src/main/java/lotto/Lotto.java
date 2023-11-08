package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            // System.out.println("[ERROR] 로또 번호는 6개여야 합니다.");
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
        
        if (hasDuplicate(numbers)) {
            // System.out.println("[ERROR] 로또 번호에 중복된 숫자가 있습니다.");
            throw new IllegalArgumentException("[ERROR] 로또 번호에 중복된 숫자가 있습니다.");
        }
    }
    

    // TODO: 추가 기능 구현
    private boolean hasDuplicate(List<Integer> numbers) {
        return numbers.stream().distinct().count() != numbers.size();
    }

    public List<Integer> getLottoNumbers() {
        return numbers;
    }
}
