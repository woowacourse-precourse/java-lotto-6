package dto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.LottoConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoMoneyDTOTest {

    @DisplayName("로또 금액 단위에 따른 에러가 올바르게 출력되는지 확인한다.")
    @Test
    void createLottoMoneyByMissmatch() {
        assertThatThrownBy(() -> {
            new LottoMoneyDTO((int) (LottoConfig.PRICE * 0.4));
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith("[ERROR]");
    }

}