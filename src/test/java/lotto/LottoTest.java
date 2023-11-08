package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

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
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    // 아래에 추가 테스트 작성 가능

    @DisplayName("로또 출력")
    @Test
    void printLotto() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        Lotto lotto = new Lotto(List.of(6,1,4,3,2,5));

        lotto.printNumbers();

        String expectedOutput = "[1, 2, 3, 4, 5, 6]";

        assertEquals(outContent.toString().trim(), expectedOutput);

        System.setOut(System.out);
    }

    @DisplayName("로또 번호와 당첨 번호 비교하여 1등 당첨 여부 확인.")
    @Test
    void checkWinningNumberByFIRST() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        WinningNumber winningNumber = new WinningNumber(numbers, bonusNumber);

        Rank rank = lotto.checkWinning(winningNumber);

        assertThat(rank).isEqualTo(Rank.FIRST);
    }

    @DisplayName("로또 번호와 당첨 번호 비교하여 2등 당첨 여부 확인.")
    @Test
    void checkWinningNumberBySECOND() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));

        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        WinningNumber winningNumber = new WinningNumber(numbers, bonusNumber);

        Rank rank = lotto.checkWinning(winningNumber);

        assertThat(rank).isEqualTo(Rank.SECOND);
    }

    @DisplayName("로또 번호와 당첨 번호 비교하여 3등 당첨 여부 확인.")
    @Test
    void checkWinningNumberByTHIRD() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 8));

        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        WinningNumber winningNumber = new WinningNumber(numbers, bonusNumber);

        Rank rank = lotto.checkWinning(winningNumber);

        assertThat(rank).isEqualTo(Rank.THIRD);
    }

    @DisplayName("로또 번호와 당첨 번호 비교하여 4등 당첨 여부 확인.")
    @Test
    void checkWinningNumberByFOURTH() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 7, 8));

        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);

        int bonusNumber = 7;
        WinningNumber winningNumber = new WinningNumber(numbers, bonusNumber);
        Rank rank = lotto.checkWinning(winningNumber);

        assertThat(rank).isEqualTo(Rank.FOURTH);

        bonusNumber=9;
        WinningNumber winningNumberNoBonus = new WinningNumber(numbers, bonusNumber);
        Rank rankNoBonus = lotto.checkWinning(winningNumberNoBonus);

        assertThat(rankNoBonus).isEqualTo(Rank.FOURTH);
    }

    @DisplayName("로또 번호와 당첨 번호 비교하여 5등 당첨 여부 확인.")
    @Test
    void checkWinningNumberByFIFTH() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 8, 9, 10));

        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);

        int bonusNumber = 8;
        WinningNumber winningNumber = new WinningNumber(numbers, bonusNumber);
        Rank rank = lotto.checkWinning(winningNumber);

        assertThat(rank).isEqualTo(Rank.FIFTH);

        bonusNumber=11;
        WinningNumber winningNumberNoBonus = new WinningNumber(numbers, bonusNumber);
        Rank rankNoBonus = lotto.checkWinning(winningNumberNoBonus);

        assertThat(rankNoBonus).isEqualTo(Rank.FIFTH);
    }

    @DisplayName("로또 번호와 당첨 번호 비교하여 당첨 안되는 경우 확인.")
    @Test
    void checkWinningNumberByNoPrize() {
        Lotto lotto = new Lotto(List.of(1, 2, 7, 8, 9, 10));

        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        WinningNumber winningNumber = new WinningNumber(numbers, bonusNumber);

        Rank rank = lotto.checkWinning(winningNumber);

        assertThat(rank).isEqualTo(Rank.NO_PRIZE);
    }

}