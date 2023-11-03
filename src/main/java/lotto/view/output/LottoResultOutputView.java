package lotto.view.output;

import lotto.message.LottoResultMessage;

public class LottoResultOutputView {

    public void printWinningStatisticsStartMessage() {
        System.out.println(LottoResultMessage.WINNING_STATISTICS);
    }

    public void printDashLine() {
        System.out.println(LottoResultMessage.DASH_LINE);
    }

    public void printLottoAllMatch() {
        printThreeLottoMatch();
        printFourLottoMatch();
        printFiveLottoMatch();
        printFiveLottoMatchWithBonus();
        printSixLottoMatch();
    }

    private void printThreeLottoMatch() {
        System.out.print(LottoResultMessage.THREE_MATCH_FORMAT);
    }
    private void printFourLottoMatch() {
        System.out.print(LottoResultMessage.FOUR_MATCH_FORMAT);
    }
    private void printFiveLottoMatch() {
        System.out.print(LottoResultMessage.FIVE_MATCH_FORMAT);
    }
    private void printFiveLottoMatchWithBonus() {
        System.out.print(LottoResultMessage.FIVE_MATCH_WITH_BONUS_FORMAT);
    }
    private void printSixLottoMatch() {
        System.out.print(LottoResultMessage.SIX_MATCH_FORMAT);
    }
}
