package lotto.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.stream.IntStream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoNumberTest {
    @ParameterizedTest
    @ValueSource(ints = {0, -1, -2, 46, 47})
    void 로또_번호가_1에서_45_사이의_숫자가_아니라면_예외를_발생시킨다(int lottoNumber) {
        assertThatThrownBy(() -> LottoNumber.valueOf(lottoNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
    }

    static IntStream lottoNumberProvider() {
        return IntStream.rangeClosed(1, 45);
    }

    @ParameterizedTest
    @MethodSource("lottoNumberProvider")
    void 로또_번호는_1에서_45_사이의_숫자여야_한다(int lottoNumber) {
        assertThatCode(() -> LottoNumber.valueOf(lottoNumber))
                .doesNotThrowAnyException();
    }
}
