package lotto.domain;

import java.util.List;

public class Lotto {

    private final List<LottoNumber> lottoNumbers;

    public Lotto(List<Integer> numbers) {
        this.lottoNumbers = create(numbers);
    }

    private List<LottoNumber> create(List<Integer> numbers) {
        return numbers.stream()
                .map(LottoNumber::new)
                .distinct()
                .toList();
    }
}
