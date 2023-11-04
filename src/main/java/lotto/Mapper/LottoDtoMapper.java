package lotto.Mapper;

import lotto.dto.LottoDto;
import lotto.model.Lotto;

public class LottoDtoMapper {
    public static LottoDto from (Lotto lotto) {
        return new LottoDto(lotto.getNumbers());
    }
}
