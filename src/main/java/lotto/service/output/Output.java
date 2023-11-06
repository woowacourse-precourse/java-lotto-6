package lotto.service.output;

import lotto.dto.generate.GetGeneratedLottosDto;

public interface Output {
    void printLottoNumbers(GetGeneratedLottosDto getGeneratedLottosDto);
}
