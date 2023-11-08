package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoBonusNumberTest {

    @DisplayName("보너스 번호의 범위가 1~45가 아니면 예외가 발생한다.")
    @Test
    void createBonusNumberByWrongRange() {
        assertThatThrownBy(() -> new LottoBonusNumber(0, List.of(1, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new LottoBonusNumber(46, List.of(1, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호에 보너스 번호와 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createBonusNumberByDuplicatedNumber() {
        assertThatThrownBy(() -> new LottoBonusNumber(1, List.of(1, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호와 보너스 번호를 비교했을 때 일치하는 번호가 있는지 확인한다.")
    @Test
    void includesBonusNumber() {
        LottoBonusNumber bonusNumber = new LottoBonusNumber(1, List.of(2, 3, 4, 5, 6, 7));

        boolean result1 = bonusNumber.includesBonusNumber(List.of(1, 2, 3, 4, 5, 6));
        boolean result2 = bonusNumber.includesBonusNumber(List.of(2, 3, 4, 5, 6, 7));

        assertThat(result1).isTrue();
        assertThat(result2).isFalse();
    }
}