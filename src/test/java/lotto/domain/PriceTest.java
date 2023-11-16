package lotto.domain;

import lotto.constant.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("로또 구입 가격 테스트")
class PriceTest {
    @ParameterizedTest(name = "[{index}] 공백 입력 예외 발생")
    @EmptySource
    void 공백_입력_예외_발생(String blank) {
        // when
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> new Price(blank));

        // then
        assertThat(e.getMessage()).isEqualTo(ErrorMessage.BLANK_VALUE.getMessage());
    }

    @ParameterizedTest(name = "[{index}] 숫자 아닌 값 예외 발생 : {0}")
    @ValueSource(strings = {"!", "s", "ㄱ", "sdf"})
    void 숫자_아닌_값_예외_발생(String str) {
        // when
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> new Price(str));

        // then
        assertThat(e.getMessage()).isEqualTo(ErrorMessage.NOT_NUMBER.getMessage());
    }

    @ParameterizedTest(name = "[{index}] 최대값 초과 예외 발생 : {0}")
    @ValueSource(ints = {100000001, 200000000})
    void 최대값_초과_예외_발생(int num) {
        // when
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> new Price(num));

        // then
        assertThat(e.getMessage()).isEqualTo(ErrorMessage.OVER_MAXIMUM_PRICE.getMessage());
    }

    @ParameterizedTest(name = "[{index}] 최소값 미만 예외 발생 : {0}")
    @ValueSource(ints = {999, 100, 500})
    void 최소값_미만_예외_발생(int num) {
        // when
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> new Price(num));

        // then
        assertThat(e.getMessage()).isEqualTo(ErrorMessage.UNDER_MINIMUM_PRICE.getMessage());
    }

    @ParameterizedTest(name = "[{index}] 값 단위 오류 예외 발생 : {0}")
    @ValueSource(ints = {1001, 2005, 85444})
    void 값_단위_오류_예외_발생(int num) {
        // when
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> new Price(num));

        // then
        assertThat(e.getMessage()).isEqualTo(ErrorMessage.NOT_INDIVISIBLE_PRICE.getMessage());
    }

    @ParameterizedTest(name = "[{index}] 정상 생성 확인 : {0}")
    @ValueSource(ints = {1000, 5000, 100000000})
    void 정상_생성_확인(int num) {
        // when
        Price price = new Price(num);

        // then
        assertThat(price.getPrice()).isEqualTo(num);
    }
}