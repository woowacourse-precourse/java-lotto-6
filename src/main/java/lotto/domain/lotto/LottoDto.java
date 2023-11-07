package lotto.domain.lotto;

import java.util.List;

public class LottoDto {

    private List<Integer> lottoNumbers;

    public LottoDto(List<Integer> numbers) {
        this.lottoNumbers = numbers;
    }

    public List<Integer> getNumbers() {
        return lottoNumbers;
    }
}
