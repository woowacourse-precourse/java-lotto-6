package lotto.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class PrizeMessageTest {

    @Test
    @DisplayName("PrizeMessage 열거형이 주어진 순서에 맞는 메시지를 반환해야 함")
    void getMessageByOrdinal() {
        assertThat(PrizeMessage.getByOrdinal(0).getMessage()).isEqualTo("");
        assertThat(PrizeMessage.getByOrdinal(3).getMessage()).isEqualTo("3개 일치 (5,000원) - %d개\n");
        assertThat(PrizeMessage.getByOrdinal(6).getMessage()).isEqualTo("6개 일치 (2,000,000,000원) - %d개\n");
        assertThat(PrizeMessage.getByOrdinal(7).getMessage()).isEqualTo("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n");
    }

    @Test
    @DisplayName("존재하지 않는 순서에 대한 PrizeMessage 열거형을 요청하면 예외가 발생해야 함")
    void getNonExistentPrizeMessage() {
        int invalidOrdinal = 8;
        assertThatThrownBy(() -> PrizeMessage.getByOrdinal(invalidOrdinal))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR]" + invalidOrdinal);
    }

}
