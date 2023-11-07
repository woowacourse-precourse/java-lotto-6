package lotto.domain.answer.number;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;

public class LotteryAnswerNumberService {

    public Lotto getLottoAnswer() {
        boolean success = false;
        String lottoAnswerInput = null;
        while (!success) {
            lottoAnswerInput = Console.readLine();
            success = isValidAnswer(success, lottoAnswerInput);
        }
        return LottoAnswerMapper.mapToLotto(lottoAnswerInput);
    }

    private boolean isValidAnswer(boolean success, String lottoAnswerInput) {
        try {
            LottoAnswerValidator.validateLottoAnswerInput(lottoAnswerInput);
            success = true;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return success;
    }
}
