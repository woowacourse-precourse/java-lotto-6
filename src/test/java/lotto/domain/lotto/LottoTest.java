package lotto.domain.lotto;

import lotto.domain.result.Result;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

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
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 당첨번호가_모두_일치하는_경우_일등_결과를_반환한다() {
        // Given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        WinningLotto winningLotto = WinningLottoGenerator.generateWinningLotto(List.of(1, 2, 3, 4, 5, 6), 7);

        // When
        Result actual = lotto.getResult(winningLotto);

        // Then
        Assertions.assertEquals(Result.FIRST, actual);
    }

    @Test
    void 당첨번호5개와_보너스번호가_일치하는_경우_이등_결과를_반환한다() {
        // Given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        WinningLotto winningLotto = WinningLottoGenerator.generateWinningLotto(List.of(1, 2, 3, 4, 5, 6), 7);

        // When
        Result actual = lotto.getResult(winningLotto);

        // Then
        Assertions.assertEquals(Result.SECOND, actual);
    }

    @Test
    void 당첨번호5개가_일치하는_경우_삼등_결과를_반환한다() {
        // Given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 8));
        WinningLotto winningLotto = WinningLottoGenerator.generateWinningLotto(List.of(1, 2, 3, 4, 5, 6), 7);

        // When
        Result actual = lotto.getResult(winningLotto);

        // Then
        Assertions.assertEquals(Result.THIRD, actual);
    }

    @Test
    void 당첨번호3개_미만으로_일치하는_경우_삼등_결과를_반환한다() {
        // Given
        Lotto lotto = new Lotto(List.of(1, 2, 7, 8, 9, 10));
        WinningLotto winningLotto = WinningLottoGenerator.generateWinningLotto(List.of(1, 2, 3, 4, 5, 6), 7);

        // When
        Result actual = lotto.getResult(winningLotto);

        // Then
        Assertions.assertEquals(Result.MISS, actual);
    }
}