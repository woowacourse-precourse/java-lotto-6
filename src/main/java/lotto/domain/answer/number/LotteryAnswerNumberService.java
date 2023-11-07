package lotto.domain.answer.number;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;

public class LotteryAnswerNumberService {

    public Lotto getLottoAnswer() {
        boolean success = false;
        String lottoAnswerInput = null;
        while (!success) {
            lottoAnswerInput = Console.readLine();
            try {
                LottoAnswerValidator.validateLottoAnswerInput(lottoAnswerInput);
                success = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return LottoAnswerMapper.mapToLotto(lottoAnswerInput);
    }
}
