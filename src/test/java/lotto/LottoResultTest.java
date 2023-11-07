package lotto;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.LottoDraw;
import lotto.util.LottoResult;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoResultTest {

    @DisplayName("보너스 번호가 아닌 6개의 번호와 모두 일치하면 1등이라고 알려준다")
    @Test
    void firstPrize_when_equal_6_numbers() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        LottoDraw lottoDraw = new LottoDraw(List.of(1, 2, 3, 4, 5, 6), 10);

        LottoResult result = LottoResult.calculateResult(lotto, lottoDraw);

        Assertions.assertThat(result).isEqualTo(LottoResult.FIRST_PRIZE);
    }

    @DisplayName("5개의 번호와 1개의 보너스번호가 일치하면 2등이라고 알려준다")
    @Test
    void secondPrize_when_equal_5_numbers_and_1_bonusNum() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        LottoDraw lottoDraw = new LottoDraw(List.of(1, 2, 3, 4, 5, 10), 6);

        LottoResult result = LottoResult.calculateResult(lotto, lottoDraw);

        Assertions.assertThat(result).isEqualTo(LottoResult.SECOND_PRIZE);
    }

    @DisplayName("5개의 번호가 일치하고 보너스번호는 다르면 3등으로 간주한다")
    @Test
    void thirdPrize_when_equal_5_numbers() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        LottoDraw lottoDraw = new LottoDraw(List.of(1, 2, 3, 4, 5, 10), 12);

        LottoResult result = LottoResult.calculateResult(lotto, lottoDraw);

        Assertions.assertThat(result).isEqualTo(LottoResult.THIRD_PRIZE);
    }

    @DisplayName("4개의 번호가 일치하면 보너스번호가 일치여부와 상관없이 4등으로 간주한다")
    @Test
    void fourthPrize_when_equal_4_numbers() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        LottoDraw lottoDraw = new LottoDraw(List.of(1, 2, 3, 4, 20, 10), 5);

        LottoResult result = LottoResult.calculateResult(lotto, lottoDraw);

        Assertions.assertThat(result).isEqualTo(LottoResult.FOURTH_PRIZE);
    }


    @DisplayName("3개의 번호가 일치하면 일치여부와 상관없이 5등으로 간주한다")
    @Test
    void fifthPrize_when_equal_3_numbers() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        LottoDraw lottoDraw = new LottoDraw(List.of(1, 2, 3, 20, 40, 10), 4);

        LottoResult result = LottoResult.calculateResult(lotto, lottoDraw);

        Assertions.assertThat(result).isEqualTo(LottoResult.FIFTH_PRIZE);
    }

    @DisplayName("그외의 번호는 어떠한 당첨을 받지 못한다")
    @Test
    void noPrize_when_others() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        LottoDraw lottoDraw = new LottoDraw(List.of(1, 2, 9, 20, 40, 10), 12);

        LottoResult result = LottoResult.calculateResult(lotto, lottoDraw);

        Assertions.assertThat(result).isEqualTo(LottoResult.NO_PRIZE);
    }
}
