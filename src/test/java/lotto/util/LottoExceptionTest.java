package lotto.util;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatCode;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoExceptionTest {

    private LottoException lottoException;

    @BeforeEach
    void setUp() {
        lottoException = new LottoException();
    }

    @ParameterizedTest
    @CsvSource({
            "8000, true",
            "100000, true",
            "0, true",
            "80a0, false",
            "\\ 8000, false",
            "80 00, false"
    })
    void 유저가_입력한_지불_금액이_숫자가_맞는지_테스트(String input, boolean result) {
        if (result) {
            assertThatCode(() -> lottoException.checkInvalidNumber(input))
                    .doesNotThrowAnyException();
        } else {
            assertThatExceptionOfType(IllegalArgumentException.class)
                    .isThrownBy(() -> lottoException.checkInvalidNumber(input));
        }
    }

    @ParameterizedTest
    @CsvSource({
            "8000, true",
            "111000, true",
            "1000, true",
            "2200, false",
            "1001, false",
            "1100, false"
    })
    void 지불금액이_1000원_단위인지_테스트(int inputAmount, boolean result) {
        if (result) {
            assertThatCode(() -> lottoException.checkUnitPaymentAmount(inputAmount)).doesNotThrowAnyException();
        } else {
            assertThatExceptionOfType(IllegalArgumentException.class)
                    .isThrownBy(() -> lottoException.checkUnitPaymentAmount(inputAmount));
        }
    }

    @ParameterizedTest
    @CsvSource({
            "1000, true",
            "2000, true",
            "1000000, true",
            "0, false",
            "900, false",
            "-1000, false"
    })
    void 지불금액이_1000_아래인지_확인하는_테스트(int inputAmount, boolean result) {
        if (result) {
            assertThatCode(() -> lottoException.checkRangePaymentAmount(inputAmount)).doesNotThrowAnyException();
        } else {
            assertThatExceptionOfType(IllegalArgumentException.class)
                    .isThrownBy(() -> lottoException.checkRangePaymentAmount(inputAmount));
        }
    }

    @ParameterizedTest
    @CsvSource({
            "\'1,2,3,4,5,6\', true",
            "\'1,2,22,33\', true",
            "\'1,2,3,4,5,6,\', false",
            "\'1,2,3,4,5,\', false"
    })
    void 입력한_당첨번호_마지막_글자_테스트(String input, boolean result) {
        if (result) {
            assertThatCode(() -> lottoException.checkLastComma(input)).doesNotThrowAnyException();
        } else {
            assertThatExceptionOfType(IllegalArgumentException.class)
                    .isThrownBy(() -> lottoException.checkLastComma(input));
        }
    }

    @ParameterizedTest
    @CsvSource({
            "\'1,2,3,4,5,6\', true",
            "\'1,2,2,4,5,6\', false",
            "\'1,2,3,4,4,5\', false"
    })
    void 로또번호_중복_테스트(String input, boolean result) {
        List<Integer> numbers = Arrays.stream(input.split(","))
                .map(Integer::parseInt).collect(Collectors.toList());
        if (result) {
            assertThatCode(() -> lottoException.checkDuplicationNumber(numbers)).doesNotThrowAnyException();
        } else {
            assertThatExceptionOfType(IllegalArgumentException.class)
                    .isThrownBy(() -> lottoException.checkDuplicationNumber(numbers));
        }

    }

    @ParameterizedTest
    @CsvSource({
            "30, true",
            "45, true",
            "1, true",
            "46, false",
            "0, false",
            "-1, false"
    })
    void 로또번호_범위_테스트(int input, boolean result) {
        if (result) {
            assertThatCode(() -> lottoException.checkRangeLottoNumber(input)).doesNotThrowAnyException();
        } else {
            assertThatExceptionOfType(IllegalArgumentException.class)
                    .isThrownBy(() -> lottoException.checkRangeLottoNumber(input));
        }
    }
}