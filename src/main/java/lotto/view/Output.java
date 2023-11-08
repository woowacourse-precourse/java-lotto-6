package lotto.view;

import java.util.List;

public class Output {
    private final String LOTTO_TICEKT_AMOUNT_MESSAGE = "개를 구매했습니다.";
    private final String WINNING_RATE_INFORMATION_MESSAGE = "당첨 통계";
    private final String WINNING_RESULT_FIRST_MESSAGE = "6개 일치 (2,000,000,000원) - ";
    private final String WINNING_RESULT_SECOND_MESSAGE = "5개 일치, 보너스 볼 일치 (30,000,000원) - ";
    private final String WINNING_RESULT_THIRD_MESSAGE = "5개 일치 (1,500,000원) - ";
    private final String WINNING_RESULT_FOURTH_MESSAGE = "4개 일치 (50,000원) - ";
    private final String WINNING_RESULT_FIFTH_MESSAGE = "3개 일치 (5,000원) - ";
    private final String WINNING_RESULT_AMOUNT_MESSAGE = "개";
    private final String LINE_MESSAGE = "---";
    private final String WINNING_RATE_MESSAGE = "총 수익률은";
    private final String WINNING_RATE_END_MESSAGE = "%입니다.";

    public void printLottoTicketAmount(int ticket){
        System.out.println();
        System.out.println(ticket + LOTTO_TICEKT_AMOUNT_MESSAGE);
    }

    public void printLottoResult(List<Integer> numbers) {
        System.out.println();
        System.out.println(WINNING_RATE_INFORMATION_MESSAGE);
        System.out.println(LINE_MESSAGE);
        System.out.println((WINNING_RESULT_FIFTH_MESSAGE) + numbers.get(4) + WINNING_RESULT_AMOUNT_MESSAGE);
        System.out.println(WINNING_RESULT_FOURTH_MESSAGE + numbers.get(3) + WINNING_RESULT_AMOUNT_MESSAGE);
        System.out.println(WINNING_RESULT_THIRD_MESSAGE + numbers.get(2) + WINNING_RESULT_AMOUNT_MESSAGE);
        System.out.println(WINNING_RESULT_SECOND_MESSAGE + numbers.get(1) + WINNING_RESULT_AMOUNT_MESSAGE);
        System.out.println(WINNING_RESULT_FIRST_MESSAGE + numbers.get(0) + WINNING_RESULT_AMOUNT_MESSAGE);
    }

    public void printLottoWinningRate(int winningRate){
        System.out.println(WINNING_RATE_MESSAGE + winningRate + WINNING_RATE_END_MESSAGE);
    }

}
