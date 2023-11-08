package lotto.view;

import lotto.domain.Lotto;

import java.math.BigDecimal;
import java.util.List;

import static lotto.consts.ConstsString.TICKET_COUNT;

public class OutputView {

    private static final String WINNING_STATISTICS_TITLE = "당첨 통계";
    private static final String SEPARATOR = "---";
    private static final String RATE_OF_RETURN_MESSAGE = "총 수익률은 %s%%입니다.";
    public void displayErrorMessage(Exception e){
        System.out.println(e.getMessage());
    }

    public void displayWinningLotto(String winnerStatistics) {
        System.out.println(WINNING_STATISTICS_TITLE);
        System.out.println(SEPARATOR);
        System.out.print(winnerStatistics);
    }

    public void displayRateOfReturn(BigDecimal yield) {
        System.out.printf(RATE_OF_RETURN_MESSAGE, yield);
    }

    public void displayLottoNumbers(List<Lotto> lotto){
        for(Lotto number : lotto){
            System.out.println(number.getNumbers());
        }
    }

    public void displayTicketCount(int ticketCount){
        System.out.printf(TICKET_COUNT,ticketCount);
        System.out.println();
    }
}