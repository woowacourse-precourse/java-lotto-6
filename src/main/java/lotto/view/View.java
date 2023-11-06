package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.dto.WinningStatisticsDto;

public class View {
    public String requestPurchasePrice() {
        System.out.println(ViewMessage.REQUEST_PURCHASE_PRICE.getMessage());
        String answer = Console.readLine();
        printNewLine();
        return answer;
    }

    public String requestWinningNumber() {
        System.out.println(ViewMessage.REQUEST_WINNING_NUMBER.getMessage());
        String answer = Console.readLine();
        printNewLine();
        return answer;
    }

    public String requestBonusNumber() {
        System.out.println(ViewMessage.REQUEST_BONUS_NUMBER.getMessage());
        String answer = Console.readLine();
        printNewLine();
        return answer;
    }

    public void responsePurchaseAmount(int amount) {
        System.out.println(String.format(ViewMessage.RESPONSE_PURCHASE_AMOUNT.getMessage(), amount));
        printNewLine();
    }

    public void responseWinningStatistics() {
        System.out.println(ViewMessage.RESPONSE_WINNING_STATISTICS.getMessage());
    }

    public void responseWinningStatisticsDetail(List<WinningStatisticsDto> dtos) {
        // TODO: 구현
    }

    private void printNewLine() {
        System.out.println();
    }

}
