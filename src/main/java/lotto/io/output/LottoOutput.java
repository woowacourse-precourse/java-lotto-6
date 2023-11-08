package lotto.io.output;

import java.util.List;
import java.util.Map;
import lotto.data.UserLotto;
import lotto.meta.Result;

public class LottoOutput {
    private static final String INPUT_MONEY = "구입금액을 입력해 주세요.";
    private static final String CONFIRM_MONEY = "개를 구매했습니다.";
    private static final String INPUT_LOTTO_NUMBERS = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBERS = "보너스 번호를 입력해 주세요.";
    private static final String GET_RESULT = "당첨 통계\n---";
    private static final String SPLIT_RESULT = " - ";
    private static final String RESULT_SUFFIX = "개";
    private static final String TOTAL_PROFIT_PREFIX = "총 수익은 ";
    private static final String TOTAL_PROFIT_SUFFIX = "% 입니다.";

    public static void printNewLine() {
        System.out.println();
    }

    public static void printInputMoney() {
        System.out.println(INPUT_MONEY);
    }

    public static void printConfirmMoney(int cnt) {
        System.out.println(cnt + CONFIRM_MONEY);
    }

    public static void printUserLottos(List<UserLotto> userLottos) {
        userLottos.forEach(userLotto -> {
            System.out.println(userLotto.toString());
        });
        printNewLine();
    }

    public static void printInputLottoNumber() {
        System.out.println(INPUT_LOTTO_NUMBERS);
    }

    public static void printInputBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBERS);
    }

    public static void printGetResult() {
        System.out.println(GET_RESULT);
    }

    public static void printResultCounting(Map<Result, Integer> result) {
        for (Map.Entry<Result, Integer> entry : result.entrySet()) {
            System.out.println(entry.getKey().getText() + SPLIT_RESULT + entry.getValue() + RESULT_SUFFIX);
        }
    }

    public static void printTotalProfit(double sum, double spendMoney) {
        System.out.println(TOTAL_PROFIT_PREFIX + sum * 100.0 / spendMoney + TOTAL_PROFIT_SUFFIX);
    }
}
