package lotto.dto.request;

import java.util.List;
import lotto.domain.Lotto;

public class AnswerNumberRequestDto {
    private final Lotto lotto;
    private int bonusNumber;

    public AnswerNumberRequestDto(List<Integer> lottoNumbers) {
        this.lotto = new Lotto(lottoNumbers);
    }

    public static AnswerNumberRequestDto createDto(List<Integer> lottoNumbers) {
        return new AnswerNumberRequestDto(lottoNumbers);
    }

    public void addBonusNumber(int bonusNumber) {
        lotto.validateRangeNumber(bonusNumber);
        lotto.containNumber(bonusNumber);
        this.bonusNumber = bonusNumber;
    }
}
