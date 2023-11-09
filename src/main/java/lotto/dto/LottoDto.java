package lotto.dto;

import java.util.List;
import lotto.model.Lotto;

public class LottoDto {
    private List<Integer> lottoNumbers;

    private LottoDto(List<Integer> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public static LottoDto create(Lotto lotto) {
        return new LottoDto(lotto.getNumbers());
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }
}