package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottosTest {
    List<Lotto> lotto;

    @BeforeEach
    void setUp() {
        lotto = List.of(
                new Lotto(List.of(43, 21, 23, 42, 41, 8)),
                new Lotto(List.of(5, 3, 16, 11, 38, 32)),
                new Lotto(List.of(22, 45, 5, 14, 1, 3))
        );
    }

    @DisplayName("[SUCCESS]Lottos에 포함된 모든 Lotto의 정렬된 번호를 가져온다")
    @Test
    void getsAllLottoNumber() {
        // given
        Lottos lottos = new Lottos(lotto);

        // when
        List<String> lottosNumber = lottos.getLottosAllSortedNumber();

        // then
        assertThat(lottosNumber)
                .isEqualTo(List.of(
                        "[8, 21, 23, 41, 42, 43]",
                        "[3, 5, 11, 16, 32, 38]",
                        "[1, 3, 5, 14, 22, 45]"));
    }

    @DisplayName("[SUCCESS]Lottos에 포함된 Lotto의 개수를 가져온다")
    @Test
    void getLottosAmount() {
        // given
        Lottos lottos = new Lottos(lotto);

        // when
        int lottosAmount = lottos.getLottosAmount();

        // then
        assertThat(lottosAmount)
                .isEqualTo(3);
    }

    
    @DisplayName("[SUCCESS]당첨 번호와 보너스 번호로 각 로또의 등수를 계산한다.")
    @Test
    void checkCalculatedLottoResult() {
        // given
        Lottos lottos = new Lottos(lotto);

        // when
        WinningNumber winningNumber = new WinningNumber(List.of(43, 21, 23, 1, 2, 3));
        BonusNumber bonusNumber = new BonusNumber(winningNumber, 10);

        // then
        assertThat(lottos.calculateLottoResult(winningNumber, bonusNumber))
                .isEqualTo(Arrays.asList(LottoRank.FIFTH,LottoRank.FAIL,LottoRank.FAIL));
    }
}