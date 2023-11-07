package lotto.domain.answer;

import lotto.domain.Lotto;
import lotto.domain.answer.number.LotteryAnswerNumberService;
import lotto.domain.answer.number.LotteryBonusNumberService;
import lotto.domain.answer.number.LottoAnswer;
import lotto.domain.io.InputView;

public class LotteryAnswerController {
    private LotteryAnswerNumberService lotteryAnswerNumberService = new LotteryAnswerNumberService();
    private LotteryBonusNumberService lotteryBonusNumberService = new LotteryBonusNumberService();

    public LottoAnswer getAnswer() {
        InputView.getLottoAnswer();
        Lotto answer = lotteryAnswerNumberService.getLottoAnswer();

        InputView.getBonusAnswer();
        Integer bonus = lotteryBonusNumberService.getBonusAnswer();
        return new LottoAnswer(answer, bonus);
    }
}
