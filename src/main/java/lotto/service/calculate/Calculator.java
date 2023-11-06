package lotto.service.calculate;

import lotto.dto.calculate.GetReturnCalculator;
import lotto.dto.input.GetLottoCountDto;
import lotto.dto.result.GetLottoResultDto;

public interface Calculator {

    GetReturnCalculator calculateLottoReturnRate(GetLottoResultDto getLottoResultDto, GetLottoCountDto getLottoCountDto);

}
