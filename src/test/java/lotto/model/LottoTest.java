package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoTest {
    private static Stream<Arguments> provideLottoAndResult() {
        return Stream.of(
                Arguments.of(List.of(1, 3, 7, 10, 13, 45), "FIFTH"),
                Arguments.of(List.of(1, 3, 7, 8, 29, 45), "FOURTH"),
                Arguments.of(List.of(1, 3, 7, 8, 9, 45), "THIRD"),
                Arguments.of(List.of(1, 3, 7, 8, 9, 18), "SECOND"),
                Arguments.of(List.of(1, 3, 7, 8, 9, 11), "FIRST")
        );
    }

    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 번호의 갯수 6개를 만족해야합니다.");
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자는 중복될 수 없습니다.");
    }

    @DisplayName("로또 번호의 숫자가 1~45의 범위를 만족하지 않을시 예외가 발생한다.")
    @Test
    void createLottoByImproperNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 47)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자는 1에서 45사이여야합니다.");
    }

    @DisplayName("당첨번호 : [1,3,7,8,9,11] ,보너스 번호 : 18 인경우 등수 판별")
    @ParameterizedTest(name = "로또번호 :{0}, 예상등수 : {1}")
    @MethodSource("provideLottoAndResult")
    void calculateLottoPlace(List<Integer> numbers, String expected) {
        Lotto lotto = new Lotto(numbers);
        WinningNumbers winningNumbers = WinningNumbers.createWinningNumbers(List.of(1, 3, 7, 8, 9, 11));
        Integer bonusNumber = 18;
        WinnigLotto winnigLotto = new WinnigLotto(winningNumbers, bonusNumber);

        Optional<LottoPlace> lottoPlace = lotto.calculateLottoPlace(winnigLotto);

        assertThat(lottoPlace).containsSame(LottoPlace.valueOf(expected));
    }
}
