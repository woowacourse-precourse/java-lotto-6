package lotto.domain.dto.output;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;

import java.util.List;

public record LottoResponse(List<Integer> numbers) {

    public static LottoResponse createLottoResponse(Lotto lotto) {
        List<Integer> lottoNumbers = lotto.getNumbers().stream()
                .map(LottoNumber::getNumber)
                .toList();
        return new LottoResponse(lottoNumbers);
    }
}
