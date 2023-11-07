package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.constant.StringConstant;

import java.util.List;
import java.util.stream.Collectors;

import static lotto.constant.NumberConstant.*;

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
    public static Lotto createLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(LOTTO_NUMBER_START_INCLUSIVE.value(), LOTTO_NUMBER_END_INCLUSIVE.value(), LOTTO_SIZE.value());
        return new Lotto(numbers);
    }

    public String joinNumbersWithDelimiter(StringConstant stringConstant) {
        return numbers.stream()
                .sorted()
                .map(String::valueOf)
                .collect(Collectors.joining(stringConstant.value()));
    }

}
