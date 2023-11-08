package lotto.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@Nested
@DisplayName("BonusNumber 모델 검증 테스트")
public class BonusNumberTest {
    @Test
    @DisplayName("보너스 번호가 1~45 범위에 있으면 성공한다.")
    void success() {
        BonusNumber bonusNumber = new BonusNumber(1);
        assertThat(bonusNumber.number()).isEqualTo(1);
    }

    @Test
    @DisplayName("보너스 번호가 1~45 범위에 있지 않으면 예외가 발생한다.")
    void fail() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new BonusNumber(-1));
    }

}
