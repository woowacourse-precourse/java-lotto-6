package lotto.validate;

import static org.assertj.core.api.Assertions.assertThatCode;

import java.util.List;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.utils.Validation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ValidateBonusNumberTest {
    private static final Lotto WINNING_LOTTOS = new Lotto(List.of(1, 2, 3, 4, 5, 6));

    @ParameterizedTest
    @ValueSource(ints = {7, 10, 44, 45, 34})
    @DisplayName("보너스_번호_검증_통과")
    void 보너스_번호_검증_통과(int bonusNumber) {
        assertThatCode(() -> Validation.validateBonusNumber(WINNING_LOTTOS, new BonusNumber(bonusNumber)))
            .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 46, 100, 1000})
    @DisplayName("보너스_번호_검증_실패_범위_밖")
    void 보너스_번호_검증_실패_범위_밖(int bonusNumber) {
        assertThatCode(() -> Validation.validateBonusNumber(WINNING_LOTTOS, new BonusNumber(bonusNumber)))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6})
    @DisplayName("보너스_번호_검증_실패_당첨_번호와_중복")
    void 보너스_번호_검증_실패_당첨_번호와_중복(int bonusNumber) {
        assertThatCode(() -> Validation.validateBonusNumber(WINNING_LOTTOS, new BonusNumber(bonusNumber)))
            .isInstanceOf(IllegalArgumentException.class);
    }
}
