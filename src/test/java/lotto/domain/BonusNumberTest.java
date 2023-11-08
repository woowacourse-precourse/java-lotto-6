package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import lotto.domain.exception.DomainExceptionCode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@DisplayName("[도메인] 보너스 번호 테스트")
class BonusNumberTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 46, 47, -1})
    void 보너스_번호를_생성할_때_1과_45_사이의_숫자만_입력_가능합니다(int input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new BonusNumber(input))
                .withMessageContaining(DomainExceptionCode.BONUS_NUMBER_MUST_BE_BETWEEN_SIZE.getMessage());
    }

}
