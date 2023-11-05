package lotto.domain;

import java.util.List;
import lotto.util.NumberConverter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class BonusNumberTest {
    private Lotto lotto;
    private NumberConverter numberConverter;
    private BonusNumber bonusNumber;

    @BeforeEach
    void setUp() {
        lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        numberConverter = new NumberConverter();
        bonusNumber = new BonusNumber(lotto, numberConverter);
    }

    @Test
    @DisplayName("보너스 번호가 올바른 범위 내에 있는지 검증")
    void validateNumberWithinRange() {
        bonusNumber.validateNumber("7");
        assertThat(bonusNumber.getBonusNumber()).isEqualTo(7);
    }

}

