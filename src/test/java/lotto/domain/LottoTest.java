package lotto.domain;

import static lotto.domain.ErrorMessage.*;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

class LottoTest {

    @Test
    @DisplayName("기능01,02 테스트 : 입력된 숫자 리스트에 이상이 없으면 로또가 하나 정상적으로 발행된다.")
    void createLottoByNormalArgument() {
        // given
        List<Integer> list = List.of(1, 2, 3, 4, 5, 6);

        // when, then
        assertThatCode(() -> new Lotto(list))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("기능03 테스트 : 숫자 리스트에 들어있는 숫자의 개수가 6개가 아니면 IllegalArgumentException이 발생한다.")
    void createLottoByOversize() {
        // given
        List<Integer> list = List.of(1, 2, 3, 4, 5, 6, 7);

        // when, then
        assertThatThrownBy(() -> new Lotto(list))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LOTTO_COMBINATION_HAVE_SIX_NUMBER.getErrorMessage());
    }

    @Test
    @DisplayName("기능04 테스트 : 숫자 리스트에 1~45 범위에 있지 않은 숫자가 있다면 예외가 발생한다.")
    void createLottoByWrongRangeNumber() {
        // given
        List<Integer> list = List.of(1, 2, 3, 4, 5, 46);

        // when, then
        assertThatThrownBy(() -> new Lotto(list))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LOTTO_NUMBER_RANGE_IS_BETWEEN_ONE_AND_FORTYFIVE.getErrorMessage());
    }

    @Test
    @DisplayName("기능05 테스트 : 숫자 리스트에 중복된 숫자가 있다면 예외가 발생한다.")
    void createLottoByDuplicatedNumber() {
        // given
        List<Integer> list = List.of(1, 2, 3, 4, 5, 5);

        // when, then
        assertThatThrownBy(() -> new Lotto(list))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LOTTO_COMBINATION_DO_NOT_HAVE_DUPLICATES.getErrorMessage());
    }


    @Test
    @DisplayName("기능06 테스트 : isNumberIn 메서드는 보너스 숫자가 해당 로또 조합에 있으면 true를 반환한다.")
    void isNumberInShouldReturnTrueWhenBonusNumberInThisLotto() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        int number = 6;

        // when
        boolean result = lotto.isNumberIn(number);

        // then
        assertThat(result).isEqualTo(true);
    }

    @Test
    @DisplayName("기능06 테스트 : isNumberIn 메서드는 보너스 숫자가 해당 로또 조합에 있지 않으면 false를 반환한다.")
    void isNumberInShouldReturnTrueWhenBonusNumberNotInThisLotto() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int number = 7;

        // when
        boolean result = lotto.isNumberIn(number);

        // then
        assertThat(result).isEqualTo(false);
    }
}