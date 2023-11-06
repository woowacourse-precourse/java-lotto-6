package lotto.domain.lotto;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.stream.Stream;
import lotto.domain.result.WinningRank;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class WinningLottoTest {


    @ParameterizedTest
    @DisplayName("BonusNumber가 Lotto와 중복되는 숫자라면 예외가 발생헌다.")
    @ValueSource(ints = {1, 2, 3})
    void WinningLott_생성_예외(int number) {
        // given
        BonusNumber bonusNumber = new BonusNumber(number);
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        Assertions.assertThatThrownBy(() -> new WinningLotto(lotto, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("BonusNumber가 Lotto와 중복되지 않는다면 생성 성공")
    @ValueSource(ints = {7, 30, 45})
    void WinningLotto_생성_성공(int number) {
        // given
        BonusNumber bonusNumber = new BonusNumber(number);
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        assertDoesNotThrow(() -> new WinningLotto(lotto, bonusNumber));
    }

    @ParameterizedTest
    @DisplayName("lotto가 몇등에 당첨됬는지 찾아주는 기능 테스트")
    @MethodSource("argumentsFindWinningRankWithLotto")
    void find_winningrank(Lotto otherLotto, WinningRank expected) {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = new BonusNumber(7);
        WinningLotto winningLotto = new WinningLotto(lotto, bonusNumber);
        // when
        WinningRank winningRank = winningLotto.findWinningRank(otherLotto);

        // then
        Assertions.assertThat(winningRank).isEqualTo(expected);

    }

    public static Stream<Arguments> argumentsFindWinningRankWithLotto() {
        return Stream.of(
                Arguments.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)), WinningRank.FIRST),
                Arguments.of(new Lotto(List.of(1, 2, 3, 4, 5, 7)), WinningRank.SECOND),
                Arguments.of(new Lotto(List.of(1, 2, 3, 4, 5, 8)), WinningRank.THIRD),
                Arguments.of(new Lotto(List.of(1, 2, 3, 4, 8, 9)), WinningRank.FOURTH),
                Arguments.of(new Lotto(List.of(1, 2, 3, 8, 9, 10)), WinningRank.FIFTH),
                Arguments.of(new Lotto(List.of(1, 7, 8, 9, 10, 11)), WinningRank.EMPTY)
        );
    }

    // todo : 값이 제대로 생성되었는지?
}