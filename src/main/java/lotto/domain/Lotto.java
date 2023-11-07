package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.validator.LottoValidator;

import java.util.List;

public class Lotto {
    private static final Integer RANDOM_LOTTO_START_NUMBER= 1;
    private static final Integer RANDOM_LOTTO_END_NUMBER= 45;
    private static final Integer RANDOM_LOTTO_SIZE= 6;


    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        LottoValidator.inputLottoDuplicationNumberValidator(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != RANDOM_LOTTO_SIZE) {
            throw new IllegalArgumentException();
        }
    }
    // TODO: 추가 기능 구현

    public List<Integer> getNumbers() {
        return numbers;
    }

    public static Lotto createLotto() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(RANDOM_LOTTO_START_NUMBER, RANDOM_LOTTO_END_NUMBER, RANDOM_LOTTO_SIZE));
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
