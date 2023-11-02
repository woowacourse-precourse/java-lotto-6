package lotto.model;

import static lotto.constant.LottoRanking.FIRST;
import static lotto.constant.LottoRanking.FOURTH;
import static lotto.constant.LottoRanking.NONE;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.constant.LottoRanking;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class WinningNumberTest {

    @Nested
    @DisplayName("로또 번호와 당첨 번호를 비교")
    class compareLottoNumberAndWinningNumber {
        @Test
        @DisplayName("1등")
        void First() {
            WinningNumber winningNumber = new WinningNumber(List.of(1, 2, 3, 4, 5, 6));
            List<Integer> lottoNumber = List.of(1, 2, 3, 4, 5, 6);

            LottoRanking lottoRanking = winningNumber.compareNumbers(lottoNumber);

            assertThat(lottoRanking).isEqualTo(FIRST);
        }

        @Test
        @DisplayName("4등")
        void Fourth() {
            WinningNumber winningNumber = new WinningNumber(List.of(1, 2, 3, 4, 5, 6));
            List<Integer> lottoNumber = List.of(1, 2, 3, 4, 7, 8);

            LottoRanking lottoRanking = winningNumber.compareNumbers(lottoNumber);

            assertThat(lottoRanking).isEqualTo(FOURTH);
        }

        @Test
        @DisplayName("꽝")
        void None() {
            WinningNumber winningNumber = new WinningNumber(List.of(1, 2, 3, 4, 5, 6));
            List<Integer> lottoNumber = List.of(10, 20, 30, 40, 50, 60);

            LottoRanking lottoRanking = winningNumber.compareNumbers(lottoNumber);

            assertThat(lottoRanking).isEqualTo(NONE);
        }
    }
}