package lotto.domain;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        isValidLottoNumbers(numbers);
        hasDuplicateLottoNumbers(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
    private void isValidLottoNumbers(List<Integer> numbers) {
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) < 1 || numbers.get(i) > 45) {
                throw new IllegalArgumentException
                        ("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
    }

    private void hasDuplicateLottoNumbers(List<Integer> numbers) {
        for (int i = 0; i < numbers.size() - 1; i++) {
            if (numbers.get(i) == numbers.get(i + 1)) {
                throw new IllegalArgumentException
                        ("[ERROR] 중복된 로또 번호가 있습니다.");
            }
        }
    }

    public void mathcLottoNumbers(Lotto realLotto, Lotto randomLotto, Integer bonusLotto) {
        List<Integer> realLottoNumbers = realLotto.numbers;
        List<Integer> randomLottoNumbers = randomLotto.numbers;


    }
}
