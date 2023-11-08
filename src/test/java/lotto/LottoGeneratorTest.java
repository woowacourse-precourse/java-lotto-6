package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class LottoGeneratorTest {

    private LottoGenerator lottoGenerator;

    @BeforeEach
    void setUp() {
        lottoGenerator = new LottoGenerator();
    }

    @DisplayName("로또 구입 금액이 숫자가 아닐 때 예외가 발생한다")
    @Test
    void validateAmount_WhenNotNumeric_ThrowsException() {
        assertThatThrownBy(() -> lottoGenerator.validateInput("테스트"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 구입 금액은 1,000원 단위로 입력해야 합니다.");
    }

    @DisplayName("로또 구입 금액이 1000원 단위가 아닐 때 예외가 발생한다.")
    @Test
    void validateAmount_WhenNotMultipleOf1000_ThrowsException() {
        assertThatThrownBy(() -> lottoGenerator.validateInput("1500"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 구입 금액은 1,000원 단위로 입력해야 합니다.");
    }
}
