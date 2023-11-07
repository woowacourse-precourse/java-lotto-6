package lotto;


import lotto.model.ResultLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ResultLottoTest {

    @DisplayName("보너스 번호가 음수면 오류가 발생한다.")
    @Test
    void checkBonusNumUnderRange() {
        assertThatThrownBy(() -> new ResultLotto(List.of(1, 2, 3, 4, 5), 0))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 45보다 크면 오류가 발생한다.")
    @Test
    void checkBonusNumUpRange() {
        assertThatThrownBy(() -> new ResultLotto(List.of(1, 2, 3, 4, 5), 46))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 로또 번호와 겹치면 오류가 발생한다.")
    @Test
    void checkBonusNumDuplicate() {
        assertThatThrownBy(() -> new ResultLotto(List.of(1, 2, 3, 4, 5), 4))
                .isInstanceOf(IllegalArgumentException.class);
    }


}
