package lotto.common.console;

import lotto.core.domain.Lotto;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Output {
    public static final String WRITE_LOTTO_COUNT_FORMAT = "%d개를 구매했습니다.";
    public static final String WRITE_ENTIRE_LOTTO_DRAW_RESULT = "당첨 통계";
    public static final String DIVIDING_LINE = "---";
    public static final String WRITE_EACH_LOTTO_DRAW_RESULT_FORMAT = "%s (%s원) - %d개";
    public static final String DEFAULT_DECIMAL_FORMAT = "#,##0";
    public static final String WRITE_RETURN_RATIO_FORMAT = "총 수익률은 %f%입니다.";

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static void writeLottoCount(int count) {
        System.out.println(String.format(WRITE_LOTTO_COUNT_FORMAT, count));
    }

    public static void writeLottoNumbers(Lotto lotto) {
        List<Integer> numbers = lotto.getNumbers();
        Collections.sort(numbers);

        System.out.println(Arrays.toString(numbers.toArray()));
    }

    public static void writeEntireLottoDrawResult() {
        System.out.println(WRITE_ENTIRE_LOTTO_DRAW_RESULT);
        System.out.println(DIVIDING_LINE);
    }

    public static void writeEachLottoDrawResult(String winningCondition, int reward, int winningCount) {
        DecimalFormat rewardAmountFormat = new DecimalFormat(DEFAULT_DECIMAL_FORMAT);
        String formattedReward = rewardAmountFormat.format(reward);

        System.out.println(String.format(WRITE_EACH_LOTTO_DRAW_RESULT_FORMAT, winningCondition, formattedReward, winningCount));
    }

    public static void writeReturnRate(float returnRate) {
        System.out.println(String.format(WRITE_RETURN_RATIO_FORMAT, returnRate));
    }
}
