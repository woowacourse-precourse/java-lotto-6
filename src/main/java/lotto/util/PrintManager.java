package lotto.util;

import lotto.domain.Lotto;
import lotto.domain.LottoPrize;

import java.util.List;

public class PrintManager {

    private static final String INPUT_MONEY = "구입금액을 입력해 주세요.";
    private static final String INPUT_WIN_NUMBERS = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    private static final String PRINT_LOTTO_COUNT_POSTFIX = "개를 구매했습니다.";
    private static final String PRINT_RESULT = "당첨 통계\n---";
    private static final String PRINT_RESULT_PRIZE_POSTFIX= "개";
    private static final String PRINT_RESULT_PROFIT_RATE_PREFIX = "총 수익률은 ";
    private static final String PRINT_RESULT_PROFIT_RATE_POSTFIX = "%입니다.";

    public static void printInputMoney() {
        System.out.println(INPUT_MONEY);
    }

    public static void printInputWinNumbers() {
        System.out.println(INPUT_WIN_NUMBERS);
    }

    public static void printBonusNumberInput() {
        System.out.println(INPUT_BONUS_NUMBER);
    }

    public static void printIllegalArgumentExceptionWinLotto() {
        System.out.println(ErrorMessage.ILLEGAL_ARGUMENT_WIN_LOTTO.getMessage());
    }

    public static void printLottoCount(int count) {
        System.out.println(count + PRINT_LOTTO_COUNT_POSTFIX);
    }

    public static void printPickedLottoNumbers(Lotto lotto) {
        List<Integer> numbers = lotto.getNumbers();
        System.out.print("[");
        for (int i = 0; i < numbers.size() - 1; i++)
            System.out.print(numbers.get(i) + ", ");
        System.out.print(numbers.get(numbers.size() - 1));
        System.out.println("]");
    }

    public static void printResult(String profitRate, int[] prizeCount) {
        System.out.println(PRINT_RESULT);
        LottoPrize[] prizes = LottoPrize.values();
        for (int i = 0; i < prizeCount.length - 1; i++) {
            LottoPrize prize = prizes[i];
            System.out.println(prize.getTitle() + prizeCount[i] + PRINT_RESULT_PRIZE_POSTFIX);
        }
        System.out.println(PRINT_RESULT_PROFIT_RATE_PREFIX + profitRate + PRINT_RESULT_PROFIT_RATE_POSTFIX);

    }
}
