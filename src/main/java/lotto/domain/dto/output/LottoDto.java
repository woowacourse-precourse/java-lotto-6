package lotto.domain.dto.output;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;

import java.util.List;

public record LottoDto(List<Integer> numbers) {

    public static LottoDto createLottoDto(Lotto lotto) {
        List<Integer> lottoNumbers = lotto.getNumbers().stream()
                .map(LottoNumber::getNumber)
                .toList();
        return new LottoDto(lottoNumbers);
    }
}
