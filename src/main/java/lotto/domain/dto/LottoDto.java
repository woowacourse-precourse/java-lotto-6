package lotto.domain.dto;

import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoNumber;

import java.util.List;
import java.util.stream.Collectors;

public class LottoDto {

    private List<Integer> lottoNumbers;

    private LottoDto(List<Integer> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }

    public static LottoDto of(Lotto lotto) {
        List<Integer> numbers = lotto.getLottoNumbers()
                .stream()
                .map(LottoNumber::getValue)
                .collect(Collectors.toList());
        return new LottoDto(numbers);
    }
}

