package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BonusNumberTest {

    @ParameterizedTest
    @ValueSource(strings = {"one", "two", "three", "yoon", "su"})
    void 보너스_번호가_숫자가_아니면_IllegalArgumentException_예외처리_검증(String bonusNumberInput) {
        List<Integer> winningBundle = Arrays.asList(1, 2, 3, 4, 5, 6);
        assertThatThrownBy(() -> BonusNumber.of(bonusNumberInput, winningBundle))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 보너스 번호는 숫자여야 합니다.");
    }

    @DisplayName("보너스 번호가 1~45의 숫자가 아니면 IllegalArgum햐entException로 예외처리하는지 검증")
    @ParameterizedTest
    @ValueSource(strings = {"0", "46", "47", "250", "100000"})
    void 보너스_번호가_숫자_IllegalArgumentException_예외처리_검증(String bonusNumberInput) {
        List<Integer> winningBundle = Arrays.asList(1, 2, 3, 4, 5, 6);
        assertThatThrownBy(() -> BonusNumber.of(bonusNumberInput, winningBundle))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 보너스 번호는 1~45의 숫자여야 합니다.");
    }

}
