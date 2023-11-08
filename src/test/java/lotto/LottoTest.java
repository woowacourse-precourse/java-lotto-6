package lotto;

import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoAmount;
import lotto.domain.lotto.WinningLotto;
import lotto.exception.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

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

    // 아래에 추가 테스트 작성 가능
    @DisplayName("로또 번호가 1미만, 45초 과인 수가 존재하면 예외가 발생한다.")
    @ParameterizedTest
    @MethodSource("generateWrongRangeNumber")
    void createLottoByWrongRangeNumber(List<Integer> numbers) {
        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(LottoNumRangeException.class);
    }

    static Stream<Arguments> generateWrongRangeNumber() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4, 5, 0)),
                Arguments.of(List.of(10, 11, 12, 46, 37, 23))
        );
    }

    @DisplayName("보너스 번호가 로또 번호에 포함되면 예외가 발생한다.")
    @Test
    void createBonusNumberByDuplicatedNumber() {
        assertThatThrownBy(() -> new WinningLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)),6))
                .isInstanceOf(BonusNumDuplicateException.class);
    }

    @DisplayName("보너스 번호가 1미만, 45초 과인 수가 존재하면 예외가 발생한다.")
    @ParameterizedTest
    @MethodSource("generateWrongRangeBonusNumber")
    void createBonusByWrongRangeNumber(List<Integer> numbers, int bonusNum) {
        assertThatThrownBy(() -> new WinningLotto(new Lotto(numbers), bonusNum))
                .isInstanceOf(LottoNumRangeException.class);
    }

    static Stream<Arguments> generateWrongRangeBonusNumber() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4, 5, 6), 0),
                Arguments.of(List.of(10, 11, 12, 43, 37, 23), 46)
        );
    }

    @DisplayName("구입금액이 1,000 단위가 아닌 경우 예외가 발생한다.")
    @Test
    void divideLottoAmountIsWrongNumber() {
        assertThatThrownBy(() -> new LottoAmount("2300"))
                .isInstanceOf(LottoMoneyDivideException.class);
    }

    @DisplayName("구입금액이 1,000 단위가 아닌 경우 예외가 발생한다.")
    @Test
    void lottoAmountNotMultipleOf1000() {
        assertThatThrownBy(() -> new LottoAmount("2300"))
                .isInstanceOf(LottoMoneyDivideException.class);
    }

    @DisplayName("구입금액이 1,000 보다 작은 경우 예외가 발생한다.")
    @Test
    void lottoAmountLessThan1000() {
        assertThatThrownBy(() -> new LottoAmount("890"))
                .isInstanceOf(LottoMoneyLessException.class);
    }
}



