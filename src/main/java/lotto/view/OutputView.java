package lotto.view;

import java.util.List;

public class OutputView {
    private static final String OUTPUT_NUMBER_OF_TICKETS = "개를 구매했습니다.";
    private static final String OUTPUT_PRIZE_RESULT = "당첨 통계";
    private static final String OUTPUT_DIVIDE = "---";
    private static final String OUTPUT_RATE = "총 수익률은 %.1f%%입니다.";

    public void printTicket(int numberOfTickets) {
        System.out.println(numberOfTickets + OUTPUT_NUMBER_OF_TICKETS);
    }

    public void printUserLottoNumbers(List<Integer> numbers) {
        System.out.println(numbers);
    }

    private void printResultHead() {
        System.out.println(OUTPUT_PRIZE_RESULT);
        System.out.println(OUTPUT_DIVIDE);
    }

    public void printPrizeResult(String prizeResult) {
        printResultHead();
        System.out.println(prizeResult);
    }

    public void printRate(double rate) {
        System.out.printf(OUTPUT_RATE, rate);
    }
}
