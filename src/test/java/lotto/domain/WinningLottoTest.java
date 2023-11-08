package lotto.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class WinningLottoTest {
    private List<Integer> winningNumbers;

    @BeforeEach
    void setUp() {
        winningNumbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
    }

    @ParameterizedTest
    @ValueSource(ints = {7, 13})
    @DisplayName("로또 번호가 0개 맞은 경우의 결과를 반환한다.")
    void matchZeroCaseTest(int bonusNumber) {
        //given
        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);
        Lotto lotto = new Lotto(List.of(7, 8, 9, 10, 11, 12));

        //when
        Rank result = winningLotto.matchingNumbers(lotto);

        //then
        assertThat(result).isEqualTo(Rank.NOTHING_ZERO);
        assertThat(0).isEqualTo(result.getPrize());
    }

    @ParameterizedTest
    @ValueSource(ints = {7, 13})
    @DisplayName("로또 번호가 1개 맞은 경우의 결과를 반환한다.")
    void matchOneCaseTest(int bonusNumber) {
        //given
        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);
        Lotto lotto = new Lotto(List.of(6, 7, 8, 9, 10, 11));

        //when
        Rank result = winningLotto.matchingNumbers(lotto);

        //then
        assertThat(result).isEqualTo(Rank.NOTHING_ZERO);
        assertThat(0).isEqualTo(result.getPrize());
    }

    @ParameterizedTest
    @ValueSource(ints = {7, 13})
    @DisplayName("로또 번호가 2개 맞은 경우의 결과를 반환한다.")
    void matchTwoCaseTest(int bonusNumber) {
        //given
        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);
        Lotto lotto = new Lotto(List.of(5, 6, 7, 8, 9, 10));

        //when
        Rank result = winningLotto.matchingNumbers(lotto);

        //then
        assertThat(result).isEqualTo(Rank.NOTHING_ZERO);
        assertThat(0).isEqualTo(result.getPrize());
    }

    @ParameterizedTest
    @ValueSource(ints = {7, 13})
    @DisplayName("로또 번호가 3개 맞은 경우의 결과를 반환한다.")
    void matchThreeCaseTest(int bonusNumber) {
        //given
        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);
        Lotto lotto = new Lotto(List.of(4, 5, 6, 7, 8, 9));

        //when
        Rank result = winningLotto.matchingNumbers(lotto);

        //then
        assertThat(result).isEqualTo(Rank.FIFTH);
        assertThat(5000).isEqualTo(result.getPrize());
    }

    @ParameterizedTest
    @ValueSource(ints = {7, 13})
    @DisplayName("로또 번호가 4개 맞은 경우의 결과를 반환한다.")
    void matchFourCaseTest(int bonusNumber) {
        //given
        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);
        Lotto lotto = new Lotto(List.of(3, 4, 5, 6, 7, 8));

        //when
        Rank result = winningLotto.matchingNumbers(lotto);

        //then
        assertThat(result).isEqualTo(Rank.FOURTH);
        assertThat(50000).isEqualTo(result.getPrize());
    }

    @Test
    @DisplayName("로또 번호가 5개 맞고 보너스가 맞지 않는 경우의 결과를 반환한다.")
    void matchFiveAndNotBonusCaseTest() {
        //given
        WinningLotto winningLotto = new WinningLotto(winningNumbers, 13);
        Lotto lotto = new Lotto(List.of(2, 3, 4, 5, 6, 7));

        //when
        Rank result = winningLotto.matchingNumbers(lotto);

        //then
        assertThat(result).isEqualTo(Rank.THIRD);
        assertThat(1500000).isEqualTo(result.getPrize());
    }

    @Test
    @DisplayName("로또 번호가 5개 맞고 보너스가 맞는 경우의 결과를 반환한다.")
    void matchFiveAndBonusCaseTest() {
        //given
        WinningLotto winningLotto = new WinningLotto(winningNumbers, 7);
        Lotto lotto = new Lotto(List.of(2, 3, 4, 5, 6, 7));

        //when
        Rank result = winningLotto.matchingNumbers(lotto);

        //then
        assertThat(result).isEqualTo(Rank.SECOND);
        assertThat(30000000).isEqualTo(result.getPrize());
    }

    @Test
    @DisplayName("로또 번호가 6개 맞은 경우의 결과를 반환한다.")
    void matchSixCaseTest() {
        //given
        WinningLotto winningLotto = new WinningLotto(winningNumbers, 7);
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        //when
        Rank result = winningLotto.matchingNumbers(lotto);

        //then
        assertThat(result).isEqualTo(Rank.FIRST);
        assertThat(2000000000).isEqualTo(result.getPrize());
    }
}