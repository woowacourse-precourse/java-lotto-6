package lotto.model.number;

import java.util.List;

public record LottoNumbers(List<LottoNumber> numbers) {
    public LottoNumbers {
        validate(numbers);
    }

    private void validate(List<LottoNumber> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("로또 번호는 6개여야 합니다.");
        }
    }

    public int size() {
        return numbers.size();
    }

    public List<LottoNumber> getSortedNumbers() {
        return numbers.stream().sorted().toList();
    }
}
