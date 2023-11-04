package lotto.model.domain;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

import java.util.AbstractSet;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTicketTest {

    @DisplayName("금액이 나누어 떨어지지 않으면 예외가 발생한다.")
    @Test
    void createLottoTicketAmount() {
        assertThatThrownBy(() -> new LottoTicket(14500))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("금액에 맞게 로또가 생성되지 않으면 테스트가 실패한다.")
    @Test
    void createLottoTicketSize() {
        // Arrange
        int price = 5000;
        int count = 5;
        LottoTicket lottoTicket = new LottoTicket(price);
        // Act
        List<Lotto> lottos = lottoTicket.getLottoTicket();
        // Assert
        assertThat(lottos).size().isEqualTo(count);
    }
}