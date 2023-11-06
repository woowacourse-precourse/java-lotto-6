package lotto.service.calculate;

import lotto.dto.calculate.GetReturnRateDto;
import lotto.dto.input.GetLottoCountDto;
import lotto.dto.result.GetLottoResultDto;

public interface Calculator {

    GetReturnRateDto calculateLottoReturnRate(GetLottoResultDto getLottoResultDto, GetLottoCountDto getLottoCountDto);

}
