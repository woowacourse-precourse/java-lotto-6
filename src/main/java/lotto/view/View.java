package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import lotto.model.Observable;
import lotto.utils.Message;

public class View implements Observer {
    public View(Observable observable) {
        observable.subscribe(this);
    }

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

    public void displayLottoCount(int lottoCount) {
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

    @Override
    public void update(Object o) {
        System.out.println(o);
    }
}
