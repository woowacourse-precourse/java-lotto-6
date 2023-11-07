package lotto.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import java.util.List;

public class LottoResultTest {

    private User user;
    private WinningNumber winningNumber;
    private LottoResult lottoResult;

    @BeforeEach
    public void setUp() {
        user = User.from(3000);
        Lotto numbers = Lotto.from(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;
        winningNumber = WinningNumber.from(numbers, bonusNumber);
        lottoResult = new LottoResult(user, winningNumber);
    }

    @DisplayName("사용자의 로또 당첨 결과를 산출한다.")
    @ParameterizedTest
    @CsvSource({"1, FIRST", "1, SECOND", "0, THIRD", "0, FOURTH", "1, FIFTH", "0, NO_RANK"})
    void 당첨_결과_산출(int expectedCount, Rank rank) {
        // given
        List<Lotto> purchasedLottos = List.of(
                Lotto.from(List.of(1, 2, 3, 4, 5, 6)),
                Lotto.from(List.of(1, 2, 3, 4, 5, 7)),
                Lotto.from(List.of(18, 1, 20, 2, 22, 3))
        );

        // when
        RankCounter result = lottoResult.getLottoResult(purchasedLottos, winningNumber);

        // then
        assertEquals(expectedCount, result.getRankCount(rank));
    }

    @DisplayName("사용자의 수익률을 산출한다.")
    @Test
    void 수익률_산출() {
        // given
        List<Lotto> purchasedLottos = List.of(
                Lotto.from(List.of(1, 2, 3, 4, 5, 8)),
                Lotto.from(List.of(10, 21, 31, 41, 35, 37)),
                Lotto.from(List.of(18, 31, 20, 32, 22, 33))
        );
        lottoResult.getLottoResult(purchasedLottos, winningNumber);

        // when
        double yield = lottoResult.getYield();

        // then
        assertEquals(50000, yield);
    }
}
