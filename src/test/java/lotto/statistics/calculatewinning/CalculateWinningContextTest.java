package lotto.statistics.calculatewinning;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.Either;
import lotto.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CalculateWinningContextTest {

  @DisplayName("당첨기록을 반환한다.")
  @Test
  void getWinningRecords() {
    // given
    List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
    Lotto e1 = new Lotto(numbers);
    Lotto e2 = new Lotto(List.of(1, 2, 3, 4, 5, 7));
    Lotto e3 = new Lotto(List.of(1, 2, 3, 4, 5, 8));
    Lotto e4 = new Lotto(List.of(1, 2, 3, 41, 42, 43));
    Lotto e5 = new Lotto(List.of(1, 2, 3, 4, 5, 7));

    // when
    Either<NotWin, List<WinningRecord>> calculateResult = CalculateWinningContext.calculateWinning(
        List.of(e1, e2, e3, e4, e5), new Lotto(numbers), 7);

    // then
    assertThat(calculateResult.isRight()).isTrue();
    assertThat(calculateResult.getRight()).containsExactly(
        new WinningRecord(Ranking.FIFTH, 2),
        new WinningRecord(Ranking.THIRD, 1),
        new WinningRecord(Ranking.SECOND, 1),
        new WinningRecord(Ranking.FIRST, 1)
    );
  }


  @DisplayName("당첨기록이 없는 경우 미당첨을 반환한다.")
  @Test
  void winningRecords_is_empty() {
    // given
    List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
    Lotto e1 = new Lotto(List.of(1, 2, 12, 41, 42, 43));
    Lotto e2 = new Lotto(List.of(1, 2, 8, 41, 42, 43));
    Lotto e3 = new Lotto(List.of(1, 2, 9, 41, 42, 43));
    Lotto e4 = new Lotto(List.of(1, 2, 10, 41, 42, 43));
    Lotto e5 = new Lotto(List.of(1, 2, 11, 41, 42, 43));
    int bonusNumber = 7;

    // when
    Either<NotWin, List<WinningRecord>> calcaulteResult = CalculateWinningContext.calculateWinning(
        List.of(e1, e2, e3, e4, e5), new Lotto(numbers), bonusNumber);

    // then
    assertThat(calcaulteResult.isLeft()).isTrue();
    assertThat(calcaulteResult.getLeft()).isEqualTo(NotWin.NOT_WIN);
  }
}