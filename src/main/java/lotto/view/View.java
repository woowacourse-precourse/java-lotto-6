package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.domain.Lotto;
import lotto.dto.WinningStatisticsDto;
import lotto.service.WinningPolicy;

public class View {

    private View() {
    }

    public static String requestPurchasePrice() {
        System.out.println(ViewMessage.REQUEST_PURCHASE_PRICE.getMessage());
        String answer = Console.readLine();
        printNewLine();
        return answer;
    }

    public static String requestWinningNumber() {
        System.out.println(ViewMessage.REQUEST_WINNING_NUMBER.getMessage());
        String answer = Console.readLine();
        printNewLine();
        return answer;
    }

    public static String requestBonusNumber() {
        System.out.println(ViewMessage.REQUEST_BONUS_NUMBER.getMessage());
        String answer = Console.readLine();
        printNewLine();
        return answer;
    }

    public static void responseLottoNumbers(List<Lotto> lottos, int lottoCount) {
        System.out.println(String.format(ViewMessage.RESPONSE_PURCHASE_AMOUNT.getMessage(), lottoCount));
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
        printNewLine();
    }

    public static void responseWinningStatistics(List<WinningStatisticsDto> dtos) {
        System.out.println(ViewMessage.RESPONSE_WINNING_STATISTICS.getMessage());
        for (WinningStatisticsDto dto : dtos) {
            String bonusMatch = "";
            if (dto.winningPolicy() == WinningPolicy.SECOND) {
                bonusMatch = ", 보너스 볼 일치";
            }
            System.out.println(String.format(ViewMessage.RESPONSE_WINNING_STATISTICS_DETAIL.getMessage(),
                    dto.winningPolicy().getMatchCount(),
                    bonusMatch,
                    String.format("%,d", dto.winningPolicy().getAmount()),
                    dto.matchCount()));
        }
    }

    public static void responseEarningRate(double earningRate) {
        System.out.println(String.format(ViewMessage.RESPONSE_TOTAL_EARNINGS.getMessage(), earningRate));
    }

    public static void responseErrorMessage(String message) {
        System.out.println(message);
    }

    private static void printNewLine() {
        System.out.println();
    }

}
