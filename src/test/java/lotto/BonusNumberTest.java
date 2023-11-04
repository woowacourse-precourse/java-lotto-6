package lotto;

import lotto.model.BonusNumber;
import lotto.model.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BonusNumberTest {

    Lotto lotto = new Lotto(List.of(0, 2, 3, 4, 5, 45));

    @DisplayName("보너스 번호가 비거나 문자인 경우 에러가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new BonusNumber("", lotto))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> new BonusNumber("c", lotto))
                .isInstanceOf(IllegalArgumentException.class);
    }

}