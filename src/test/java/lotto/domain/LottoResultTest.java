package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import lotto.Option.GameStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

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

    @DisplayName("LottoResult의 GameStatus를 주어진 수에 맞게 설정하는지 확인한다.")
    @ParameterizedTest
    @MethodSource("validParameters")
    void setGameStatusByEqual(int equalCount, int bonusCount, GameStatus gameStatus) {
        LottoResult lottoResult = new LottoResult(equalCount, bonusCount);
        lottoResult.setGameStatus();

        assertThat(lottoResult).isEqualTo(new LottoResult(gameStatus));
    }

    static Stream<Arguments> validParameters() {
        return Stream.of(
                Arguments.of(2, 1, GameStatus.THREE_EQUAL),
                Arguments.of(5, 1, GameStatus.FIVE_AND_BONUS_EQUAL)
        );
    }
}
