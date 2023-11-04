package lotto.domain.mapper;

import java.util.List;
import lotto.domain.dto.LottoDto;
import lotto.domain.model.Lotto;

public class LottoMapper {
    public static LottoDto toDto(Lotto lotto) {
        return new LottoDto(lotto.getNumbers());
    }

    public static List<LottoDto> toDtos(List<Lotto> lottos) {
        return lottos.stream()
                .map(LottoMapper::toDto)
                .toList();
    }

}

