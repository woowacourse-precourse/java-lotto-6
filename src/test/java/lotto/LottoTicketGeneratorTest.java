package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoTicketGeneratorTest {
    private LottoTicketGenerator lottoTicketGenerator;

    @BeforeEach
    void createLottoTicketGenerator() {
        lottoTicketGenerator = new LottoTicketGenerator();
    }

    @DisplayName("지불금액이 1000원 단위가 아닐 때")
    @Test
    void validatePaymentUnit() {
        assertThatThrownBy(() -> lottoTicketGenerator.generate(new Payment("999")))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 한번 구입시 최대 금액 초과")
    @Test
    void validatePaymentLimit() {
        assertThatThrownBy(() -> lottoTicketGenerator.generate(new Payment("100001")))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
