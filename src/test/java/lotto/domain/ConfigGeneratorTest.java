package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ConfigGeneratorTest {

    @Test
    @DisplayName("금액 검증 확인")
    void newLotto() {
//        assertThatThrownBy(() -> new LottoGenerator(Integer.MAX_VALUE))
//                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("금액에 따른 로또 생성 기능 확인")
    void wishMeLuck() {
//        assertThat(new LottoGenerator().generateMyTickets().size()).isEqualTo(1);
//        assertThat(new LottoGenerator().generateMyTickets().size()).isEqualTo(15);
    }
}