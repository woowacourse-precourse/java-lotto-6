package lotto.validator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class BonusLottoNumValidatorTest {
    private static BonusLottoNumValidator bonusLottoNumValidator = new BonusLottoNumValidator();

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 46})
    void 보너스_넘버_범위_에외_테스트(int bonusNum) {
        assertThatThrownBy(() -> bonusLottoNumValidator.checkRange(bonusNum))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContainingAll("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");

    }
}
