package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WinningResultTest {

    private WinningNumber winningNumber;
    private WinningResult winningResult;

    @BeforeEach
    public void setUp() {
        lottoNumbers = LottoNumbers.validate(3000);
        Lotto numbers = Lotto.validate(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;
        winningNumber = WinningNumber.validate(numbers, bonusNumber);
        winningResult = new WinningResult(lottoNumbers);
    }

    @DisplayName("로또 당첨 결과를 반환한다.")
    @CsvSource({"1, FIRST", "1, SECOND", "0, THIRD", "0, FOURTH", "1, FIFTH", "0, NOTHING"})
    @ParameterizedTest
    void printWinningResults(int expectedCount, Rank rank) {
        // given
        List<Lotto> drawnLottos = List.of(
                Lotto.validate(List.of(1, 2, 3, 4, 5, 6)),
                Lotto.validate(List.of(1, 2, 3, 4, 5, 7)),
                Lotto.validate(List.of(18, 1, 20, 2, 22, 3))
        );

        // when
        NumberOfRanks result = winningResult.getWinningResult(drawnLottos, winningNumber);

        // then
        assertEquals(expectedCount, result.getRankCount(rank));
    }

}
