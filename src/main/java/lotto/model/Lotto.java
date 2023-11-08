package lotto.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;
    private Integer correctLottoCnt = 0;
    private boolean isBonus = false;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplicated(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개 이어야 합니다.");
        }
    }

    private void validateDuplicated(List<Integer> numbers){
        Set<Integer> set = new HashSet<>(numbers);
        if (set.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복될 수 없습니다.");
        }
    }

    public List<Integer> getNumbers(){
        return numbers;
    }

    public void updateCorrectLottoCnt() {
        correctLottoCnt += 1;
    }

    public void updateBonus() {
        isBonus = true;
    }

    public Integer getCorrectLottoCnt() {
        return correctLottoCnt;
    }

    public boolean isBonus() {
        return isBonus;
    }
}
