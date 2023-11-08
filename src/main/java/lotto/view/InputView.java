package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String INPUT_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUT_LOTTO_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";
    private static final String WINNING_STATISTICS_MESSAGE = "당첨 통계";
    private static final String WINNING_STATISTICS_DIVIDER = "---";
    private static final String WINNING_STATISTICS_FORMAT_FRONT = "총 수익률은 ";
    private static final String WINNING_STATISTICS_FORMAT_BACK = "%입니다.";

    public void close() {
        Console.close();
    }

    public void print(String message) {
        System.out.print(message);
    }

    public void println(String message) {
        System.out.println(message);
    }

    public void printlnWithoutMessage() {
        System.out.println();
    }


    public void investMoney() {
        println(INPUT_MONEY_MESSAGE);
    }
    public String readLine() {
        return Console.readLine();
    }

    public void printLottoCount(String lottoCount) {
        println(lottoCount);
    }

    public void inputWinningNumber() {
        println(INPUT_LOTTO_NUMBER_MESSAGE);
    }

    public void inputBonusNumber() {
        println(INPUT_BONUS_NUMBER_MESSAGE);
    }

    public void printWinningStatistics() {
        printlnWithoutMessage();
        println(WINNING_STATISTICS_MESSAGE);
        println(WINNING_STATISTICS_DIVIDER);
    }

    public void printEarnRate(double earnRate) {
        print(WINNING_STATISTICS_FORMAT_FRONT + earnRate + WINNING_STATISTICS_FORMAT_BACK);
    }
}
