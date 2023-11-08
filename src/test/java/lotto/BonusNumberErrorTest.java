package lotto;

import static org.junit.jupiter.api.Assertions.assertFalse;

import lotto.domain.generator.BonusNumberGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class BonusNumberErrorTest {
    BonusNumberGenerator bonusNumberGenerator;

    @BeforeEach()
    void setUp() {
        bonusNumberGenerator = new BonusNumberGenerator();
    }

    @DisplayName("로또 번호가 0이상의 정수가 아닌 것을 포함하는 경우 false를 반환한다.")
    @Test
    void createLottoNotDecimal() {
        assertFalse(() -> bonusNumberGenerator.validate("invalid"));
    }


    @DisplayName("로또 번호가 1부터 45 사이의 숫자가 아니면 false를 반환한다.")
    @ParameterizedTest
    @CsvSource({"48", "0"})
    void createLottoNotInRangeNumber(String input) {
        assertFalse(() -> bonusNumberGenerator.validate(input));
    }
}
