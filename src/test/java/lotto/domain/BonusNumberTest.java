package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BonusNumberTest {
    @DisplayName("1 ~ 45 사이 수를 입력받으면 보너스 넘버가 성생되어야 한다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 45, 33})
    void createBonusNumberTest(int input) {
        // given
        BonusNumber bonusNumber = new BonusNumber(input);

        // when, then
        assertAll(() -> {
            assertThatNoException()
                    .isThrownBy(() -> new BonusNumber(input));
            assertThat(new BonusNumber(input))
                    .isEqualTo(bonusNumber);
        });
    }

    @DisplayName("1 ~ 45 사이 수가 아닐 경우 예외가 발생해야 한다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 46, 100})
    void validateOutOfRangeTest(int input) {
        // when, then
        assertThatThrownBy(() -> new BonusNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 1 ~ 45 범위의 숫자만 입력 가능합니다.");
    }
}