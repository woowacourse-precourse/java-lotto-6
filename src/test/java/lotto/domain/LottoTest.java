package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LottoTest {

    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> Lotto.validate(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> Lotto.validate(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 입력되지 않으면 예외가 발생한다.")
    @Test
    void createLottoEmpty() {
        assertSimpleTest(() -> assertThatThrownBy(() -> Lotto.validate(List.of()))
                .isInstanceOf(IllegalArgumentException.class));
    }

    @DisplayName("로또 번호의 개수가 6개가 되지 않으면 예외가 발생한다.")
    @Test
    void createLottoByUnderSize() {
        assertSimpleTest(() -> assertThatThrownBy(() -> Lotto.validate(List.of(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class));
    }

    @DisplayName("로또 번호에 범위를 초과하는 숫자가 존재하면 예외가 발생한다.")
    @Test
    void lottoNumbersHasExcessNumber() {
        assertSimpleTest(() -> assertThatThrownBy(() -> Lotto.validate(List.of(1, 2, 3, 4, 50, 6)))
                .isInstanceOf(IllegalArgumentException.class));
    }

    @DisplayName("로또 번호가 오름차순으로 정렬된다.")
    @Test
    void lottoNumberSortAscend() {
        // given
        List<Integer> numbers = List.of(1, 45, 2, 30, 9, 5);
        Lotto lotto = Lotto.validate(numbers);

        // when
        List<Integer> sortedNumbers = lotto.getSortedNumbers();

        // then
        assertEquals(List.of(1, 2, 5, 9, 30, 45), sortedNumbers);
    }

    @CsvSource({"6, true", "7, false"})
    @DisplayName("로또 번호에 특정 번호의 포함 여부를 확인한다.")
    @ParameterizedTest
    void checkMyNumberInLottoNumbers(int number, boolean expectedResult) {
        // given
        Lotto lotto = Lotto.validate(List.of(1, 2, 3, 4, 5, 6));

        // when
        boolean result = lotto.containNumber(number);

        // then
        assertEquals(expectedResult, result);
    }

    @DisplayName("당첨 번호와 일치하는 로또 번호의 개수를 센다.")
    @Test
    void countMatchedLottoNumber() {
        // given
        Lotto playerNumbers = Lotto.validate(List.of(1, 2, 3, 4, 5, 6));
        Lotto winningNumbers = Lotto.validate(List.of(1, 2, 3, 4, 7, 9));

        // when
        int count = playerNumbers.countMatch(winningNumbers);

        // then
        assertEquals(4, count);
    }

}


