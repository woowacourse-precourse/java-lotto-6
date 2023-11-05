package lotto.service.output;

import lotto.dto.lottogenerator.GetGeneratedLottosDto;

public interface Output {
    void printLottoNumbers(GetGeneratedLottosDto getGeneratedLottosDto);
}
