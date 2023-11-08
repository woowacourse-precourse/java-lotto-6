package lotto.domain.answer;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.domain.User;
import lotto.domain.answer.check.LotteryAnswerCheckService;
import lotto.domain.answer.check.WinningPolicyCondition;
import lotto.domain.answer.number.LotteryAnswerNumberService;
import lotto.domain.answer.number.LotteryBonusNumberService;
import lotto.domain.answer.rate.LotteryRateService;
import lotto.domain.view.InputView;
import lotto.domain.view.OutputView;

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
        // 상금 계산
        Map<Integer, Integer> rankToCount = lotteryAnswerCheckService.getRankToCount(user, lottoAnswer);
        System.out.println(rankToCount.toString());
        OutputView.printStatics();
        printResult(rankToCount);

        // ROI(이익률) 계산
        Long winningPrice = lotteryAnswerCheckService.getWinningPrice(rankToCount);
        Double returnOnInvestment = lotteryRateService.getReturnOnInvestment(user.getCash(), winningPrice);
        OutputView.printReturnOnInvestment(returnOnInvestment);
    }

    void printResult(Map<Integer, Integer> rankToCount) {
        Set<Integer> keys = Set.of(1, 2, 3, 4, 5);
        for (Integer key : keys) {
            String state = Arrays.stream(WinningPolicyCondition.values()).filter(w -> w.rank == key).map(w -> w.state)
                    .collect(Collectors.joining());
            if (!state.isEmpty()) {
                OutputView.printEachResult(state, rankToCount.getOrDefault(key, 0));
            }
        }
    }
}
