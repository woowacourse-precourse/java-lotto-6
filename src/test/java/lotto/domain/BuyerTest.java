package lotto.domain;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BuyerTest {
    @Test
    @DisplayName("Buyer 객체 생성 - 사용자가 입력하는 금액과 같은지")
    public void createBuyer() {
        int payment = 10000;
        int ticketCnt = 10;
        Buyer buyer = new Buyer(payment, ticketCnt);

        int result = buyer.getPayment();

        assertThat(result).isEqualTo(payment);
    }

    @Test
    @DisplayName("Buyer 객체 생성 - 금액의 1000단위로 ticket을 나눈게 맞는지")
    public void getTicketCnt_ReturnsTicketCount() {
        int payment = 10000;
        int ticketCnt = 10;
        Buyer buyer = new Buyer(payment, ticketCnt);

        int result = buyer.getTicketCnt();

        assertThat(result).isEqualTo(ticketCnt);
    }

    @Test
    @DisplayName("Buyer 객체 생성 - 금액의 1000단위로 ticket을 나눠서 Lotto객체 생성한게 맞는지")
    public void getLotto_ReturnsListOfLotto() {
        int payment = 10000;
        int ticketCnt = 10;
        Buyer buyer = new Buyer(payment, ticketCnt);

        List<Lotto> lottos = buyer.getLotto();

        assertThat(lottos).hasSize(ticketCnt);
    }

    @Test
    @DisplayName("totalEarning메서드 테스트 - 총 수익이 Buyer객체 변수에 업데이트 되는지")
    public void getEarningPrize_ReturnsEarningPrize() {
        int payment = 10000;
        int ticketCnt = 10;
        Buyer buyer = new Buyer(payment, ticketCnt);
        int earningPrize = 5000;
        buyer.totalEarning(earningPrize);

        float result = buyer.getEarningPrize();

        assertThat(result).isEqualTo(earningPrize);
    }
}