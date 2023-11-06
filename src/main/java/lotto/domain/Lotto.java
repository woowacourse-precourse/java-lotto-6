 package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private final List<LottoNumber> numbers;

    private Lotto(List<LottoNumber> numbers) {
        this.numbers = new ArrayList<>(numbers);
    }

    public static Lotto from(List<LottoNumber> numbers) {
        validateLottoNumber(numbers);
        return new Lotto(numbers);
    }

    private static void validateLottoNumber(List<LottoNumber> numbers) {
        validateLottoNumbersLength(numbers);
    }

    private static void validateLottoNumbersLength(List<LottoNumber> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호의 총 길이는 6이어야 합니다.");
        }
    }

    // TODO: 추가 기능 구현
}
