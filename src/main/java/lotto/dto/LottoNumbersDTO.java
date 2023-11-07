package lotto.dto;

import java.util.List;

public record LottoNumbersDTO(List<Integer> lottoNumbers) {
    public String getFormattedLottoNumbers() {
        return lottoNumbers.toString();
    }
}
