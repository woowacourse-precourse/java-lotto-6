package lotto.domain.answer.number;

import lotto.domain.UserInput;

public class LotteryBonusNumberService {
    public Integer getBonusAnswer() {
        String bonusInput = UserInput.getValidInput(LottoAnswerValidator.validateBonusInput);
        return LottoAnswerMapper.mapToBonus(bonusInput);
    }
}
