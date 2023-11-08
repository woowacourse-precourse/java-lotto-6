package lotto.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;
    private ScoreType score;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        sameNumberValidate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void sameNumberValidate(List<Integer> numbers) throws IllegalArgumentException {
        // 중복 숫자
        Set<Integer> winningNumberSet = new HashSet<>(numbers);
        if(winningNumberSet.size()!= numbers.size()){
            throw new IllegalArgumentException("[ERROR] 중복된 값이 존재합니다. 다시 입력하세요");
        }
    }

    public ScoreType getScore() {
        return score;
    }

    public void setScore(ScoreType score) {
        this.score = score;
    }

    // TODO: 추가 기능 구현


    @Override
    public String toString() {
        return numbers.toString();
    }
}
