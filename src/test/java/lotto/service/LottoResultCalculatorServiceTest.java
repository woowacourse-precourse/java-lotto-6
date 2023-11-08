package lotto.service;

import static lotto.testutils.LottoCreator.createLotto;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.LottoRank;
import lotto.domain.LottoResult;
import lotto.domain.WinningNumbers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("로또 등수 리스트 테스트")
class LottoResultCalculatorServiceTest {
    private LottoResultCalculatorService lottoResultCalculatorService;

    @BeforeEach
    void setUp() {
        lottoResultCalculatorService = new LottoResultCalculatorService();
    }

    @DisplayName("로또 리스트를 전달해서 결과를 반환받는다")
    @Test
    void testLottoRankList() {
        Lotto winningLotto = createLotto(List.of(1, 2, 3, 4, 5, 6));
        LottoNumber bonusNumber = LottoNumber.from(15);
        WinningNumbers winningNumbers = WinningNumbers.of(winningLotto, bonusNumber);

        Lotto issuedLotto1 = createLotto(List.of(1, 2, 3, 4, 5, 6)); //1등
        List<Lotto> lottos = List.of(issuedLotto1);
        LottoResult result = lottoResultCalculatorService.calculateResult(lottos, winningNumbers);

        assertThat(result.getCountByRank(LottoRank.FIRST)).isEqualTo(1);
    }
}