package lotto.service.output;

import lotto.dto.calculate.GetReturnRateDto;
import lotto.dto.result.GetLottoResultDto;
import lotto.dto.generate.GetGeneratedLottosDto;

public interface Output {
    void printLottoNumbers(GetGeneratedLottosDto getGeneratedLottosDto);

    void printLottoResult(GetLottoResultDto getLottoResultDto);

    void printRate(GetReturnRateDto getReturnRateDto);
}
