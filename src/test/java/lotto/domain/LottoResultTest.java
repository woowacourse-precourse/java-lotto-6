package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.global.constant.WinningType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class LottoResultTest {

    @DisplayName("로또 결과를 계산 시")
    @Nested
    class CalculateResultTest {

        private WinningLotto winningLotto;

        @BeforeEach
        void setUp() {
            List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
            int bonusNumber = 7;

            winningLotto = new WinningLotto(new Lotto(winningNumbers), bonusNumber);
        }

        @DisplayName("모든 번호 일치 시 winningType은 FIRST이다.")
        @Test
        void should_winningTypeIsFIRST_when_allMatch() {
            List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
            LottoResult lottoResult = new LottoResult(new Lotto(numbers));

            lottoResult.calculateResult(winningLotto);
            assertThat(lottoResult.getWinningType()).isEqualTo(WinningType.FIRST);
        }

        @DisplayName("5개 번호와 보너스 번호 일치 시 winningType은 SECOND이다.")
        @Test
        void should_winningTypeIsSECOND_when_fiveAndBonusMatch() {
            List<Integer> numbers = List.of(1, 2, 3, 4, 5, 7);
            LottoResult lottoResult = new LottoResult(new Lotto(numbers));

            lottoResult.calculateResult(winningLotto);
            assertThat(lottoResult.getWinningType()).isEqualTo(WinningType.SECOND);
        }

        @DisplayName("5개 번호 일치 시 winningType은 THIRD이다.")
        @Test
        void should_winningTypeIsTHIRD_when_fiveMatch() {
            List<Integer> numbers = List.of(1, 2, 3, 4, 5, 8);
            LottoResult lottoResult = new LottoResult(new Lotto(numbers));

            lottoResult.calculateResult(winningLotto);
            assertThat(lottoResult.getWinningType()).isEqualTo(WinningType.THIRD);
        }

        @DisplayName("4개 번호 일치 시 winningType은 FOURTH이다.")
        @Test
        void should_winningTypeIsFOURTH_when_fourMatch() {
            List<Integer> numbers = List.of(1, 2, 3, 4, 8, 9);
            LottoResult lottoResult = new LottoResult(new Lotto(numbers));

            lottoResult.calculateResult(winningLotto);
            assertThat(lottoResult.getWinningType()).isEqualTo(WinningType.FOURTH);
        }

        @DisplayName("3개 번호 일치 시 winningType은 FIFTH이다.")
        @Test
        void should_winningTypeIsFIFTH_when_threeMatch() {
            List<Integer> numbers = List.of(1, 2, 3, 8, 9, 10);
            LottoResult lottoResult = new LottoResult(new Lotto(numbers));

            lottoResult.calculateResult(winningLotto);
            assertThat(lottoResult.getWinningType()).isEqualTo(WinningType.FIFTH);
        }

        @DisplayName("2개 이하 번호 일치 시 winningType은 OTHER이다.")
        @Test
        void should_winningTypeIsOTHER_when_lessOrEqualMatch3() {
            List<Integer> numbers = List.of(1, 2, 8, 9, 10, 11);
            List<Integer> numbers2 = List.of(1, 8, 9, 10, 11, 12);
            List<Integer> numbers3 = List.of(8, 9, 10, 11, 12, 13);
            List<List<Integer>> numbersAsset = List.of(numbers, numbers2, numbers3);

            for (int index = 0; index < 3; index++) {
                LottoResult lottoResult = new LottoResult(new Lotto(numbersAsset.get(index)));
                lottoResult.calculateResult(winningLotto);
                assertThat(lottoResult.getWinningType()).isEqualTo(WinningType.OTHER);
            }
        }
    }
}
