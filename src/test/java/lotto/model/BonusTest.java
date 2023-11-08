package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BonusTest {

    @DisplayName("보너스 숫자가 1부터 45가 아니라면 예외가 발생한다.")
    @ParameterizedTest(name = "{displayName} value : {0}")
    @ValueSource(ints = {0, 46, 1000})
    void createOutOfRange(Integer value) {
        assertThatThrownBy(() -> new Bonus(value))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 숫자와 로또 숫자가 겹치면 True를 반환한다.")
    @ParameterizedTest(name = "{displayName} value : {0}")
    @ValueSource(ints = {1, 2, 3, 4, 5, 6})
    void checkBonusContainsLottoNumbers(Integer bonusNumber) {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Bonus bonus = new Bonus(bonusNumber);
        assertThat(bonus.hasBonusNumber(lotto)).isTrue();
    }

    @DisplayName("보너스 숫자와 로또 숫자가 겹치면 False를 반환한다.")
    @ParameterizedTest(name = "{displayName} value : {0}")
    @ValueSource(ints = {7, 10, 45})
    void checkBonusNotContainsLottoNumbers(Integer bonusNumber) {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Bonus bonus = new Bonus(bonusNumber);
        assertThat(bonus.hasBonusNumber(lotto)).isFalse();
    }
}
