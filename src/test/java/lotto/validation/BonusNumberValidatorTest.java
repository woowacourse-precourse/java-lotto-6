package lotto.validation;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BonusNumberValidatorTest {
    private List<Integer> lottoNumbers;

    @BeforeEach
    void setUp() {
        lottoNumbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
    }

    @Test
    @DisplayName("보너스 넘버가 로또 번호와 겹치는 경우 예외 처리 테스트")
    void bonusDuplicationTest() {
        //given
        int bonusNumber = 1;
        //then
        assertThatThrownBy(() -> BonusNumberValidator.validate(lottoNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] ");
    }

    @ParameterizedTest
    @ValueSource(ints = {-10, 0, 46})
    @DisplayName("bonusNumber가 1 ~ 45 범위의 숫자가 아닌경우 예외 처리 테스트")
    void zeroNumberTest(int bonus) {
        //then
        assertThatThrownBy(() -> BonusNumberValidator.validate(lottoNumbers, bonus))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] ");
    }
}