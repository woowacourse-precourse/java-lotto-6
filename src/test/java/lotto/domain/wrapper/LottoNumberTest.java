package lotto.domain.wrapper;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.HashSet;
import java.util.Set;
import lotto.utils.ErrorMessage;
import lotto.utils.LottoConstantValue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoNumberTest {
    private static final int MINUS_VALUE = -1;
    private static final int ZERO_VALUE = -1;
    private static final int TOO_BIG_VALUE = 46;
    private static final int LOTTO_NUMBER_EXAMPLE = 2;
    private static final int ONLY_ONE_ELEMENT = 1;
    private static final int SMALLER_LOTTO_NUMBER_EXAMPLE = 1;
    private static final int BIGGER_LOTTO_NUMBER_EXAMPLE = 3;
    private static final int COMPARED_WITH_SMALLER = 1;
    private static final int COMPARED_WITH_SAME = 0;
    private static final int COMPARED_WITH_BIGGER = -1;

    @DisplayName("로또 번호가 1~45 사이 값이 아니라면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {MINUS_VALUE, ZERO_VALUE, TOO_BIG_VALUE})
    void createLottoNumberOutOfRange(int number) {
        assertThatThrownBy(() -> new LottoNumber(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(
                        ErrorMessage.LOTTO_NUMBER_OUT_OF_RANGE.getWithFormatAndPrefix(
                                LottoConstantValue.MIN_LOTTO_NUMBER.get(),
                                LottoConstantValue.MAX_LOTTO_NUMBER.get()
                        )
                );
    }

    @DisplayName("로또 번호 값이 같은 객체들은 같은 객체로 판단한다.")
    @Test
    void compareLottoNumberInstance() {
        // given, when
        LottoNumber lottoNumber = new LottoNumber(LOTTO_NUMBER_EXAMPLE);
        LottoNumber sameLottoNumber = new LottoNumber(LOTTO_NUMBER_EXAMPLE);
        // then
        assertThat(lottoNumber).isEqualTo(sameLottoNumber);
    }

    @DisplayName("로또 번호 값이 같은 객체들은 Hash 구조에서도 같은 객체로 판단한다.")
    @Test
    void compareLottoNumberInstanceInHash() {
        // given
        LottoNumber lottoNumber = new LottoNumber(LOTTO_NUMBER_EXAMPLE);
        LottoNumber sameLottoNumber = new LottoNumber(LOTTO_NUMBER_EXAMPLE);
        Set<LottoNumber> lottoNumbers = new HashSet<>();
        // when
        lottoNumbers.add(lottoNumber);
        lottoNumbers.add(sameLottoNumber);
        // then
        assertThat(lottoNumbers.size()).isEqualTo(ONLY_ONE_ELEMENT);
    }

    @DisplayName("로또 번호 값을 기반으로 로또 객체의 크기를 비교할수 있다.")
    @Test
    void compareLottoNumberInstanceWithValue() {
        // given
        LottoNumber lottoNumber = new LottoNumber(LOTTO_NUMBER_EXAMPLE);
        LottoNumber sameLottoNumber = new LottoNumber(LOTTO_NUMBER_EXAMPLE);
        LottoNumber smallerLottoNumber = new LottoNumber(SMALLER_LOTTO_NUMBER_EXAMPLE);
        LottoNumber biggerLottoNumber = new LottoNumber(BIGGER_LOTTO_NUMBER_EXAMPLE);
        // then
        assertThat(lottoNumber.compareTo(smallerLottoNumber)).isEqualTo(COMPARED_WITH_SMALLER);
        assertThat(lottoNumber.compareTo(sameLottoNumber)).isEqualTo(COMPARED_WITH_SAME);
        assertThat(lottoNumber.compareTo(biggerLottoNumber)).isEqualTo(COMPARED_WITH_BIGGER);
    }

    @DisplayName("출력을 위해 로또 번호 값을 String으로 반환 받을 수 있다.")
    @Test
    void getLottoNumberForPrint() {
        // given, when
        LottoNumber lottoNumber = new LottoNumber(LOTTO_NUMBER_EXAMPLE);
        // then
        assertThat(lottoNumber.toString()).isEqualTo(String.valueOf(LOTTO_NUMBER_EXAMPLE));
    }
}