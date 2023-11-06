package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BonusNumberTest {

    @DisplayName("당첨번호와 중복된 번호를 입력한 경우")
    @Test
    public void bonusNumberDuplicated() {
        Lotto userLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThatThrownBy(() -> new BonusNumber(2, userLotto))
                .isInstanceOf(IllegalStateException.class);
    }

}