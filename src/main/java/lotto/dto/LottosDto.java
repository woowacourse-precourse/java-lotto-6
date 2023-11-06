package lotto.dto;

import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.Lottos;

public record LottosDto(List<LottoDto> lottos) {

    public static LottosDto from(Lottos lottos) {
        return new LottosDto(lottos.getLottos().stream()
                .map(LottoDto::from)
                .collect(Collectors.toList()));
    }
}
