package lotto.domain.customer;

import static lotto.domain.result.LottoRank.FIFTH;
import static lotto.domain.result.LottoRank.FIRST;
import static lotto.domain.result.LottoRank.FOURTH;
import static lotto.domain.result.LottoRank.SECOND;
import static lotto.domain.result.LottoRank.THIRD;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import lotto.domain.checker.Checker;
import lotto.domain.money.Money;
import lotto.domain.result.LottoRank;
import lotto.domain.result.WinResult;
import lotto.domain.seller.Seller;
import lotto.domain.ticket.Ticket;
import lotto.util.reader.InputReader;

public class LottoCustomer implements Customer {
        private final InputReader inputReader;
        private Ticket ticket;

        public LottoCustomer(InputReader inputReader) {
                this.inputReader = inputReader;
        }

        @Override
        public void buyTicket(Seller seller) {
                Money payment = new Money(new BigDecimal(inputReader.readLine()));
                ticket = seller.sellTo(payment);
        }

        @Override
        public void checkLottoResult(Checker checker) {
                WinResult winResult = checker.checkTicket(ticket);
                readResult(winResult);
        }

        private void readResult(WinResult result) {
                Map<LottoRank, Integer> ranks = result.getRanks();
                BigDecimal rateOfReturn = result.getRateOfReturn();
                System.out.println("\n당첨 통계");
                System.out.println("---");

                for (LottoRank rank : List.of(FIFTH, FOURTH, THIRD, SECOND, FIRST)) {
                        Integer value = ranks.get(rank);
                        String priceFormat = String.format("%,d", rank.getPrizes().longValue());
                        System.out.println(rank + " (" + priceFormat + "원) - " + value + "개");
                }

                System.out.println("총 수익률은 " + String.format("%.1f", rateOfReturn) + "%입니다.");
        }

        // todo 필요할까? 테스트 확인을 위해서?
        public Ticket getTicket() {
                return ticket;
        }
}
