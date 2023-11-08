package lotto.model;

import lotto.constant.response.Exception;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class WinningLottoTest {

    @DisplayName("당첨 번호 추첨 시 로또 번호 6개와 로또 번호에 해당하는 보너스 번호 1개를 뽑는다.")
    @Test
    void registerWinningLotto() {
        List<Integer> winningLotto = List.of(1, 2, 3, 4, 5, 6);
        Integer bonusNumber = Integer.valueOf(7);
        assertThat(new WinningLotto(new Lotto(winningLotto), new LottoNumber(bonusNumber)))
                .isInstanceOf(WinningLotto.class);
    }

    @DisplayName("당첨 로또 번호 6개와 보너스 번호가 중복될 시 예외가 발생한다.")
    @Test
    void validateDuplicate() {
        List<Integer> winningLotto = List.of(1, 2, 3, 4, 5, 6);
        Integer bonusNumber = Integer.valueOf(3);
        assertThatThrownBy(() -> new WinningLotto(new Lotto(winningLotto), new LottoNumber(bonusNumber)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Exception.ERROR_PREFIX.getMessage())
                .hasMessageContaining(Exception.WINNING_NUMBERS_DUPLICATE.getMessage());
    }

    @DisplayName("다른 로또의 당첨 등수를 알 수 있다.")
    @ParameterizedTest
    @MethodSource("rankData")
    void compare(Lotto targetLotto, Rank rank) {
        WinningLotto winningLotto = new WinningLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)), new LottoNumber(7));
        assertThat(winningLotto.compare(targetLotto)).isEqualTo(rank);
    }

    static Stream<Arguments> rankData() {
        return Stream.of(
                arguments(new Lotto(List.of(1, 2, 3, 4, 5, 6)), Rank.FIRST_PLACE),
                arguments(new Lotto(List.of(1, 2, 3, 4, 5, 7)), Rank.SECOND_PLACE),
                arguments(new Lotto(List.of(1, 2, 3, 4, 5, 13)), Rank.THIRD_PLACE),
                arguments(new Lotto(List.of(1, 2, 3, 5, 7, 12)), Rank.FOURTH_PLACE),
                arguments(new Lotto(List.of(1, 2, 3, 7, 8, 12)), Rank.FIFTH_PLACE),
                arguments(new Lotto(List.of(1, 12, 17, 23, 28, 34)), Rank.LAST_PLACE)
        );
    }

}