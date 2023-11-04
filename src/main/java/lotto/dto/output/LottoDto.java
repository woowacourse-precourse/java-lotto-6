package lotto.dto.output;

import java.util.List;
import lotto.domain.lotto.Lotto;
import lotto.dto.LottoNumberDto;

public record LottoDto(List<LottoNumberDto> lottoNumbers) {
    public static LottoDto toLottoDto(Lotto lotto) {
        List<Integer> numbers = lotto.getNumbers();
        List<LottoNumberDto> lottoNumbers = numbers.stream()
                .map(LottoNumberDto::new)
                .toList();
        return new LottoDto(lottoNumbers);
    }
}
