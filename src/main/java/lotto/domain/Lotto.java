package lotto.domain;

import java.util.List;
import java.util.function.Predicate;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }
    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("로또 번호는 1부터 45 사이의 숫자여야 합니다.\n");
        }
    }
    public int matchNumbers(Lotto player){
        List<Integer> playerNumbers = player.getNumbers();

        List<Integer> matchList = playerNumbers.stream().filter(o -> this.numbers.stream()
                .anyMatch(Predicate.isEqual(o))).toList();

        return matchList.size();
    }
    public boolean matchBonusNum(int bonusNum){
        return numbers.contains(bonusNum);
    }

    public List<Integer> getNumbers(){
        return numbers;
    }
}
