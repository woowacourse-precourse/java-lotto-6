package lotto.service.generate;

import lotto.dto.input.GetLottoCountDto;
import lotto.dto.lottogenerator.GetGeneratedLottosDto;

public interface Generator {
    GetGeneratedLottosDto generateLottos(GetLottoCountDto getLottoCountDto);
}
