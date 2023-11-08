package lotto.validator;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatCode;

class LottoNumbersValidatorTest {
    private static LottoNumbersValidator lottoNumbersValidator;

    @BeforeEach
    void setUp(){
        lottoNumbersValidator = new LottoNumbersValidator();
    }

    @Test
    void 당첨번호_정상_테스트() {
        assertThatCode(() -> lottoNumbersValidator.validateNumber("1,3,5,6,15,7"))
                .doesNotThrowAnyException();
    }

    @Test
    void 당첨번호_입력_오류_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> lottoNumbersValidator.validateNumber("1,2,2a,3,4,5"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 당첨번호_중복_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> lottoNumbersValidator.validate(List.of(1,2,2,3,4,5)))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 당첨번호_범위_초과_테스트() {
        assertThrows(IllegalArgumentException.class, () -> {
            lottoNumbersValidator.validateRange(46);
        });
    }
}