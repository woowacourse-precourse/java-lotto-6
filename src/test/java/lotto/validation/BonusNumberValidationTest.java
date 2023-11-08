package lotto.validation;

import lotto.domain.Lotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BonusNumberValidationTest {
    private BonusNumberValidation bonusNumberValidation;

    @BeforeEach
    void setUp() {
        bonusNumberValidation = new BonusNumberValidation();
    }

    @DisplayName("보너스 번호가 int의 범위를 벗어나면 에러가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"111111111111111", "-1000000000000"})
    void enterBonusNumberOutOfIntRange(String input) {
        assertThatThrownBy(() -> bonusNumberValidation.validateCheckRangeOfBonusNumberInput(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 음수라면 에러가 발생한다.")
    @Test
    void enterNegativeBonusNumber() {
        assertThatThrownBy(() -> bonusNumberValidation.validateBonusNumberIsPositive(-10))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 1부터 45사이의 숫자가 아니라면 에러가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 56})
    void enterBonusNumberOutOfRange1to45(Integer input) {
        assertThatThrownBy(() -> bonusNumberValidation.validateBonusNumberOutOfRange(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호와 당첨 번호가 중복되는 숫자가 있으면 에러가 발생한다.")
    @Test
    void getDuplicatedNumber() {
        Lotto lotto = new Lotto(Arrays.asList(1,2,3,4,5,6));
        int bonusNumber = 6;
        assertThatThrownBy(() -> bonusNumberValidation.validateDuplicateBonusNumber(lotto, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호를 입력하면 숫자로 반환한다.")
    @Test
    void generateBonusNumber() {
        int result = bonusNumberValidation.validateBonusNumber("12");
        int answer = Integer.parseInt("12");

        assertThat(result).isEqualTo(answer);
    }
}