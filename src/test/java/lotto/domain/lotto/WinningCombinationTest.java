package lotto.domain.lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class WinningCombinationTest {
    private WinningCombination winningCombination;
    private Lotto purchasedLotto;

    @BeforeEach
    void setUp() {
        Lotto winningNumbers = Lotto.from(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = BonusNumber.from(7);
        winningCombination = WinningCombination.of(winningNumbers, bonusNumber);
    }

    @DisplayName("당첨 번호 및 보너스 번호와 구입한 로또를 비교하여 로또 당첨 순위 계산")
    @ParameterizedTest
    @CsvSource({"3, false, 5_000, FIFTH"})
    void should_Calculate_LottoRank(
            int matchCount,
            boolean hasBonusNumber,
            long prize,
            LottoRank expectedLottoRank
    ) {
        purchasedLotto = Lotto.from(List.of(1, 2, 3, 9, 10, 11));
        LottoRank lottoRank = winningCombination.getLottoRankFrom(purchasedLotto);
        assertThat(lottoRank).isEqualTo(expectedLottoRank);
    }


}