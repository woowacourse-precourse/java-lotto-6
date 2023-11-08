package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = new ArrayList<>(numbers);
        Collections.sort(this.numbers);
        validate(this.numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 정확히 6개여야 합니다.");
        }
        if (new HashSet<>(numbers).size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복될 수 없습니다.");
        }
        for (Integer number : numbers) {
            if(number < 1 || number > 45) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
    }

    public int countMatches(List<Integer> winningNumbers) {
        return (int) numbers.stream().filter(winningNumbers::contains).count();
    }

    public boolean hasBonusNumber(int bonusNumber) {
        return numbers.contains(bonusNumber);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

}
