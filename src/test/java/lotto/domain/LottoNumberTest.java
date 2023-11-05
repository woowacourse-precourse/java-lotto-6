package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.exception.InputValidationException;
import org.junit.jupiter.api.Test;

public class LottoNumberTest {

    @Test
    void 로또번호를_생성한다() {
        LottoNumber lottoNumber = new LottoNumber(10);

        assertThat(lottoNumber).isEqualTo(new LottoNumber(10));
    }

    @Test
    void 로또번호의_범위에_포함되지_않으면_에러가_발생한다() {
        assertThatThrownBy(() -> new LottoNumber(0))
                .isInstanceOf(InputValidationException.class);
        assertThatThrownBy(() -> new LottoNumber(46))
                .isInstanceOf(InputValidationException.class);
    }
}
