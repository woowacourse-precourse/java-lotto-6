import static camp.nextstep.edu.missionutils.Console.readLine;

public class View {


    public void displayPurchaseAmountMessage() {
        System.out.println(Message.PURCHASE_AMOUNT_MESSAGE);
    }

    public void displayLottoNumberMessage() {
        System.out.println(Message.LOTTO_NUMBER_MESSAGE);
    }

    public void displayBonusNumberMessage() {
        System.out.println(Message.BONUS_NUMBER_MESSAGE);
    }

    public void displayWinningStatisticsMessage() {
        System.out.println(Message.WINNING_STATISTICS_MESSAGE);
    }

    private String getUserInput() {
        return readLine();
    }

    public String getPurchaseAmount() {
        return getUserInput();
    }

    public String getLottoNumbers() {
        return getUserInput();
    }

    public String getBonusNumber() {
        return getUserInput();
    }
}
