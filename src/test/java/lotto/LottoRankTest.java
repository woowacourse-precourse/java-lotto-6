package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("로또 당첨 확인 테스트")
class LottoRankTest {
    @DisplayName("성공: 1등을 확인할 수 있다.")
    @Test
    void test1() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(numbers);

        WinningLotto winningLotto = new WinningLotto(lotto, 7);
        assertThat(LottoRank.getRank(lotto, winningLotto)).isEqualTo(LottoRank.FIRST);
    }

    @DisplayName("성공: 2등을 확인할 수 있다.")
    @Test
    void test2() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(numbers);

        List<Integer> pickedNumbers = List.of(1, 2, 3, 4, 5, 7);
        Lotto pickedLotto = new Lotto(pickedNumbers);
        WinningLotto winningLotto = new WinningLotto(pickedLotto, 6);
        assertThat(LottoRank.getRank(lotto, winningLotto)).isEqualTo(LottoRank.SECOND);
    }

    @DisplayName("성공: 3등을 확인할 수 있다.")
    @Test
    void test3() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(numbers);

        List<Integer> pickedNumbers = List.of(1, 2, 3, 4, 5, 10);
        Lotto pickedLotto = new Lotto(pickedNumbers);
        WinningLotto winningLotto = new WinningLotto(pickedLotto, 11);
        assertThat(LottoRank.getRank(lotto, winningLotto)).isEqualTo(LottoRank.THIRD);
    }

    @DisplayName("성공: 4등을 확인할 수 있다.")
    @Test
    void test4() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(numbers);

        List<Integer> pickedNumbers = List.of(1, 2, 3, 4, 10, 11);
        Lotto pickedLotto = new Lotto(pickedNumbers);
        WinningLotto winningLotto = new WinningLotto(pickedLotto, 12);
        assertThat(LottoRank.getRank(lotto, winningLotto)).isEqualTo(LottoRank.FOURTH);
    }

    @DisplayName("성공: 5등을 확인할 수 있다.")
    @Test
    void test5() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(numbers);

        List<Integer> pickedNumbers = List.of(1, 2, 3, 9, 10, 11);
        Lotto pickedLotto = new Lotto(pickedNumbers);
        WinningLotto winningLotto = new WinningLotto(pickedLotto, 12);
        assertThat(LottoRank.getRank(lotto, winningLotto)).isEqualTo(LottoRank.FIFTH);
    }

    @DisplayName("성공: 당첨되지 않음을 확인할 수 있다.")
    @Test
    void test6() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(numbers);

        List<Integer> pickedNumbers = List.of(7, 8, 9, 10, 11, 12);
        Lotto pickedLotto = new Lotto(pickedNumbers);
        WinningLotto winningLotto = new WinningLotto(pickedLotto, 13);
        assertThat(LottoRank.getRank(lotto, winningLotto)).isEqualTo(null);
    }
}