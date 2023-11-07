package lotto.domain;

import lotto.util.ListUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static lotto.util.ErrorProperties.*;
import static lotto.util.ListUtil.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers); // 로또 번호가 6개인지 검사
        validateDuplication(numbers); // 로또 번호가 중복 되지 않는지 검사

        this.numbers = new ArrayList<>(numbers);
        Collections.sort(this.numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(getErrorMessageSize());
        }
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }
}
