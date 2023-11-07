package lotto.lottoGame;

import lotto.Lotto;
import lotto.WinningLotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoComparatorTest {
    LottoComparator lottoComparator;
    LottoInputGenerator lottoInputGenerator;

    @BeforeEach
    void setup() {
        this.lottoComparator = new LottoComparator();
        this.lottoInputGenerator = new LottoInputGenerator();
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2,3,4,5,6:7:1,2,3,4,5,6:2000000000",
        "1,2,3,4,5,6:7:1,2,3,4,5,7:30000000",
        "1,2,3,4,5,6:7:1,2,3,4,5,8:1500000",
        "1,2,3,4,5,6:7:1,2,3,4,7,8:50000",
        "1,2,3,4,5,6:7:1,2,3,10,11,12:5000",
        "1,2,3,4,5,6:7:1,2,13,10,11,12:0",
        "1,2,3,4,5,6:7:1,12,13,10,21,22:0",
        "1,2,3,4,5,6:7:11,12,13,10,21,22:0"}, delimiter = ':')
    @DisplayName("1,2,3,4,5등을 잘 판별하는가.")
    void 모든_결과_확인_비교(String winningNumbers, String bonus, String lotto, String prizeString) {
        WinningLotto winningLotto = new WinningLotto(
            lottoInputGenerator.inputNumbersToLotto(winningNumbers)
            , lottoInputGenerator.inputBonusToValidatedValue(bonus)
        );

        Lotto lottoPaper = lottoInputGenerator.inputNumbersToLotto(lotto);
        int prize = Integer.parseInt(prizeString);


    }
}