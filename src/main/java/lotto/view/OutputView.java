package lotto.view;

import java.util.List;
import lotto.constant.LottoConstant;
import lotto.domain.Lotto;
import lotto.error.ErrorMessage;

public class OutputView {
    private static String LOTTO_PURCHASE_AMOUNT_INPUT_MESSAGE = "구매금액을 입력해 주세요.";
    private static String LOTTO_PURCHASE_COUNT_MESSAGE = "개를 구매했습니다.";
    private static String WINNING_NUMBER_INPUT_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static String BONUS_NUMBER_INPUT_MESSAGE = "보너스 번호를 입력해 주세요.";
    private static String RESULT_STARTING_MESSAGE = "당첨 통계\n---";
    private static String ERROR_STARTING_MESSAGE = "[ERROR] ";
    private static String FIRST_RANK_MESSAGE = "6개 일치 (2,000,000,000원) - %s개";
    private static String SECOND_RANK_MESSAGE = "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개";
    private static String THIRD_RANK_MESSAGE = "5개 일치 (1,500,000원) - %d개";
    private static String FOURTH_RANK_MESSAGE = "4개 일치 (50,000원) - %d개";
    private static String FIFTH_RANK_MESSAGE = "3개 일치 (5,000원) - %d개";
    private static String REVENUE_MESSAGE  = "총 수익률은 %.1f%%입니다.";

    public void printPurchaseInputMessage() {
        System.out.println(LOTTO_PURCHASE_AMOUNT_INPUT_MESSAGE);
    }

    public void printPurchaseCountMessage(int number) {
        System.out.print(number);
        System.out.println(LOTTO_PURCHASE_COUNT_MESSAGE);
    }

    public void printWinningNumberInputMessage() {
        System.out.println(WINNING_NUMBER_INPUT_MESSAGE);
    }

    public void printBonusNumberInputMessage() {
        System.out.println(BONUS_NUMBER_INPUT_MESSAGE);
    }

    public void printResultStringMessage() {
        System.out.println(RESULT_STARTING_MESSAGE);
    }

    public void printErrorMessage(ErrorMessage errorMessage) {
        System.out.println(ERROR_STARTING_MESSAGE + errorMessage.getMessage());
    }

    public void printLottoNumber(List<Integer> numbers) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for (int i = 0; i < numbers.size() - 1; i++) {
            stringBuilder.append(numbers.get(i) + ", ");
        }
        stringBuilder.append(numbers.get(numbers.size()-1) + "]");
        System.out.println(stringBuilder.toString());
    }

    public void println() {
        System.out.println();
    }

    public void printLottoResult(int rankCount, int rank) {
        if (rank == 5) {
            System.out.println(String.format(FIFTH_RANK_MESSAGE, rankCount));
        }
        if (rank == 4) {
            System.out.println(String.format(FOURTH_RANK_MESSAGE, rankCount));
        }
        if (rank == 3) {
            System.out.println(String.format(THIRD_RANK_MESSAGE, rankCount));
        }
        if (rank == 2) {
            System.out.println(String.format(SECOND_RANK_MESSAGE, rankCount));
        }
        if (rank == 1) {
            System.out.println(String.format(FIRST_RANK_MESSAGE, rankCount));
        }
    }

    public void printRevenue(float revenue) {
        System.out.println(String.format(REVENUE_MESSAGE, revenue));
    }
}
