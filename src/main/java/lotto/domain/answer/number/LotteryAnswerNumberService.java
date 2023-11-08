package lotto.domain.answer.number;

import lotto.domain.Lotto;
import lotto.domain.UserInput;

public class LotteryAnswerNumberService {

    public Lotto getLottoAnswer() {
        String lottoAnswerInput = UserInput.getValidInput(LottoAnswerValidator.validateLottoAnswerInput);
        return LottoAnswerMapper.mapToLotto(lottoAnswerInput);
    }
}
