package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    static Stream<Arguments> provideDataForTesting() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3)),
                Arguments.of(List.of(57, 1, 2, 3, 4, 5)),
                Arguments.of(List.of(-1, 1, 2, 3, 4, 5),
                        Arguments.of(List.of(0, 1, 2, 3, 4, 5))));
    }

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

    @ParameterizedTest(name = "[{index}] 로또 번호가 {0} 이면 예외가 발생한다.")
    @MethodSource("provideDataForTesting")
    void cannotCreateLotto(List<Integer> numbers) {
        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 넘버 비교하기 (5개 번호가 같고, 보너스 번호가 다르면 3등이다.)")
    @Test
    void compareNumbers() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        WinningNumbers winningNumbers = WinningNumbers.create("1,2,3,4,5,7");
        BonusNumber bonusNumber = BonusNumber.create("8");
        WinningLotto winningLotto = WinningLotto.create(winningNumbers, bonusNumber);

        // when, then
        PrizeCondition prizeCondition = lotto.getPrizeCondition(winningLotto);
        assertThat(prizeCondition).isEqualTo(PrizeCondition.THIRD);
    }
}