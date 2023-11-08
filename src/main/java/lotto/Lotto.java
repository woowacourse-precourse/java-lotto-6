package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    @Override
    public String toString() {
        return this.numbers.toString();
    }

    private void validate(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 서로 달라야 합니다.");
        }
        if(uniqueNumbers.size() != 6 ){
            throw new IllegalArgumentException(("[ERROR] 로또 번호는 6개를 입력하셔야 합니다."));
        }
    }

    // TODO: 추가 기능 구현
    public int countMatchingNumbers(Lotto winningLotto, int bonusNumber) {
        int weight = (int) winningLotto.numbers.stream().filter(this.numbers::contains).count() * 2;
        if (weight >= 10 && this.numbers.contains(bonusNumber)) {
            weight++;
        }
        return weight;
    }

}
