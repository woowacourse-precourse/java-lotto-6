package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class BonusNumberTest {
    @Test
    @DisplayName("보너스 번호 - 정상 입력")
    void normalBonusNumberTest() {
        int number = 3;
        BonusNumber bonusNumber = new BonusNumber(number);
        assertThat(bonusNumber.getValue()).isEqualTo(3);
    }

    @ParameterizedTest
    @DisplayName("보너스 번호 - 범위에 어긋나는 입력")
    @ValueSource(ints = {-1, 0, 46})
    void inputNotNumberTest(int number) {
        assertThatThrownBy(() -> new BonusNumber(number))
                .isInstanceOf(IllegalArgumentException.class);
    }
}