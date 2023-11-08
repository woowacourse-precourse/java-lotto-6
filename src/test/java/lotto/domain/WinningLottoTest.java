package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static lotto.Error.Domain.BONUS_NUMBER_ALREADY_EXIST;
import static lotto.Error.Domain.WRONG_LOTTO_NUMBER_RANGE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningLottoTest {
    private final Lotto answerLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

    @Test
    @DisplayName("보너스 번호가 로또 번호 중 하나와 중복되면 예외가 발생한다.")
    void 보너스_번호_중복_예외() {
        assertThatThrownBy(() -> new WinningLotto(answerLotto, 3))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(BONUS_NUMBER_ALREADY_EXIST.getText());
    }

    @Test
    @DisplayName("보너스 번호가 45 초과면 예외가 발생한다.")
    void 보너스_번호_45_초과_예외() {
        assertThatThrownBy(() -> new WinningLotto(answerLotto, 46))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(WRONG_LOTTO_NUMBER_RANGE.getText());
    }

    @Test
    @DisplayName("보너스 번호가 1 미만이면 예외가 발생한다.")
    void 보너스_번호_0_미만_예외() {
        assertThatThrownBy(() -> new WinningLotto(answerLotto, -1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(WRONG_LOTTO_NUMBER_RANGE.getText());
    }

    @ParameterizedTest()
    @MethodSource("firstRankParameter")
    @DisplayName("로또 등급이 FIRST가 나오면 성공한다.")
    void 로또_등급_FIRST_일치(List<Integer> parameter) {
        // given
        Lotto target = new Lotto(parameter);
        WinningLotto winningLotto = new WinningLotto(answerLotto, 7);
        //when
        LottoRankInfo rank = winningLotto.getLottoRank(target);
        //then
        assertThat(rank).isEqualTo(LottoRankInfo.FIRST);
    }

    @ParameterizedTest()
    @MethodSource("secondRankParameter")
    @DisplayName("로또 등급이 SECOND 나오면 성공한다.")
    void 로또_등급_SECOND_일치(List<Integer> parameter) {
        // given
        Lotto target = new Lotto(parameter);
        WinningLotto winningLotto = new WinningLotto(answerLotto, 7);
        //when
        LottoRankInfo rank = winningLotto.getLottoRank(target);
        //then
        assertThat(rank).isEqualTo(LottoRankInfo.SECOND);
    }

    @ParameterizedTest()
    @MethodSource("thirdRankParameter")
    @DisplayName("로또 등급이 THIRD 나오면 성공한다.")
    void 로또_등급_THIRD_일치(List<Integer> parameter) {
        // given
        Lotto target = new Lotto(parameter);
        WinningLotto winningLotto = new WinningLotto(answerLotto, 7);
        //when
        LottoRankInfo rank = winningLotto.getLottoRank(target);
        //then
        assertThat(rank).isEqualTo(LottoRankInfo.THIRD);
    }

    @ParameterizedTest()
    @MethodSource("fourthRankParameter")
    @DisplayName("로또 등급이 FOURTH 나오면 성공한다.")
    void 로또_등급_FOURTH_일치(List<Integer> parameter) {
        // given
        Lotto target = new Lotto(parameter);
        WinningLotto winningLotto = new WinningLotto(answerLotto, 7);
        //when
        LottoRankInfo rank = winningLotto.getLottoRank(target);
        //then
        assertThat(rank).isEqualTo(LottoRankInfo.FOURTH);
    }

    @ParameterizedTest()
    @MethodSource("noneRankParameter")
    @DisplayName("로또 등급이 NONE 나오면 성공한다.")
    void 로또_등급_NONE_일치(List<Integer> parameter) {
        // given
        Lotto target = new Lotto(parameter);
        WinningLotto winningLotto = new WinningLotto(answerLotto, 7);
        //when
        LottoRankInfo rank = winningLotto.getLottoRank(target);
        //then
        assertThat(rank).isEqualTo(LottoRankInfo.NONE);
    }

    private static Stream<Arguments> firstRankParameter() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4, 5, 6)),
                Arguments.of(List.of(2, 3, 4, 5, 6, 1)),
                Arguments.of(List.of(2, 1, 5, 4, 6, 3))
        );
    }

    private static Stream<Arguments> secondRankParameter() {
        return Stream.of(
                Arguments.of(List.of(7, 2, 3, 4, 5, 6)),
                Arguments.of(List.of(2, 3, 7, 5, 6, 1)),
                Arguments.of(List.of(2, 1, 5, 4, 7, 3))
        );
    }

    private static Stream<Arguments> thirdRankParameter() {
        return Stream.of(
                Arguments.of(List.of(45, 2, 3, 4, 5, 6)),
                Arguments.of(List.of(2, 3, 9, 5, 6, 1)),
                Arguments.of(List.of(2, 1, 5, 4, 42, 3))
        );
    }

    private static Stream<Arguments> fourthRankParameter() {
        return Stream.of(
                Arguments.of(List.of(7, 45, 3, 4, 5, 6)),
                Arguments.of(List.of(2, 3, 45, 8, 6, 1)),
                Arguments.of(List.of(2, 1, 5, 41, 7, 3))
        );
    }

    private static Stream<Arguments> fifthRankParameter() {
        return Stream.of(
                Arguments.of(List.of(7, 45, 8, 4, 5, 6)),
                Arguments.of(List.of(2, 7, 45, 8, 6, 1)),
                Arguments.of(List.of(2, 8, 5, 41, 7, 3))
        );
    }

    private static Stream<Arguments> noneRankParameter() {
        return Stream.of(
                Arguments.of(List.of(7, 45, 8, 10, 5, 6)),
                Arguments.of(List.of(11, 7, 45, 8, 6, 9)),
                Arguments.of(List.of(32, 8, 24, 41, 10, 23)),
                Arguments.of(List.of(1, 8, 24, 41, 10, 23))
        );
    }
}