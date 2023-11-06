package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BonusNumberTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 45})
    @DisplayName("보너스 번호를 생성할 수 있다.")
    void createBonusNumber(int number) {
        BonusNumber bonusNumber = new BonusNumber(number);
        assertThat(bonusNumber).isEqualTo(new BonusNumber(number));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    @DisplayName("보너스 번호를 생성할 수 있다.")
    void invalidBonusNumber(int number) {
        assertThatThrownBy(() -> new BonusNumber(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
    }
}