package lotto.controller.dto.input;

import java.util.List;

public final class DrawLottosDto {

    private final List<Integer> lottoNumbers;

    private final int bonusNumber;

    private DrawLottosDto(
            final List<Integer> lottoNumbers,
            final int bonusNumber
    ) {
        this.lottoNumbers = lottoNumbers;
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
