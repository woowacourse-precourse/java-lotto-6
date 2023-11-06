package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.Iterator;
import lotto.model.Lotto;
import lotto.utils.Message;

public class View {
    public void displayPurchaseAmountMessage() {
        System.out.println(Message.PURCHASE_AMOUNT_MESSAGE);
    }

    public void displayWinningNumberMessage() {
        System.out.println(Message.LOTTO_NUMBER_MESSAGE);
    }

    public void displayBonusNumberMessage() {
        System.out.println(Message.BONUS_NUMBER_MESSAGE);
    }

    public void displayWinningStatisticsMessage() {
        System.out.println(Message.WINNING_STATISTICS_MESSAGE);
    }

    public void displayLottos(Iterator<Lotto> lottoIterator) {
        while (lottoIterator.hasNext()) {
            System.out.println(lottoIterator.next());
        }
    }

    public void displayIssuedLottoCount(int lottoCount) {
        System.out.println(lottoCount + "개를 구매했습니다.");
    }

    private String getUserInput() {
        return readLine();
    }

    public String getPurchaseAmount() {
        return getUserInput();
    }

    public String getWinningNumbers() {
        return getUserInput();
    }

    public String getBonusNumber() {
        return getUserInput();
    }

    public void displayWinningStatistics(String statistics) {
        System.out.println(statistics);
    }
}
