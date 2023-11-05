package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultTest {
    @DisplayName("6개의 번호가 일치하면 1등을 반환한다.")
    @Test
    void firstPriceLottoResult() {
        DrawingLotto drawingLotto = new DrawingLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 7);
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        assertThat(drawingLotto.compareWith(lotto)).isEqualTo(LottoResult.FIRST);
    }

    @DisplayName("5개의 번호와 보너스 번호가 일치하면 2등을 반환한다.")
    @Test
    void secondPriceLottoResult() {
        DrawingLotto drawingLotto = new DrawingLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 7);
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));

        assertThat(drawingLotto.compareWith(lotto)).isEqualTo(LottoResult.SECOND);
    }

    @DisplayName("5개의 번호가 일치하고 보너스 번호가 일치하지 않으면 3등을 반환한다.")
    @Test
    void thirdPriceLottoResult() {
        DrawingLotto drawingLotto = new DrawingLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 7);
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 8));

        assertThat(drawingLotto.compareWith(lotto)).isEqualTo(LottoResult.THIRD);
    }

    @DisplayName("4개의 번호가 일치하면 4등을 반환한다.")
    @Test
    void fourthPriceLottoResult() {
        DrawingLotto drawingLotto = new DrawingLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 7);
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 7, 8));

        assertThat(drawingLotto.compareWith(lotto)).isEqualTo(LottoResult.FOURTH);
    }

    @DisplayName("3개의 번호가 일치하면 5등을 반환한다.")
    @Test
    void fifthPriceLottoResult() {
        DrawingLotto drawingLotto = new DrawingLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 7);
        Lotto lotto = new Lotto(List.of(1, 2, 3, 7, 8, 9));

        assertThat(drawingLotto.compareWith(lotto)).isEqualTo(LottoResult.FIFTH);
    }

    @DisplayName("3개 미만의 번호가 일치하면 미당첨을 반환한다.")
    @Test
    void nonePriceLottoResult() {
        DrawingLotto drawingLotto = new DrawingLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 7);
        Lotto lotto = new Lotto(List.of(1, 2, 7, 8, 9, 10));

        assertThat(drawingLotto.compareWith(lotto)).isEqualTo(LottoResult.NONE);
    }
}
