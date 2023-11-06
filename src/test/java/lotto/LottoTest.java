package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 1~45범위가 아닌 숫자가 있을 시 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 46})
    void createLottoByNotInRangeNumber(Integer number) {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, number, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨번호와 로또번호 사이에 일치하는 개수를 구한다.")
    @ParameterizedTest
    @CsvSource({"7, 13, 20, 27, 30, 34, 1",
            "7, 18, 19, 26, 33, 45, 6"})
    void countMatchingNumbersWithWinningNumbers(int myLotto1, int myLotto2, int myLotto3,
                                                int myLotto4, int myLotto5, int myLotto6, int expectedCount) {
        //given
        Lotto winningNumber = new Lotto(List.of(7, 18, 19, 26, 33, 45));
        Lotto myLotto = new Lotto(List.of(myLotto1, myLotto2, myLotto3, myLotto4, myLotto5, myLotto6));

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
        BonusNumber bonusNumber = new BonusNumber(bonus);
        Lotto myLotto = new Lotto(List.of(7, 13, 20, 27, 30, 34));

        //when
        boolean isContaining = myLotto.contains(bonusNumber.getNumber());

        //then
        assertThat(isContaining)
                .isEqualTo(expected);
    }

}