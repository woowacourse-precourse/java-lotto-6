package lotto.domain;

import lotto.Lotto;
import lotto.LottoTicket;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
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

    public enum ResultMessage {
        THREE_MATCH(3, "3개 일치 (5,000원)"),
        FOUR_MATCH(4, "4개 일치 (50,000원"),
        FIVE_MATCH(5, "5개 일치 (1,500,000원)"),
        FIVE_PLUS_BONUS_MATCH(6, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
        SIX_MATCH(7, "6개 일치 (2,000,000,000원)");

        private String message;
        private int matchCount;

        ResultMessage(int matchCount, String message) {
            this.matchCount = matchCount;
            this.message = message;
        }

        public String getMessage() {
            return message;
        }

        public static String getMessageForMatchCount(int count) {
            for (ResultMessage result : ResultMessage.values()) {
                if (result.matchCount == count) {
                    return result.getMessage();
                }
            }
            return "일치하는 결과가 없습니다.";
        }
    }

    public void printResults(List<Integer> lottoResult, String totalYield) {
        System.out.println(LottoMessage.WINNING_STATS_HEADER.getMessage());
        for (int count = 3; count < lottoResult.size(); count++) {
            String printResult = "";
            printResult = ResultMessage.getMessageForMatchCount(count);
            System.out.println(printResult + " - " + lottoResult.get(count) + "개");
        }
        System.out.println("총 수익률은 " + totalYield +"% 입니다.");
    }
}
