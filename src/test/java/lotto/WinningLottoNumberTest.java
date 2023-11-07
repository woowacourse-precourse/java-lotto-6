package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.stream.Stream;
import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.domain.WinningLottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class WinningLottoNumberTest {
    private final Lotto testLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
    private final WinningLottoNumber winningLottoNumber
            = WinningLottoNumber.of(new Lotto(List.of(1,2,3,4,5,7)), 8);

    @DisplayName("로또 번호와 중복된 값을 보너스 번호로 입력하면 예외가 발생한다.")
    @Test
    void BonusNumberIsAlreadyInLottoNumbersTest() {
        assertThatThrownBy(() -> WinningLottoNumber.of(testLotto, 1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("범위를 벗어나는 수를 보너스 번호로 입력하면 예외가 발생한다.")
    @Test
    void BonusNumberIsNotInRangeTest() {
        assertThatThrownBy(() -> WinningLottoNumber.of(testLotto, 46))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("로또 번호와 당첨 번호를 비교한 등수와 실제 등수가 맞는지 확인한다.")
    @MethodSource("generateLottoData")
    void MatchCountTest(Lotto playerLotto, LottoRank expectedRank) {
        LottoRank rank = winningLottoNumber.calculateLottoPrize(playerLotto);

        assertThat(rank).isEqualTo(expectedRank);
    }

    static Stream<Arguments> generateLottoData() {
        return Stream.of (
                Arguments.of(new Lotto(List.of(1,2,3,4,5,7)), LottoRank.FIRST_RANK),
                Arguments.of(new Lotto(List.of(1,2,3,4,5,8)), LottoRank.SECOND_RANK),
                Arguments.of(new Lotto(List.of(1,2,3,4,5,6)), LottoRank.THIRD_RANK),
                Arguments.of(new Lotto(List.of(3,4,5,6,7,8)), LottoRank.FOURTH_RANK),
                Arguments.of(new Lotto(List.of(4,5,6,7,8,9)), LottoRank.FIFTH_RANK),
                Arguments.of(new Lotto(List.of(10,11,12,13,14,15)), LottoRank.NO_LUCK)
        );
    }
}