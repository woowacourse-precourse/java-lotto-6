package lotto.domain;

import lotto.constant.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("로또 숫자 테스트")
class LottoNumberTest {
    @ParameterizedTest(name = "[{index}] 공백 입력 예외 발생")
    @EmptySource
    void 공백_입력_예외_발생(String blank) {
        // when
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> new LottoNumber(blank));

        // then
        assertThat(e.getMessage()).isEqualTo(ErrorMessage.BLANK_VALUE.getMessage());
    }

    @ParameterizedTest(name = "[{index}] 숫자 아닌 값 예외 발생 : {0}")
    @ValueSource(strings = {"!", "s", "ㄱ", "sdf"})
    void 숫자_아닌_값_예외_발생(String str) {
        // when
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> new LottoNumber(str));

        // then
        assertThat(e.getMessage()).isEqualTo(ErrorMessage.NOT_NUMBER.getMessage());
    }

    @ParameterizedTest(name = "[{index}] 범위 밖인 값 예외 발생 : {0}")
    @ValueSource(ints = {0, -1, 46, 47, 654, -456})
    void 범위_밖인_값_예외_발생(int num) {
        // when
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> new LottoNumber(num));

        // then
        assertThat(e.getMessage()).isEqualTo(ErrorMessage.NOT_IN_NUMBER_RANGE.getMessage());
    }

    @ParameterizedTest(name = "[{index}] 정상 생성 확인 : {0}")
    @ValueSource(ints = {1, 2, 3, 43, 44, 45})
    void 정상_생성_확인(int num) {
        // when
        LottoNumber lottoNumber = new LottoNumber(num);

        // then
        assertThat(num).isEqualTo(lottoNumber.getNumber());
    }


}