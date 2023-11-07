package lotto.domain;

import lotto.view.VerificationView;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        duplicate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            VerificationView.verificationViewLengthLottoNumberList();
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
    private void duplicate(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>();
        for (int lottoNumber : numbers) {
            if (!uniqueNumbers.add(lottoNumber)) {
                VerificationView.verificationViewDuplicateLottoNumber();
                throw new IllegalArgumentException();
            }
        }
    }

    public List<Integer> getLotto() {
        return this.numbers;
    }
}
