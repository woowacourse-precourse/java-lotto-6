package lotto.service.output;

import lotto.dto.result.GetLottoResultDto;
import lotto.dto.generate.GetGeneratedLottosDto;

public interface Output {
    void printLottoNumbers(GetGeneratedLottosDto getGeneratedLottosDto);

    void printLottoResult(GetLottoResultDto getLottoResultDto);
}
