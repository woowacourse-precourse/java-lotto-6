package lotto.view.output;

import java.util.Arrays;
import java.util.List;

public class ConsoleOutputView implements OutputView {
    private final String purchaseMessage = "개를 구매했습니다.";
    private final String profitMessage = "총 수익률은 %.1f%%입니다.";
    private final List<String> resultMessages = Arrays.asList(
            "3개 일치 (5,000원) - %d개",
            "4개 일치 (50,000원) - %d개",
            "5개 일치 (1,500,000원) - %d개",
            "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개",
            "6개 일치 (2,000,000,000원) - %d개");

    @Override
    public void printNewLine() {
        System.out.println();
    }

    @Override
    public void printLottoQuantity(int purchaseResult) {
        printNewLine();
        System.out.println(purchaseResult + purchaseMessage);
    }

    @Override
    public void printPurchasedLotto(List<Integer> lotto) {
        System.out.println(lotto);
    }

    @Override
    public void printGameResults(List<Integer> gameResults) {
        for(int index = 0; index < gameResults.size(); index++) {
            System.out.println(String.format(resultMessages.get(index), gameResults.get(index)));
        }
    }

    @Override
    public void printGameProfit(double profit) {
        System.out.println(String.format(profitMessage, profit));
    }
}
