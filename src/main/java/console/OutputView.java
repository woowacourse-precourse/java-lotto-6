package console;

import lotto.Lotto;
import lotto.Lottos;
import lotto.Prize;
import lotto.IncomeCalculator;

import java.util.List;
import java.util.Map;

public class OutputView {
    private static final String INPUT_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String PURCHASED_AMOUNT_IS = "개를 구매했습니다.";
    private static final String INPUT_LOTTO_NUMBER = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    private static final String RANK_RESULT = "당첨 통계\n---";
    private static final String MATCH_FORMAT = "%d개 일치";
    private static final String WINNING_FORMAT = " (%,d원) - ";
    private static final String COUNT_FORMAT = "%d개";
    private static final String BONUS_BALL_FORMAT = ", 보너스 볼 일치";
    private static final String TOTAL_EARNING_RATE_IS = "총 수익률은 %.1f%%입니다.";

    private OutputView() {
        throw new UnsupportedOperationException();
    }

    public static void printInputPurchaseAmount() {
        System.out.println(INPUT_PURCHASE_AMOUNT);
    }

    public static void printLottosNumber(Lottos lottos) {
        StringBuilder sb = new StringBuilder();
        for (Lotto lotto : lottos.getLottos()) {
            List<Integer> numbers = lotto.getNumbers();
            sb.append("[");
            addNumber(sb, numbers);
            sb.append("]");
        }
        System.out.println(sb.toString());
    }

    private static void addNumber(StringBuilder sb, List<Integer> numbers) {
        for (int i = 0; i < numbers.size(); i++) {
            sb.append(numbers.get(i));
            if (i < numbers.size() - 1) {
                sb.append(", ");
            }
        }
    }

    public static void printPurchaseAmountIs(int amount) {
        System.out.println(amount + PURCHASED_AMOUNT_IS);
    }

    public static void printInputLottoNumber() {
        System.out.println(INPUT_LOTTO_NUMBER);
    }

    public static void printInputBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER);
    }

    public static void printTotalEarningRate(double earningRate) {
        String totalEarning = String.format(TOTAL_EARNING_RATE_IS, earningRate);
        System.out.println(totalEarning);
    }

    public static void printEarningDetail() {
        System.out.println(RANK_RESULT);
        Map<Prize, Integer> prizeCountMap = IncomeCalculator.getPrizeCountMap();
        for (Map.Entry<Prize, Integer> entry : prizeCountMap.entrySet()) {
            printDetails(entry);
        }
    }

    public static void printError(String exceptionMessage){
        System.out.println(exceptionMessage);
    }

    private static void printDetails(Map.Entry<Prize, Integer> entry) {
        Prize prize = entry.getKey();
        if (prize == Prize.NONE) {
            return;
        }
        if (prize == Prize.SECOND) {
            String output = String.format(MATCH_FORMAT + BONUS_BALL_FORMAT + WINNING_FORMAT + COUNT_FORMAT,
                    prize.getCorrectCount(), prize.getWinning(), entry.getValue());
            System.out.println(output);
            return;
        }
        String output = String.format(MATCH_FORMAT + WINNING_FORMAT + COUNT_FORMAT,
                prize.getCorrectCount(), prize.getWinning(), entry.getValue());
        System.out.println(output);
    }
}
