package lotto.validator;

import lotto.TestConstant;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import java.util.Arrays;

class BonusNumberValidatorTest {

    @DisplayName("유효한 보너스 번호가 올바르게 실행된다.")
    @Test
    void 유효한_보너스_번호_테스트() {
        int validBonusNumber = 7;
        assertThat(BonusNumberValidator.validate(String.valueOf(validBonusNumber))).isEqualTo(validBonusNumber);
    }

    @DisplayName("잘못된 형식의 보너스 번호 입력 시 예외가 발생한다.")
    @Test
    void 잘못된_보너스_번호_형식_예외_발생() {
        String invalidBonusNumber = "abc";
        assertThatThrownBy(() -> BonusNumberValidator.validate(invalidBonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(TestConstant.ERROR_MESSAGE);
    }

    @DisplayName("범위를 벗어난 보너스 번호 입력 시 예외가 발생한다.")
    @Test
    void 범위_벗어난_보너스_번호_예외_발생() {
        int outOfRangeBonusNumber = 46;
        assertThatThrownBy(() -> BonusNumberValidator.validate(String.valueOf(outOfRangeBonusNumber)))
                .isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining(TestConstant.ERROR_MESSAGE);
    }

    @DisplayName("당첨 번호 내에 이미 존재하는 보너스 번호 입력 시 예외가 발생한다.")
    @Test
    void 당첨_번호_중복_보너스_번호_예외_발생() {
        int duplicateBonusNumber = 15;
        assertThatThrownBy(() -> BonusNumberValidator.validate(duplicateBonusNumber, Arrays.asList(1, 3, 5, 7, 9, 15)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(TestConstant.ERROR_MESSAGE);
    }
}
