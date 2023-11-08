package lotto.common.console;

import lotto.core.domain.Lotto;

import java.util.Arrays;
import java.util.List;

public class Output {
    public static final String WRITE_LOTTO_COUNT_FORMAT = "%d개를 구매했습니다.";
    public static final String WRITE_ENTIRE_LOTTO_DRAW_RESULT = "당첨 통계";
    public static final String DIVIDING_LINE = "---";

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static void writeLottoCount(int count) {
        System.out.println(String.format(WRITE_LOTTO_COUNT_FORMAT, count));
    }

    public static void writeLottoNumbers(Lotto lotto) {
        List<Integer> numbers = lotto.getNumbers();

        System.out.println(Arrays.toString(numbers.toArray()));
    }

    public static void writeEntireLottoDrawResult() {
        System.out.println(WRITE_ENTIRE_LOTTO_DRAW_RESULT);
        System.out.println(DIVIDING_LINE);
    }
}
