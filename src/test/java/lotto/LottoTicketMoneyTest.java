package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoTicketMoneyTest {
    @DisplayName("1000원으로 나눠 떨어지지 않는 금액 입력 시 예외 발생.")
    @Test
    void LottoTicketMoney_test() {
        assertThatThrownBy(() -> new LottoTicketMoney(1234))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 티켓 발행 수 확인")
    @Test
    void calculateTicketNumber() {
        LottoTicketMoney lottoTicketMoney = new LottoTicketMoney(3000);
        assertThat(lottoTicketMoney.calculateTicketNumber())
                .isEqualTo(3);
    }
}
