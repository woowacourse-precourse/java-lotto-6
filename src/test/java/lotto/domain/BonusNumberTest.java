package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BonusNumberTest {
    @DisplayName("보너스넘버는 1이상 45 이하의 숫자여야 한다.")
    @Test
    void createBonusNumber() {
        //given, when
        BonusNumber bonusNumber = BonusNumber.from(1);

        // then
        assertThat(bonusNumber).isNotNull();
        assertThat(bonusNumber.getNumber()).isBetween(1, 45);
        assertThat(bonusNumber.getNumber()).isEqualTo(1);
    }

    @ParameterizedTest(name = "[{index}] 보너스 넘버가 ''{0}'' 이면 예외 발생한다.")
    @ValueSource(ints = {47, 0, -1})
        //when, then
    void cannotCreateBonusNumber(int element) {
        assertThatThrownBy(() -> BonusNumber.from(element))
                .isInstanceOf(IllegalArgumentException.class);
    }
}