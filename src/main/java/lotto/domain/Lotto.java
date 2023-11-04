package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.validator.LottoValidator;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        LottoValidator.inputLottoDuplicationNumberValidator(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }
    // TODO: 추가 기능 구현

    public List<Integer> getNumbers() {
        return numbers;
    }

    public static Lotto createLotto() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
    }

    public Integer countMatch(Lotto lotto) {
        return (int) numbers.stream()
                .filter(l -> lotto.containMatch(l))
                .count();
    }

    public boolean containMatch(int number) {
        return numbers.contains(number);
    }

}
