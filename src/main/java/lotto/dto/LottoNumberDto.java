package lotto.dto;

import java.util.List;

public class LottoNumberDto {
    private final List<Integer> lottoNumbers;

    public LottoNumberDto(List<Integer> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }
}
