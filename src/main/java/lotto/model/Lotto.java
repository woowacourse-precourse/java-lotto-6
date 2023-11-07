package lotto.model;

import java.util.List;

/**
 * - numbers 접근 제한자 변경불가 - 필드 추가 불가 - 패키지 변경 가능
 */
public class Lotto {

    private final List<LottoNumber> numbers;

    public Lotto(List<Integer> rawNumbers) {
        this.numbers = rawNumbers.stream().map(LottoNumber::new).toList();
    }

    public List<LottoNumber> getLottoNumbers() {
        return numbers;
    }
}
