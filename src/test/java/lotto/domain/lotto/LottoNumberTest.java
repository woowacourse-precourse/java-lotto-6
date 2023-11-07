package lotto.domain.lotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNumberTest {

    @Test
    void 번호_생성_성공() {
        // given
        final int number = 1;

        // when
        final LottoNumber result = new LottoNumber(number);

        // then
        assertThat(result.number()).isEqualTo(number);
    }

    @Test
    void 번호_생성_실패() {
        // given
        final int invalidNumber = 0;

        // when & then
        assertThatThrownBy(() -> new LottoNumber(invalidNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
