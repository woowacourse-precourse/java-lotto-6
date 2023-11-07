package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BonusNumberTest {

    @DisplayName("보너스 번호를 입력하면 입력한 값을 가진 객체가 생성된다.")
    @Test
    void shouldCreateBonusNumberWithValidInputBonusNumber() {
        //given
        String inputBonusNumber = "35";

        //when
        BonusNumber bonusNumber = new BonusNumber(inputBonusNumber);

        //then
        assertThat(bonusNumber.number()).isEqualTo(35);
    }

    @DisplayName("숫자 이외의 다른 문자나 특수문자를 입력하면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {" 1", "one", "1,", "30.0"})
    void throwsExceptionForInvalidCharactersInBonusNumber(String inputNumber) {
        assertThatThrownBy(() -> new BonusNumber(inputNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @DisplayName("보너스 번호는 1 ~ 45 내의 숫자가 아니면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"-1", "0", "46"})
    void shouldCreateBonusNumberWithNumberInRange1To45(String inputNumber) {
        assertThatThrownBy(() -> new BonusNumber(inputNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }
}