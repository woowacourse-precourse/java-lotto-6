package lotto.service;

import static lotto.validator.ErrorMessage.INVALID_PAYMENT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.dto.LottoTicket;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoServiceTest {
    private LottoService lottoService = new LottoService();

    @DisplayName("잘못된 금액으로 구입 시 예외 발생")
    @Test
    void buyTickets() {
        assertThatThrownBy(() -> lottoService.buyTickets(1234))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_PAYMENT.message());
    }

    @DisplayName("발행 로또 정보 DTO 테스트")
    @Test
    void tickets() {
        lottoService.buyTickets(5000);

        List<LottoTicket> dtos = lottoService.tickets();

        assertThat(dtos.size()).isEqualTo(5);
        assertThat(dtos).allSatisfy(dto -> assertThat(dto.numbers()).isSorted());
    }

}
