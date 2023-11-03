package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;
    private final int LottoSize = 6;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        duplicate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LottoSize) {
            throw new IllegalArgumentException("[ERROR] 로또 번호 갯수가 6개가 아닙니다.");
        }
    }

    private void duplicate(List<Integer> numbers) {
        boolean isPresent = numbers.stream()
                .distinct()
                .count() == numbers.size();

        if(!isPresent) {
            throw new IllegalArgumentException("[ERROR] 중복된 숫자가 발생했습니다.");
        }
    }

    // TODO: 추가 기능 구현
    public List<Integer> lottoNumber() {
        return numbers;
    }

}
