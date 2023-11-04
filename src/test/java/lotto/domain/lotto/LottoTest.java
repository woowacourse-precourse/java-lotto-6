package lotto.domain.lotto;

import lotto.domain.lotto.Lotto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 번호가 1에서 45사이가 아니라면 예외가 발생한다.")
    void 로또번호_예외_발생_테스트() {
        assertThatThrownBy(() -> new Lotto(List.of(14, 46, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 번호가 중복되지 않고 1에서 45사이의 숫자 6개라면 예외 없이 생성된다.")
    void 로또_생성_테스트() {
        //given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);

        //when
        Lotto lotto = new Lotto(numbers);

        //then
        Assertions.assertNotNull(lotto);
        Assertions.assertDoesNotThrow(() -> new Lotto(numbers));
        assertThat(lotto.getNumbers()).isEqualTo(numbers);
    }

    @ParameterizedTest
    @DisplayName("보너스 번호 가지고 있는지 여부 테스트")
    @CsvSource(value = {"1,true", "7,false"})
    void 보너스번호(int number, boolean expected) {
        // given
        BonusNumber bonusNumber = new BonusNumber(number);
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        // when
        boolean hasSameNumber = lotto.hasSameNumber(bonusNumber);

        // then
    }
}