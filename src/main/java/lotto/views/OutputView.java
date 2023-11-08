package lotto.views;

import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.Prize;
import lotto.global.Utils;

public class OutputView {
    public static final String PURCHASE_LOTTO_OUTPUT = "개를 구매했습니다.";

    public void lottoQuantityAndNumber(List<Lotto> publishedLotto) {
        System.out.println(publishedLotto.size() + PURCHASE_LOTTO_OUTPUT);
        for (Lotto lotto : publishedLotto) {
            List<Integer> sortedNumbers = lotto.getNumbers();
            StringBuilder stringBuilder = new StringBuilder("[");
            stringBuilder.append(joinNumbers(",", sortedNumbers));
            stringBuilder.append("]");
            System.out.println(stringBuilder.toString());
        }
    }

    String joinNumbers(CharSequence delimiter, List<Integer> numbers) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Integer number : numbers) {
            stringBuilder.append(number);
            stringBuilder.append(delimiter);
            stringBuilder.append(" ");
        }

        int length = stringBuilder.length();
        stringBuilder.delete(length - 2, length);

        return stringBuilder.toString();
    }

    public void winningRecord(Map<Prize, Integer> lotteryResult) {
        StringBuilder outputBuilder = new StringBuilder("당첨 통계\n" + "---\n");

        for (Prize prize : lotteryResult.keySet()) {
            int count = lotteryResult.get(prize);
            outputBuilder.append(joinPrize(prize, count));
        }

        System.out.println(outputBuilder.toString());
    }

    String joinPrize(Prize prize, int count){
        StringBuilder outputBuilder = new StringBuilder();
        int matchCount = prize.getMatchCount();
        String reward = Utils.NUMBER_FORMAT_US.format(prize.getReward());

        outputBuilder.append(matchCount);
        outputBuilder.append("개 일치");
        outputBuilder.append(checkSecondPrize(prize));
        outputBuilder.append(reward);
        outputBuilder.append("원) - ");
        outputBuilder.append(count);
        outputBuilder.append("개\n");

        return outputBuilder.toString();
    }

    String checkSecondPrize(Prize prize) {
        StringBuilder stringBuilder = new StringBuilder();
        if (Prize.SECOND_REWARD.equals(prize)) {
            stringBuilder.append(", 보너스 볼 일치");
        }
        stringBuilder.append(" (");
        return stringBuilder.toString();
    }

    public void rewardRatioRecord(double rewardRatio) {
        StringBuilder outputBuilder = new StringBuilder("총 수익률은 ");
        outputBuilder.append(rewardRatio);
        outputBuilder.append("%입니다.");
        System.out.println(outputBuilder.toString());
    }
}
