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
        List<LottoNumber> lottoNumbers = lotto.getNumbers();
        List<LottoNumberDto> lottoNumberDtos = toLottoNumberDtos(lottoNumbers);

        return new LottoDto(lottoNumberDtos);
    }

    private static List<LottoNumberDto> toLottoNumberDtos(List<LottoNumber> lottoNumbers) {
        return lottoNumbers.stream()
                .map(LottoNumberDto::from)
                .toList();
    }

    public List<Integer> getSortedNumbers() {
        return lottoNumbers.stream()
                .map(LottoNumberDto::getNumber)
                .sorted()
                .toList();
    }
}
