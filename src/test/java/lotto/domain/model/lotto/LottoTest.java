package lotto.domain.model.lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import java.util.List;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> Lotto.from(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.DIFFERENT_LOTTO_SIZE.getMessage());
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> Lotto.from(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.DUPLICATE_LOTTO_NUMBER.getMessage());
    }

    @DisplayName("로또 번호에 1~45범위가 아닌 숫자가 있을 시 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 46})
    void createLottoByNotInRangeNumber(Integer number) {
        assertThatThrownBy(() -> Lotto.from(List.of(1, 2, number, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.LOTTO_NUMBER_OUT_OF_RANGE.getMessage());
    }

    @DisplayName("로또 번호에 중복된 숫자가 없으면 로또 생성에 성공한다.")
    @Test
    void createLottoWithoutDuplicatedNumber() {
        Lotto lotto = Lotto.from(List.of(1, 2, 3, 4, 5, 6));

        assertThat(lotto).isNotNull();
    }

    @DisplayName("당첨번호와 로또번호 사이에 일치하는 개수를 구한다.")
    @ParameterizedTest
    @CsvSource({"7, 13, 20, 27, 30, 34, 1",
            "7, 18, 19, 26, 33, 45, 6"})
    void countMatchingNumbersWithWinningNumbers(int myLotto1, int myLotto2, int myLotto3,
                                                int myLotto4, int myLotto5, int myLotto6, int expectedCount) {
        //given
        Lotto winningNumber = Lotto.from(List.of(7, 18, 19, 26, 33, 45));
        Lotto myLotto = Lotto.from(List.of(myLotto1, myLotto2, myLotto3, myLotto4, myLotto5, myLotto6));

        //when
        int countOfMatching = myLotto.countMatchingNumbers(winningNumber);

        //then
        assertThat(countOfMatching)
                .isEqualTo(expectedCount);
    }

    @DisplayName("당첨번호와 로또번호 사이에 일치하는 개수를 구한다.")
    @ParameterizedTest
    @CsvSource({"13, true", "45, false"})
    void LottoContainsBonusNumber(int bonus, boolean expected) {
        //given
        LottoNumber lottoNumber = LottoNumber.from(bonus);
        Lotto myLotto = Lotto.from(List.of(7, 13, 20, 27, 30, 34));

        //when
        boolean isContaining = myLotto.contains(lottoNumber);

        //then
        assertThat(isContaining)
                .isEqualTo(expected);
    }

}