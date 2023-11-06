package lotto.view;

import static java.lang.System.out;

import java.util.List;
import lotto.model.Lotto;
import java.util.Collections;
import lotto.model.Result;
import lotto.model.Ticket;

public class Output {
    private static final String INPUT_PAYMENT = "구입금액을 입력해 주세요.";
    private static final String NUM_OF_LOTTO = "\n%d개를 구매했습니다.";
    private static final String INPUT_WINNING_NUM = "\n당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUM = "\n보너스 번호를 입력해 주세요.";
    private static final String OUTPUT_RESULT = "\n당첨 통계\n---";
    private static final String SAME3 = "3개 일치 (5,000원) - %d개";
    private static final String SAME4 = "4개 일치 (50,000원) - %d개";
    private static final String SAME5 = "5개 일치 (1,500,000원) - %d개";
    private static final String SAME5_BONUS = "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개";
    private static final String SAME6 = "6개 일치 (2,000,000,000원) - %d개";
    private static final String RATE_OF_RETURN = "총 수익률은 %.1f%%입니다.";

    public static void inputPaymentMsg() {
        out.println(INPUT_PAYMENT);
    }

    public static void printNumOfLotto(int numOfLotto) {
        out.println(String.format(NUM_OF_LOTTO, numOfLotto / 1000));
    }

    public static void printTicket(Ticket ticket) {
        for (Lotto lotto : ticket.getLottos()) {
            out.println(lotto.getNumbers().toString());
        }
    }

    public static void inputWinningNumMsg() {
        out.println(INPUT_WINNING_NUM);
    }

    public static void inputBonusNumMsg() {
        out.println(INPUT_BONUS_NUM);
    }

    public static void printResult(List<Result> result, double rateOfReturn) {
        out.println(OUTPUT_RESULT);
        printSame3(Collections.frequency(result, Result.SAME3));
        printSame4(Collections.frequency(result, Result.SAME4));
        printSame5(Collections.frequency(result, Result.SAME5));
        printSame5Bonus(Collections.frequency(result, Result.SAME5_BONUS));
        printSame6(Collections.frequency(result, Result.SAME6));
        out.println(String.format(RATE_OF_RETURN, rateOfReturn));
    }

    private static void printSame3(int count) {
        out.println(String.format(SAME3, count));
    }

    private static void printSame4(int count) {
        out.println(String.format(SAME4, count));
    }

    private static void printSame5(int count) {
        out.println(String.format(SAME5, count));
    }

    private static void printSame5Bonus(int count) {
        out.println(String.format(SAME5_BONUS, count));
    }

    private static void printSame6(int count) {
        out.println(String.format(SAME6, count));
    }
}
