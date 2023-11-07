package lotto.domain;

import static lotto.view.ErrorMessage.*;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

class LottoTest {

    @Test
    @DisplayName("기능01, 02 테스트 : 입력된 숫자 리스트에 이상이 없으면 로또가 하나 정상적으로 발행된다.")
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

    @Test
    @DisplayName("기능07 테스트 : 하나의 숫자도 맞추지 못했을 때 맞춘 개수를 정확히 계산한다.")
    void countMatchingNumberReturnCorrectResultWhenMyLottoContainsZeroAnswer() {
        // given
        Lotto mylotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto answerLotto = new Lotto(List.of(7, 8, 9, 10, 11, 12));

        // when
        int result = mylotto.countMatchingNumber(answerLotto);

        // then
        assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName("기능07 테스트 : 하나의 숫자를 맞추었을 때 맞춘 개수를 정확히 계산한다.")
    void countMatchingNumberReturnCorrectResultWhenContainOneAnswer() {
        // given
        Lotto mylotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto answerLotto = new Lotto(List.of(6, 7, 8, 9, 10, 11));

        // when
        int result = mylotto.countMatchingNumber(answerLotto);

        // then
        assertThat(result).isEqualTo(1);
    }

    @Test
    @DisplayName("기능07 테스트 : 세개의 숫자를 맞추었을 때 맞춘 개수를 정확히 계산한다.")
    void countMatchingNumberReturnCorrectResultWhenContainThreeAnswer() {
        // given
        Lotto mylotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto answerLotto = new Lotto(List.of(4, 5, 6, 7, 8, 9));

        // when
        int result = mylotto.countMatchingNumber(answerLotto);

        // then
        assertThat(result).isEqualTo(3);
    }

    @Test
    @DisplayName("기능07 테스트 : 모든 숫자를 맞추었을 때 맞춘 개수를 정확히 계산한다.")
    void countMatchingNumberReturnCorrectResultWhenContainAllAnswer() {
        // given
        Lotto mylotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto answerLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        // when
        int result = mylotto.countMatchingNumber(answerLotto);

        // then
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("기능33 테스트 : 로또 객체가 가진 숫자리스트를 문자열로 반환한다.")
    void getNumberStatusReturnNumberListInTheFormOfString() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        // when
        String result = lotto.getStatus();

        // then
        assertThat(result).isEqualTo("[1, 2, 3, 4, 5, 6]");
    }
}