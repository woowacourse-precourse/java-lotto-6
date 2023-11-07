package lotto.mapper;

import lotto.dto.LottoResultDto;
import lotto.model.LottoResult;

public class LottoResultDtoMapper {
    public static LottoResultDto from(LottoResult lottoResult) {
        return new LottoResultDto(lottoResult.getLottoResult());
    }
}
