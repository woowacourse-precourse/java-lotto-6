package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class BonusNumberTest {
    String input;

    @DisplayName("보너스넘버는 1이상 45 이하의 숫자여야 한다.")
    @Test
    void createBonusNumber() {
        // given
        input = "1";

        // when
        BonusNumber bonusNumber = BonusNumber.create(input);

        // then
        assertThat(bonusNumber).isNotNull();
    }

    @DisplayName("보너스넘버가 공백이면 예외 발생한다.")
    @Test
    void cannotCreateBonusNumber_blank() {
        // given
        input = "";

        // when, then
        assertThatThrownBy(() -> BonusNumber.create(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스넘버가 숫자가 아니면 예외 발생한다.")
    @Test
    void cannotCreateBonusNumber_notNumeric() {
        // given
        input = "ㅈㄷ";

        // when, then
        assertThatThrownBy(() -> BonusNumber.create(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스넘버가 1이상 45이하가 아니면 예외 발생한다.")
    @Test
    void cannotCreateBonusNumber_invalidRange1() {
        // given
        input = "47";

        // when, then
        assertThatThrownBy(() -> BonusNumber.create(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스넘버가 1이상 45이하가 아니면 예외 발생한다.")
    @Test
    void cannotCreateBonusNumber_invalidRange2() {
        // given
        input = "0";

        // when, then
        assertThatThrownBy(() -> BonusNumber.create(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}