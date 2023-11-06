package lotto.dto;

import java.util.List;

public class LottoAndBonusNumberDTO {
    private final List<Integer> lottoNumbers;
    private final Integer bonusNumber;

    public LottoAndBonusNumberDTO(List<Integer> lottoNumbers, Integer bonusNumber) {
        this.lottoNumbers = lottoNumbers;
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }

    public Integer getBonusNumber() {
        return bonusNumber;
    }
}
