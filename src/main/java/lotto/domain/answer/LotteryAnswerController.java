package lotto.domain.answer;

import lotto.domain.Lotto;
import lotto.domain.User;
import lotto.domain.answer.check.LotteryAnswerCheckService;
import lotto.domain.answer.number.LotteryAnswerNumberService;
import lotto.domain.answer.number.LotteryBonusNumberService;
import lotto.domain.answer.number.LottoAnswer;
import lotto.domain.answer.rate.LotteryRateService;
import lotto.domain.view.InputView;

public class LotteryAnswerController {
    private static final LotteryAnswerNumberService lotteryAnswerNumberService = new LotteryAnswerNumberService();
    private static final LotteryBonusNumberService lotteryBonusNumberService = new LotteryBonusNumberService();
    private static final LotteryAnswerCheckService lotteryAnswerCheckService = new LotteryAnswerCheckService();
    private static final LotteryRateService lotteryRateService = new LotteryRateService();

    public LottoAnswer getAnswer() {
        Lotto answer = getLottoAnswer();
        Integer bonus = getBonus();
        return new LottoAnswer(answer, bonus);
    }

    Lotto getLottoAnswer() {
        InputView.getLottoAnswer();
        return lotteryAnswerNumberService.getLottoAnswer();
    }

    Integer getBonus() {
        InputView.getBonusAnswer();
        return lotteryBonusNumberService.getBonusAnswer();
    }

    public void getResult(User user, LottoAnswer lottoAnswer) {

    }
}
