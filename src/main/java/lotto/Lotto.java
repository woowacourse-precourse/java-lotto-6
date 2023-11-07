package lotto;

import config.LottoConfig;

import java.util.HashSet;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LottoConfig.LOTTO_SIZE) {
            throw new IllegalArgumentException(String.format("[ERROR] 로또의 번호는 %d개여야 합니다.", LottoConfig.LOTTO_SIZE));
        }
        if (new HashSet<>(numbers).size() != LottoConfig.LOTTO_SIZE) {
            throw new IllegalArgumentException("[ERROR] 로또의 번호는 중복되지 않아야 합니다.");
        }
    }

    // TODO: 추가 기능 구현
}
