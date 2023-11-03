package lotto.dto.response;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.LottoNumber;

public class LottoDto {
    private final List<LottoNumberDto> lottoNumbers;

    private LottoDto(List<LottoNumberDto> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public static LottoDto from(Lotto lotto) {
        List<LottoNumber> numbers = lotto.getNumbers();
        List<LottoNumberDto> lottoNumberDtos = numbers.stream()
                .map(LottoNumberDto::from)
                .toList();
        return new LottoDto(lottoNumberDtos);
    }

    public List<Integer> getNumbers() {
        return lottoNumbers.stream()
                .map(LottoNumberDto::getNumber)
                .sorted()
                .toList();
    }
}
