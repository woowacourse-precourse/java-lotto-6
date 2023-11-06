package lotto.model;


import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("로또_결과_찾기_테스트")
class LottoResultTest {

    @Test
    @DisplayName("6개_일치_1등")
    void correct_compareLottoNums_first() {
        List<Integer> equalSix = List.of(1, 2, 3, 4, 5, 6);
        WinningLotto winningLotto = new WinningLotto("1,2,3,4,5,6", "7");

        Assertions.assertThat(LottoResult.compareLottoNums(equalSix, winningLotto))
                .isEqualTo(LottoResult.FIRST);
    }

    @Test
    @DisplayName("5개_일치_보너스_1개_2등")
    void correct_compareLottoNums_second() {
        List<Integer> equalFiveWithBonus = List.of(1, 2, 3, 4, 5, 7);
        WinningLotto winningLotto = new WinningLotto("1,2,3,4,5,6", "7");

        Assertions.assertThat(LottoResult.compareLottoNums(equalFiveWithBonus, winningLotto))
                .isEqualTo(LottoResult.SECOND);
    }
    @Test
    @DisplayName("5개_일치_3등")
    void correct_compareLottoNums_third() {
        List<Integer> equalFiveWithoutBonus = List.of(1, 2, 3, 4, 5, 8);
        WinningLotto winningLotto = new WinningLotto("1,2,3,4,5,6", "7");

        Assertions.assertThat(LottoResult.compareLottoNums(equalFiveWithoutBonus, winningLotto))
                .isEqualTo(LottoResult.THIRD);
    }
    @Test
    @DisplayName("4개_일치_4등")
    void correct_compareLottoNums_fourth() {
        List<Integer> equalFour = List.of(1, 2, 3, 4, 8, 9);
        List<Integer> equalFourWithBonus = List.of(1, 2, 3, 4, 7, 9);
        WinningLotto winningLotto = new WinningLotto("1,2,3,4,5,6", "7");

        Assertions.assertThat(LottoResult.compareLottoNums(equalFour, winningLotto))
                .isEqualTo(LottoResult.FOURTH);
        Assertions.assertThat(LottoResult.compareLottoNums(equalFourWithBonus, winningLotto))
                .isEqualTo(LottoResult.FOURTH);
    }
    @Test
    @DisplayName("5개_일치_5등")
    void correct_compareLottoNums_fifth() {
        List<Integer> equalThree = List.of(1, 2, 3, 8, 9, 10);
        List<Integer> equalThreeWithBonus = List.of(1, 2, 3, 7, 8, 9);
        WinningLotto winningLotto = new WinningLotto("1,2,3,4,5,6", "7");

        Assertions.assertThat(LottoResult.compareLottoNums(equalThree, winningLotto))
                .isEqualTo(LottoResult.FIFTH);
        Assertions.assertThat(LottoResult.compareLottoNums(equalThreeWithBonus, winningLotto))
                .isEqualTo(LottoResult.FIFTH);
    }
}