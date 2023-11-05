package lotto.view;

import static lotto.constants.Message.CONTOUR;
import static lotto.constants.Message.PROFIT_RATE;
import static lotto.constants.Message.WINNING_HEADER;

import java.util.List;
import lotto.constants.Message;
import lotto.domain.Lotto;
import lotto.dto.WinningResult;

public class OutputView {
    public void printLottoTickets(List<Lotto> lottoTickets) {
        System.out.printf(Message.PURCHASE_AMOUNT.getMessage(), lottoTickets.size());
        for (Lotto lottoTicket : lottoTickets) {
            System.out.println(lottoTicket.toString());
        }
    }

    public void printWinningResult(WinningResult lottoResult) {
        System.out.println(WINNING_HEADER.getMessage());
        System.out.println(CONTOUR.getMessage());
        System.out.println(lottoResult.toString());
    }

    public void printProfitRate(double profit) {
        System.out.printf(PROFIT_RATE.getMessage(), profit);
    }

    public void printErrorCode(String message) {
        System.out.println(message);
    }
}
