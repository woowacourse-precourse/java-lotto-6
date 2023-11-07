package lotto.domain.prize;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoWinningNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoPrizeCalculatorTest {

    @DisplayName("보너스 번호 일치 여부와 관계없이 6개 번호가 일치하면 1등이다.")
    @Test
    void first() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        LottoWinningNumbers winningNumbers = LottoWinningNumbers.of(List.of(1, 2, 3, 4, 5, 6), 7);

        LottoPrizeCalculator calculator = new LottoPrizeCalculator();

        // when
        LottoPrizeType result = calculator.calculatePrize(winningNumbers, lotto).get();

        // then
        assertThat(result).isEqualTo(LottoPrizeType.FIRST);
    }

    @DisplayName("5개 번호가 일치하고 보너스 번호가 일치하면 2등이다.")
    @Test
    void second() {
        // given
        int bonusNumber = 7;

        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, bonusNumber));
        LottoWinningNumbers winningNumbers = LottoWinningNumbers.of(List.of(1, 2, 3, 4, 5, 45), bonusNumber);

        LottoPrizeCalculator calculator = new LottoPrizeCalculator();

        // when
        LottoPrizeType result = calculator.calculatePrize(winningNumbers, lotto).get();

        // then
        assertThat(result).isEqualTo(LottoPrizeType.SECOND);
    }

    @DisplayName("5개 번호가 일치하고 보너스 번호가 일치하지 않으면 3등이다.")
    @Test
    void third() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        LottoWinningNumbers winningNumbers = LottoWinningNumbers.of(List.of(1, 2, 3, 4, 5, 45), 7);

        LottoPrizeCalculator calculator = new LottoPrizeCalculator();

        // when
        LottoPrizeType result = calculator.calculatePrize(winningNumbers, lotto).get();

        // then
        assertThat(result).isEqualTo(LottoPrizeType.THIRD);
    }

    @DisplayName("보너스 번호 일치 여부와 관계없이 4개 번호가 일치하면 4등이다.")
    @Test
    void fourth() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        LottoWinningNumbers winningNumbers = LottoWinningNumbers.of(List.of(1, 2, 3, 4, 35, 36), 6);

        LottoPrizeCalculator calculator = new LottoPrizeCalculator();

        // when
        LottoPrizeType result = calculator.calculatePrize(winningNumbers, lotto).get();

        // then
        assertThat(result).isEqualTo(LottoPrizeType.FOURTH);
    }

    @DisplayName("보너스 번호 일치 여부와 관계없이 3개 번호가 일치하면 5등이다.")
    @Test
    void fifth() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        LottoWinningNumbers winningNumbers = LottoWinningNumbers.of(List.of(1, 2, 3, 34, 35, 36), 6);

        LottoPrizeCalculator calculator = new LottoPrizeCalculator();

        // when
        LottoPrizeType result = calculator.calculatePrize(winningNumbers, lotto).get();

        // then
        assertThat(result).isEqualTo(LottoPrizeType.FIFTH);
    }

}
