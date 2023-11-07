package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BonusNumberTest {
    @DisplayName("보너스 번호가 로또 번호와 중복되면 예외가 발생한다.")
    @Test
    void createBonusNumberDuplicate() {
        assertThatThrownBy(() -> new BonusNumber(1, List.of(1,2,3,4,5,6)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 보너스 번호가 당첨 번호와 중복됩니다.");
    }

    @DisplayName("보너스 번호가 1~45 사이의 숫자가 아니면 예외가 발생한다")
    @Test
    void createBonusNumberExceed() {
        assertThatThrownBy(() -> new BonusNumber(46, List.of(1,2,3,4,5,6)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 보너스 번호의 입력 가능 범위는 1부터 45까지 입니다.");
    }
}
