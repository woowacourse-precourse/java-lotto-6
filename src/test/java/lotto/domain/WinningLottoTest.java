package lotto.domain;

import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoNumber;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class WinningLottoTest {

    WinningLotto winningLotto;

    @BeforeEach
    void setWinningLotto() {
        winningLotto = new WinningLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void saveBonusNumberTest(int input) {
        assertThatThrownBy(() -> winningLotto.saveBonusNumber(LottoNumber.of(input)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 보너스 넘버는 당첨 번호와 중복되어선 안됩니다");
    }

    @ParameterizedTest
    @MethodSource("provideData")
    void getRankingTest(Lotto lotto, Ranking ranking) {
        winningLotto.saveBonusNumber(LottoNumber.of(7));
        assertThat(winningLotto.getRanking(lotto)).isEqualTo(ranking);
    }

    static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)), Ranking.FIRST),
                Arguments.of(new Lotto(List.of(1, 2, 3, 4, 5, 7)), Ranking.SECOND),
                Arguments.of(new Lotto(List.of(1, 2, 3, 4, 5, 10)), Ranking.THIRD),
                Arguments.of(new Lotto(List.of(1, 2, 3, 4, 10, 11)), Ranking.FOURTH),
                Arguments.of(new Lotto(List.of(1, 2, 3, 4, 7, 11)), Ranking.FOURTH),
                Arguments.of(new Lotto(List.of(1, 2, 3, 10, 11, 12)), Ranking.FIFTH),
                Arguments.of(new Lotto(List.of(1, 2, 3, 7, 11, 12)), Ranking.FIFTH),
                Arguments.of(new Lotto(List.of(1, 2, 10, 11, 12, 13)), Ranking.NONE),
                Arguments.of(new Lotto(List.of(1, 2, 10, 11, 12, 7)), Ranking.NONE),
                Arguments.of(new Lotto(List.of(1, 10, 11, 12, 13, 7)), Ranking.NONE)
        );
    }

}