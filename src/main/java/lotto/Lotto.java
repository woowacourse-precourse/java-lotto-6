package lotto;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashSet;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) { //생성자
        validate(numbers);
        this.numbers = numbers;
    }

    public void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("로또는 6개의 숫자로 이루어져야 합니다.");
        }

        if (hasDuplicateNumber(numbers)) {
            throw new IllegalArgumentException("로또 번호에 중복된 숫자가 있습니다.");
        }

        for (int number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("로또 번호는 1부터 45 사이의 숫자이어야 합니다.");
            }
        }

        if (numbers.size() != 6) {
            throw new IllegalArgumentException("로또는 6개의 숫자로 이루어져야 합니다.");
        }
    }

    // TODO: 추가 기능 구현
    public void validateBonus(int bonus) { // 보너스 번호 확인
        if (bonus < 1 || bonus > 45) {
            throw new IllegalArgumentException("보너스 번호는 1부터 45 사이의 숫자이어야 합니다.");
        }

        if (numbers.contains(bonus)) {
            throw new IllegalArgumentException("당첨 번호와 보너스 번호는 중복되어서는 안됩니다.");
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private boolean hasDuplicateNumber(List<Integer> numbers) {
        return new HashSet<>(numbers).size() != numbers.size();
    }
}