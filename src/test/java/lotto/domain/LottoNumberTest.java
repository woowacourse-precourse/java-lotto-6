package lotto.domain;

import lotto.constants.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoNumberTest {

    @DisplayName("로또 번호 하나 생성")
    @ParameterizedTest
    @ValueSource(ints = {1, 5, 30, 45})
    public void createLottoNumber(int number) throws Exception {
        //when
        LottoNumber lottoNumber = new LottoNumber(number);

        //then
        assertThat(lottoNumber.getNumber()).isEqualTo(number);
    }

    @DisplayName("로또 번호 하나 생성 예외 : 지정된 로또 번호의 범위에서 벗어나면 예외(1-45)")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 46, 100})
    public void createLottoNumber_exception_notInRange(int number) throws Exception {
        //when, then
        assertThatThrownBy(() -> new LottoNumber(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.LOTTO_NUMBER_NOT_IN_RANGE.getMessage());
    }
}
