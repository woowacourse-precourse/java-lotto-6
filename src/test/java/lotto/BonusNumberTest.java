package lotto;

import lotto.model.BonusNumber;
import lotto.model.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BonusNumberTest {

    Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

    @DisplayName("보너스 번호가 비거나 문자인 경우 에러가 발생한다.")
    @Test
    void createBonusNumberByIncludingNotNumber() {
        assertThatThrownBy(() -> new BonusNumber("", lotto))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> new BonusNumber("c", lotto))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호는 당첨 번호와 겹치는 경우 에러가 발생한다.")
    @Test
    void createBonusNumberByOverlappingWinningNumbers() {
        assertThatThrownBy(() -> new BonusNumber("2", lotto))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> new BonusNumber("5", lotto))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 1보다 작거나 45보다 클 경우 예외가 발생한다.")
    @Test
    void createBonusNumberOutOfRange() {
        assertThatThrownBy(() -> new BonusNumber("0", lotto))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> new BonusNumber("46", lotto))
                .isInstanceOf(IllegalArgumentException.class);
    }

}