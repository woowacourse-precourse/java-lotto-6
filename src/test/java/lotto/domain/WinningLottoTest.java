package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
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
    private WinningLotto winningLotto;

    @BeforeEach
    void setUp() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = new BonusNumber(7);

        winningLotto = new WinningLotto(lotto, bonusNumber);
    }

    @Test
    @DisplayName("당첨 로또는 중복되지 않는 6개의 숫자와 보너스 번호 1개를 가진다.")
    void createWiningLotto() {
        assertThat(winningLotto).isEqualTo(
                new WinningLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)), new BonusNumber(7)));
    }

    @Test
    @DisplayName("6개의 숫자 중 보너스 번호와 일치하는 숫자가 있으면 예외가 발생한다.")
    void invalidWinningLotto() {
        assertThatThrownBy(() -> new WinningLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)), new BonusNumber(6)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("당첨 번호 중 보너스 번호와 일치하는 숫자가 존재합니다.");
    }

    @ParameterizedTest
    @MethodSource("userLottoAndLottoRanking")
    @DisplayName("1장의 로또와 당첨 번호를 비교하여 결과를 알 수 있다.")
    void compare(Lotto userLotto, LottoRanking expected) {
        LottoRanking actual = winningLotto.compare(userLotto);

        assertThat(actual).isEqualTo(expected);
    }

    static Stream<Arguments> userLottoAndLottoRanking() {
        return Stream.of(
                arguments(new Lotto(List.of(1, 2, 3, 4, 5, 6)), LottoRanking.FIRST),
                arguments(new Lotto(List.of(1, 2, 3, 4, 5, 7)), LottoRanking.SECOND),
                arguments(new Lotto(List.of(1, 2, 3, 4, 5, 16)), LottoRanking.THIRD),
                arguments(new Lotto(List.of(1, 2, 3, 4, 15, 16)), LottoRanking.FOURTH),
                arguments(new Lotto(List.of(1, 2, 3, 14, 15, 16)), LottoRanking.FIFTH),
                arguments(new Lotto(List.of(1, 2, 13, 14, 15, 16)), LottoRanking.NOTHING)
        );
    }
}