package lotto.model;

import java.util.List;
import java.util.stream.Collectors;
import java.util.HashSet;
public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    private void validateNumbers(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
        if (new HashSet<>(numbers).size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호에 중복된 숫자가 있습니다.");
        }
    }

    // TODO: 추가 기능 구현

    public boolean isContain(int bonusNum){
        return numbers.contains(bonusNum);
    }

    @Override
    public String toString() {
        return "[" + numbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", ")) + "]";
    }

    public int getMatchCount(Lotto winLotto) {
        int matchCount = 0;
        for (int number : numbers) {
            if (winLotto.numbers.contains(number)) {
                matchCount++;
            }
        }
        return matchCount;
    }

    // 보너스 번호가 있는지 확인하는 메소드
    public boolean contains(int bonusNum) {
        return numbers.contains(bonusNum);
    }
}
