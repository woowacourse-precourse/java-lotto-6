package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BonusTest {

    private static final Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));

    @DisplayName("보너스 번호가 정답 로또와 중복되면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedBonusNumber() {
        // given
        int duplicatedBonusNumber = 1;

        // when & then
        assertThatThrownBy(() -> new Bonus(duplicatedBonusNumber, lotto))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 범위를 벗어나면 예외가 발생한다.")
    @Test
    void createLottoByOutOfRangeBonusNumber() {
        // given
        int outOfRangeBonusNumber = 46;

        // when & then
        assertThatThrownBy(() -> new Bonus(outOfRangeBonusNumber, lotto))
                .isInstanceOf(IllegalArgumentException.class);
    }

}