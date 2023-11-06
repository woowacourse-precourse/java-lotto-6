package lotto.service;

import lotto.view.InputView;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoServiceTest {

    LottoService lottoService = new LottoService();

    @Test
    @DisplayName("발행 수량 구하기")
    void getLotteryTicketCount() {
        // given
        System.setIn(new ByteArrayInputStream("14000".getBytes()));
        int correctCount = 14;
        int wrongCount = 10;

        // when
        int lotteryTicketCount = lottoService.getLotteryTicketCount();

        // then
        assertThat(lotteryTicketCount).isEqualTo(correctCount);
        assertThat(lotteryTicketCount).isNotEqualTo(wrongCount);
    }

    @Test
    @DisplayName("발행하기")
    void issueLotteryTicket() {
        List<Integer> lotteryTicket = lottoService.issueLotteryTicket();
        System.out.println("lotteryTicket = " + lotteryTicket.toString());
    }
}