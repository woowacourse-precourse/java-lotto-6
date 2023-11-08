package view;

import domain.CorrectNumbers;
import enums.ExceptionMessage;
import enums.Message;
import java.util.List;

public class OutputView {

    public void printRequirelottoCost() {
        System.out.println(Message.REQUIRE_PURCHASE_MONEY.getMessage());
    }

    public void printPublishedLotto(int lottoPaper) {
        System.out.printf("%d%s\n", lottoPaper, Message.PUBLISHED_LOTTO.getMessage());
    }

    public void printMyLottoNumber(List<Integer> myLottoNumber) {
        System.out.println(myLottoNumber);
    }

    public void printRequireWinningNumber() {
        printNewLine();
        System.out.println(Message.REQUIRE_WINNING_NUMBER.getMessage());
    }

    public void printRequireBonusNumber() {
        printNewLine();
        System.out.println(Message.REQUIRE_BONUS_NUMBER.getMessage());
    }

    public void printWinningStat() {
        printNewLine();
        System.out.println(Message.WINNING_STATISTICS.getMessage());
        printSplitLine();
    }

    public void printMatchResult(CorrectNumbers correctNumbers, int prize, int lottoPaper) {
        System.out.printf("%s%d개\n", Message.CORRECT_NUMBER_3.getMessage(),
            correctNumbers.matchThree);
        System.out.printf("%s%d개\n", Message.CORRECT_NUMBER_4.getMessage(),
            correctNumbers.matchFour);
        System.out.printf("%s%d개\n", Message.CORRECT_NUMBER_5.getMessage(),
            correctNumbers.matchFive);
        System.out.printf("%s%d개\n", Message.CORRECT_NUMBER_5_AND_BONUS.getMessage(),
            correctNumbers.matchFiveAndBonus);
        System.out.printf("%s%d개\n", Message.CORRECT_NUMBER_6.getMessage(),
            correctNumbers.matchSix);
        System.out.printf("%s%.1f%%입니다.", Message.TOTAL_PROFIT_RATE.getMessage(),
            printTotalProfitRate(prize, lottoPaper));
    }

    public double printTotalProfitRate(int prize, int lottoPaper) {
        return (double) prize / (lottoPaper * 1000) * 100;
    }

    public void printNewLine() {
        System.out.print(Message.NEW_LINE.getMessage());
    }

    public void printSplitLine() {
        System.out.println(Message.SPLIT_LINE.getMessage());
    }

    public void printIlligalLottoCostMessage() {
        System.out.println(ExceptionMessage.ILLIGAL_COST_ERROR_MESSAGE.getMessage());
    }

    public void printIlligalWinningNumberMessage() {
        System.out.println(ExceptionMessage.ILLIGAL_WINNING_NUM_MESSAGE.getMessage());
    }

    public void printIlligalBonusNumberMessage() {
        System.out.println(ExceptionMessage.ILLIGAL_BONUS_NUM_MESSAGE.getMessage());
    }
}
