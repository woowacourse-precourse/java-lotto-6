package lotto.domain;

import lotto.Lotto;
import lotto.LottoTicket;

import java.util.List;

public class LottoOutput {
    public enum LottoMessage {
        PURCHASE_AMOUNT_MESSAGE("구입금액을 입력해 주세요."),
        PURCHASE_COUNT_MESSAGE("개를 구매했습니다."),
        REQUEST_WINNING_NUMBERS("당첨 번호를 입력해 주세요."),
        REQUEST_BOUNS_NUMBERS("보너스 번호를 입력해 주세요."),
        WINNING_STATS_HEADER("당첨 통계 \n---");

        private String message;

        LottoMessage(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }

    public LottoOutput() {
    }

    public void purchaseAmountMessage() {
        System.out.println(LottoMessage.PURCHASE_AMOUNT_MESSAGE.getMessage());
    }

    public void purchaseCountMessage(int ticketCount) {
        System.out.println(ticketCount + LottoMessage.PURCHASE_COUNT_MESSAGE.getMessage());
    }

    public void requestWinningNumbers() {
        System.out.println(LottoMessage.REQUEST_WINNING_NUMBERS.getMessage());

    }

    public void requestBounsNumbers() {
        System.out.println(LottoMessage.REQUEST_BOUNS_NUMBERS.getMessage());

    }

    public void printTickets(List<LottoTicket> userLottoTickets) {
        for (LottoTicket ticket : userLottoTickets) {
            System.out.println(ticket.getNumbers());
        }
    }


}
