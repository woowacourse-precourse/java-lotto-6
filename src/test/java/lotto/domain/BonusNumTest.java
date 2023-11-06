package lotto.domain;

import lotto.model.domain.BonusNum;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BonusNumTest {

    @DisplayName("보너스 숫자 확인 테스트")
    @Test
    public void getBonusNumTest() throws Exception {
        // given
        BonusNum bonusNum = new BonusNum(7);

        // when, then
        assertThat(bonusNum.getBonusNum()).isEqualTo(7);
    }
}
