package lotto.domain;

import lotto.constants.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

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

    @DisplayName("한 개의 로또 번호 끼리 비교하기")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 45})
    public void lottoNumber_equals_oneToOne(int number) throws Exception {
        //given
        LottoNumber lottoNumber1 = new LottoNumber(number);
        LottoNumber lottoNumber2 = new LottoNumber(number);

        //when, then
        assertThat(lottoNumber1).isEqualTo(lottoNumber2);
    }

    @DisplayName("한 개의 로또 번호를 여러개의 로또 넘버와 비교하기 -> 일치하는 번호가 있으면 true 반환")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6})
    public void lottoNumber_equals_oneToMany(int number) throws Exception {
        //given
        LottoNumber lottoNumber = new LottoNumber(number);
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        //when, then
        assertThat(winningLotto.contains(lottoNumber)).isTrue();
    }

    @DisplayName("한 개의 로또 번호를 여러개의 로또 넘버와 비교하기 -> 일치하는 번호가 없으면 false 반환")
    @ParameterizedTest
    @ValueSource(ints = {7, 8, 9, 10, 15, 26})
    public void lottoNumber_notEquals_oneToMany(int number) throws Exception {

        //given
        LottoNumber lottoNumber = new LottoNumber(number);
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        //when, then
        assertThat(winningLotto.contains(lottoNumber)).isFalse();
    }
}
