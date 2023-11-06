package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class LottoNumberTest {
    private static final int MIN_RANGE_NUMBER = 1;
    private static final int MAX_RANGE_NUMBER = 45;

    @Test
    void 범위내_숫자_입력시_객체_정상_생성() {
        int validNumber = MIN_RANGE_NUMBER;

        LottoNumber lottoNumber = LottoNumber.create(validNumber);

        Assertions.assertThat(lottoNumber.getNumber()).isEqualTo(1);
    }

    @Test
    void 범위외_숫자_예외_처리() {
        int outOfRangeNumber = MAX_RANGE_NUMBER + 1;

        assertThatThrownBy(() -> new LottoNumber(outOfRangeNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
    }
}