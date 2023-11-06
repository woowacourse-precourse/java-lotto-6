package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.Option.GameStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoResultTest {

    @DisplayName("서로 다른 LottoResult의 GameStatus가 같으면 같은 객체로 간주한다.")
    @Test
    void checkLottoResultEqual() {
        LottoResult lottoResult = new LottoResult(GameStatus.SIX_EQUAL);
        LottoResult lottoResult1 = new LottoResult(GameStatus.SIX_EQUAL);
        LottoResult lottoResult2 = new LottoResult(6, 0);

        assertThat(lottoResult).isEqualTo(lottoResult1);
        assertThat(lottoResult).isEqualTo(lottoResult2);
    }

    @DisplayName("총 합이 3일 때 LottoResult의 GameStatus를 THREE_EQUAL로 설정한다.")
    @Test
    void setGameStatusThreeEqual() {
        LottoResult lottoResult = new LottoResult(2, 1);
        lottoResult.setGameStatus();

        assertThat(lottoResult).isEqualTo(new LottoResult(GameStatus.THREE_EQUAL));
    }

    @DisplayName("총 합이 6이고, 보너스가 존재할 때"
            + "LottoResult의 GameStatus를 FIVE_AND_BONUS_EQUAL로 설정한다.")
    @Test
    void setGameStatusFiveEqualAndBonus() {
        LottoResult lottoResult = new LottoResult(5, 1);
        lottoResult.setGameStatus();

        assertThat(lottoResult).isEqualTo(new LottoResult(GameStatus.FIVE_AND_BONUS_EQUAL));
    }
}
