package lotto.domain.lottoWinning;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.domain.lotto.Lotto;
import lotto.domain.lottoResult.LottoResultStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class LottoWinningTest {
    @DisplayName("당첨 번호와 발행한 로또 번호의 결과 상태를 반환한다.")
    @ParameterizedTest
    @CsvSource({"1,8,9,10,11,12,1", "1,2,8,9,10,11,2", "1,2,3,8,9,10,3", "1,2,3,4,8,9,4", "1,2,3,4,5,8,5",
            "1,2,3,4,5,7,7", "1,2,3,4,5,6,6"})
    void calculateLottoResultStatus(int lotto1, int lotto2, int lotto3, int lotto4, int lotto5, int lotto6,
                                    int expectedCount) {
        WinningNumbers winningNumbers = WinningNumbers.from(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = BonusNumber.of(7, winningNumbers);
        LottoWinning lottoWinning = new LottoWinning(winningNumbers, bonusNumber);
        Lotto lotto = new Lotto(List.of(lotto1, lotto2, lotto3, lotto4, lotto5, lotto6));

        LottoResultStatus actual = lottoWinning.calculateLottoResultStatus(lotto);
        assertThat(actual).isEqualTo(LottoResultStatus.from(expectedCount));
    }
}
