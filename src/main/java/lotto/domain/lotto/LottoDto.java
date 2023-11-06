package lotto.domain.lotto;

import java.util.Collections;
import java.util.List;

public class LottoDto {

    private List<Integer> lottoNumbers;

    public LottoDto(List<Integer> numbers) {
        Collections.sort(numbers);
        this.lottoNumbers = numbers;
    }

    public List<Integer> getNumbers() {
        lottoNumbers = Collections.unmodifiableList(lottoNumbers);
        return lottoNumbers;
    }
}
