package lotto.domain.number;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BonusLottoNumTest {
    private BonusLottoNum bonusLottoNum;

    @BeforeEach
    void setUp() {
        bonusLottoNum = new BonusLottoNum(7);
    }

    @DisplayName("보너스의 번호가 같은지 확인한다.")
    @Test
    void isSame() {
        // when
        Boolean result = bonusLottoNum.isSame(7);

        // than
        assertThat(result).isTrue();
    }
}