package lotto.dto.input;

import lotto.dto.LottoNumberDto;

public record BonusNumberDto(LottoNumberDto bonusNumber) {
    public static BonusNumberDto from(String input) {
        int bonusNumber = Integer.parseInt(input);
        LottoNumberDto lottoNumberDto = new LottoNumberDto(bonusNumber);
        return new BonusNumberDto(lottoNumberDto);
    }
}
