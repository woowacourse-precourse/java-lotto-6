package lotto.domain;

import static lotto.domain.LottoConfig.LOTTO_COUNT;

import java.util.List;

public class Lotto {
    private final List<LottoNumber> numbers;

    public Lotto(List<LottoNumber> numbers) {
        validateSize(numbers);
        this.numbers = numbers;
    }

    private void validateSize(List<LottoNumber> numbers) {
        if (numbers.size() != LOTTO_COUNT.getValue()) {
            throw new IllegalArgumentException(
                    String.format("로또 번호는 %d개여야 합니다.", LOTTO_COUNT.getValue())
            );
        }
    }

    // TODO: 추가 기능 구현
}
