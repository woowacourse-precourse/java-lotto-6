package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class GameResultTest {

    @ParameterizedTest
    @DisplayName("플레이어의 로또와 당첨 로또와 비교해 당첨금과 수익률을 정확하게 계산하는지 확인한다.")
    @MethodSource("generateLottoData")
    void calculateLottoResultTest(List<Lotto> playerLotto,
                                  Lotto winningNumber,
                                  int bonusNumber,
                                  long winningMoney,
                                  String yield) {

        WinningLottoNumber winningLottoNumber = WinningLottoNumber.of(winningNumber, bonusNumber);
        GameResult gameResult = GameResult.of(playerLotto, winningLottoNumber);

        gameResult.calculateLottoRankResult();

        long winMoney = gameResult.calculateWinningMoney();
        int purchaseAmount = playerLotto.size() * 1000;

        assertThat(winMoney).isEqualTo(winningMoney);
        assertThat(gameResult.calculateYield(winMoney, purchaseAmount)).isEqualTo(yield);
    }


    static Stream<Arguments> generateLottoData() {
        return Stream.of(
                Arguments.of(List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)))
                        , new Lotto(List.of(1, 2, 3, 4, 5, 6))
                        , 7
                        , 2_000_000_000
                        , "200000000.0"),
                Arguments.of(List.of(new Lotto(List.of(1, 2, 3, 4, 5, 7)))
                        , new Lotto(List.of(1, 2, 3, 4, 5, 6))
                        , 7
                        , 30_000_000
                        , "3000000.0"),
                Arguments.of(List.of(new Lotto(List.of(1, 2, 3, 10, 11, 12)), new Lotto(List.of(1, 2, 3, 4, 10, 11)))
                        , new Lotto(List.of(1, 2, 3, 4, 5, 6))
                        , 7
                        , 55_000
                        , "2750.0")
        );
    }
}