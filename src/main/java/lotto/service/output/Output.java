package lotto.service.output;

import lotto.dto.calculate.GetLottoResultDto;
import lotto.dto.generate.GetGeneratedLottosDto;

public interface Output {
    void printLottoNumbers(GetGeneratedLottosDto getGeneratedLottosDto);

    void printLottoResult(GetLottoResultDto getLottoResultDto);
}
