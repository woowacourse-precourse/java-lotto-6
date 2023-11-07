package lotto.domain.lotto;

import lotto.domain.winningNumber.BonusNumber;
import lotto.domain.winningNumber.FinalWinningNumber;
import lotto.domain.winningNumber.WinningNumber;
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

    @DisplayName("로또 번호를 올바르게 반환하는지 테스트")
    @Test
    void testLottoNumber() {
        List<Integer> list = List.of(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(list);
        assertThat(lotto.getNumbers())
                .isEqualTo(list);
    }

    @DisplayName("로또 순위 테스트 - 올바른 순위를 반환하는지 테스트")
    @ParameterizedTest(name = "번호: {0}, 결과: {1}")
    @MethodSource("provideLottoNumber")
    void testLottoRank(List<Integer> list, LottoRank lottoRank) {
        WinningNumber winningNumber = new WinningNumber("1,2,3,4,5,6");
        BonusNumber bonusNumber = new BonusNumber("7");
        FinalWinningNumber finalWinningNumber = new FinalWinningNumber(winningNumber, bonusNumber);

        Lotto lotto = new Lotto(list);

        assertThat(lotto.compareLottoNumberWithFinalWinningNumber(finalWinningNumber))
                .isSameAs(lottoRank);
    }

    private static Stream<Arguments> provideLottoNumber() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4, 5, 6), LottoRank.FIRST_PLACE),
                Arguments.of(List.of(1, 2, 3, 4, 5, 7), LottoRank.SECOND_PLACE),
                Arguments.of(List.of(1, 2, 3, 4, 5, 8), LottoRank.THIRD_PLACE),
                Arguments.of(List.of(1, 2, 3, 4, 7, 8), LottoRank.FOURTH_PLACE),
                Arguments.of(List.of(1, 2, 3, 7, 8, 9), LottoRank.FIFTH_PLACE)
        );
    }
}