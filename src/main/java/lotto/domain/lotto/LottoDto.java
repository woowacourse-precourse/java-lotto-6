package lotto.domain.lotto;

import java.util.Collections;
import java.util.List;

public class LottoDto {

    private final List<Integer> lottoNumbers;

    public LottoDto(List<Integer> numbers) {
        Collections.sort(numbers);
        this.lottoNumbers = numbers;
    }

    public List<Integer> getNumbers() {
        return lottoNumbers;
    }
}
