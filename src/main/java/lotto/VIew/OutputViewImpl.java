package lotto.VIew;

import static lotto.Message.OutputViewMessage.EARNING_RATE;
import static lotto.Message.OutputViewMessage.PURCHASED_LOTTO_COUNT;
import static lotto.Message.OutputViewMessage.RESULT_WITHOUT_BONUS;
import static lotto.Message.OutputViewMessage.RESULT_WITH_BONUS;
import static lotto.Message.OutputViewMessage.WINNING_STATS;

import java.util.Collections;
import java.util.List;
import lotto.Domain.LottoGroup;
import lotto.Domain.LottoResult.LottoResult;
import lotto.Domain.LottoResult.Prize;

public class OutputViewImpl implements OutputView {

    private OutputViewImpl() {
    }

    public static OutputViewImpl of() {
        return new OutputViewImpl();
    }

    @Override
    public void printLottoCount(int lottoCount) {
        System.out.println(PURCHASED_LOTTO_COUNT.getMessage(lottoCount));
    }

    @Override
    public void printOrderedLottos(LottoGroup lottoGroup) {
        for (int order = 0; order < lottoGroup.findLottoNumbersSize(); order++) {
            List<Integer> numbers = lottoGroup.findLottoByIndex(order).getNumbers();
            numbers.sort(Integer::compareTo);
            System.out.println(numbers);
        }
    }

    @Override
    public void printLottoResult(LottoResult lottoResult) {
        System.out.println(WINNING_STATS.getMessage());
        List<Prize> allPrize = lottoResult.findAllPrize();
        Collections.reverse(allPrize);
        for (Prize prize : allPrize) {
            if (prize.getAward() == Prize.SECOND_PRIZE.getAward()) {
                resultWithBonus(prize);
                continue;
            }
            resultWithOutBonus(prize);
        }
    }

    @Override
    public void printProfitRate(float profitRate) {
        System.out.println(EARNING_RATE.getMessage(profitRate));
    }

    private static void resultWithOutBonus(Prize prize) {
        System.out.println(RESULT_WITHOUT_BONUS.getMessage(prize.getNumberCount(), prize.getAward(), prize.getWinningCount()));
    }

    private static void resultWithBonus(Prize prize) {
        System.out.println(
                RESULT_WITH_BONUS.getMessage(prize.getNumberCount(), prize.getAward(), prize.getWinningCount()));
    }
}
