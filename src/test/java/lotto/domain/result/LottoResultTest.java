package lotto.domain.result;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.LottoGame;
import lotto.domain.result.LottoResult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoResultTest {
    Lotto winnerLotto;
    BonusNumber bonusNumber;
    LottoGame lottoGame;

    @BeforeEach
    void setUp() {
        winnerLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7));
        bonusNumber = new BonusNumber(10);
        lottoGame = LottoGame.by(winnerLotto, bonusNumber);
    }

    @Test
    @DisplayName("모든 수 불일치 테스트")
    void 결과_0개가_일치() {
        Lotto lotto = new Lotto(Arrays.asList(11, 12, 13, 14, 15, 16));
        LottoResult lottoResult = new LottoResult(lottoGame, lotto);
        assertThat(lottoResult.getMatch()).isEqualTo(0);
    }

    @Test
    @DisplayName("3개가 일치하는지 테스트")
    void 결과_3개가_일치() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 6, 9, 10));
        LottoResult lottoResult = new LottoResult(lottoGame, lotto);
        assertThat(lottoResult.getMatch()).isEqualTo(3);
    }

    @Test
    @DisplayName("6개가 일치하는지 테스트")
    void 결과_6개가_일치() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7));
        LottoResult lottoResult = new LottoResult(lottoGame, lotto);
        assertThat(lottoResult.getMatch()).isEqualTo(6);
    }

    @Test
    @DisplayName("보너스 숫자 일치 확인 테스트")
    void 보너스_숫자_일치() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 8, 9, 10));
        LottoResult lottoResult = new LottoResult(lottoGame, lotto);
        assertTrue(lottoResult.hasBonusMatch());
    }
}