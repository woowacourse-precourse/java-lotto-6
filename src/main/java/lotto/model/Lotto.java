package lotto.model;

import java.util.List;

import static lotto.Utils.makeLottoNumber;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
    public static Lotto makeLotto() {
        List<Integer> lottoNumbers = makeLottoNumber();
        return new Lotto(lottoNumbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

}