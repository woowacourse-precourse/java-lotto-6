package lotto.model.number;

import java.util.List;

public class LottoNumbers {
    private final List<LottoNumber> numbers;

    public LottoNumbers(List<LottoNumber> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<LottoNumber> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("로또 번호는 6개여야 합니다.");
        }
    }

    public int size() {
        return numbers.size();
    }

    public List<LottoNumber> getNumbers() {
        return numbers;
    }

    public void sort() {
        numbers.sort(LottoNumber::compareTo);
    }
}
