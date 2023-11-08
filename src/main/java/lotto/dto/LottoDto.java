package lotto.dto;

import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.Lotto;

public record LottoDto(List<LottoNumberDto> lottoNumbers) {

    public static LottoDto from(Lotto lotto) {
        return new LottoDto(lotto.getNumbers().stream()
                .map(LottoNumberDto::from)
                .collect(Collectors.toUnmodifiableList()));
    }
}
