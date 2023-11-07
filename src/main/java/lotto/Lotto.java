package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        isOneToFourtyfive(numbers);
        isValidLottoNumbers(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
    private void isValidLottoNumbers(List<Integer> numbers) {
        Set<Integer> validWinLotto = new HashSet<>(numbers);
        if (validWinLotto.size() != numbers.size()) {
            throw new IllegalArgumentException();
        }
    }

    public void printLottoNumbers() {
        System.out.println(this.numbers);
    }

    private void isOneToFourtyfive(List<Integer> numbers) {
        for (int i = 0; i < numbers.size(); i++) {
            if(numbers.get(i) < 1 || numbers.get(i) > 45) {
                throw new IllegalArgumentException();
            }
        }
    }

    public List<Integer> getLottoNumbers() {
        return this.numbers;
    }
}
