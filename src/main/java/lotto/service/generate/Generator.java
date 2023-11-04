package lotto.service.generate;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.dto.input.GetLottoCountDto;
import lotto.dto.lottogenerator.GetLottosDto;

public interface Generator {
    GetLottosDto generateLottos(GetLottoCountDto getLottoCountDto);
}
