package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoGeneratorTest {

    @Test
    @DisplayName("금액 검증 확인")
    void newLotto() {
        assertThatThrownBy(() -> new LottoGenerator(Integer.MAX_VALUE))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("금액에 따른 로또 생성 기능 확인")
    void wishMeLuck() {
        assertThat(new LottoGenerator(1000).generateMyTickets().size()).isEqualTo(1);
        assertThat(new LottoGenerator(15000).generateMyTickets().size()).isEqualTo(15);

    }
}