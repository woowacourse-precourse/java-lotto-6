package lotto;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.validator.LottoValidator;
import org.junit.jupiter.api.Test;

public class LottoValidatorTest {
    private static final LottoValidator lottoValidator = new LottoValidator();

    @Test
    void 당첨_번호_정상_테스트() {
        assertThatCode(() -> lottoValidator.validate("1,3,5,6,15,7"))
                .doesNotThrowAnyException();
    }

    @Test
    void 당첨_번호_문자_입력_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> lottoValidator.validate("1,2,2a,3,4,5"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 당첨_번호_중복_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> lottoValidator.validate("1,2,2,3,4,5"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 당첨_번호_범위_초과_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> lottoValidator.validate("1,2,3,4,5,100"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 당첨_번호_개수_오류_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> lottoValidator.validate("1,2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
}
