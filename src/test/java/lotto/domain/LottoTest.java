package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호들 중 1부터 45까지의 값이 아닌것이 있는경우 예외처리.")
    @Test
    void 로또번호_범위이탈_예외처리() {
        assertThatThrownBy(() -> new Lotto(List.of(4, 8, 43, 27, 46, 9)))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Lotto(List.of(0, 8, 43, 27, 37, 9)))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Lotto(List.of(4, 8, 43, 27, -5, 9)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("인자값이 해당 로또 번호중 하나인지 알려주는 기능")
    @ParameterizedTest
    @CsvSource(value = {"1:true", "3:true", "6:true", "8:false"}, delimiter = ':')
    void 로또번호_포함_확인(int number, boolean expected) {
        LottoNumber lottoNumber = new LottoNumber(number);
        Lotto lotto = new Lotto(List.of(6, 4, 1, 3, 5, 2));

        assertThat(lotto.isContains(lottoNumber)).isEqualTo(expected);
    }

    @DisplayName("당첨번호와 사용자의 로또를 비교해 일치개수를 반환하는 기능.")
    @Test
    void 당첨번호_일치개수_반환() {
        Lotto userLotto = new Lotto(List.of(2, 4, 1, 3, 6, 8));
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        assertThat(winningLotto.getMatchCount(userLotto)).isEqualTo(5);
    }

    @DisplayName("로또번호 오름차순 문자열 반환 기능")
    @Test
    void 로또번호_오름차순_문자열_출력() {
        //given
        Lotto lotto = new Lotto(List.of(2, 1, 5, 3, 4, 6));
        String expected = "[1, 2, 3, 4, 5, 6]";

        //when
        String result = lotto.getNumbersMessage();

        assertThat(result).isEqualTo(expected);

    }
}