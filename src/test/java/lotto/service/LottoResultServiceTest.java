package lotto.service;

import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.LottoResult;
import lotto.model.WinningNumbers;
import lotto.model.LottoBundle;
import lotto.service.lotto.LottoResultService;
import org.junit.jupiter.api.*;

import java.util.List;

import static lotto.constant.RankCategory.*;

@Nested
@DisplayName("당첨 통계를 테스트")
class LottoResultServiceTest {

    private LottoResultService lottoResultService;
    private LottoBundle lottoBundle;
    private Lotto lotto;

    @BeforeEach
    void setUp() {
        lottoResultService = new LottoResultService();
        lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        lottoBundle = new LottoBundle(List.of(lotto));
    }

    @Test
    @DisplayName("6개가 일치하면 1등이다.")
    void test1() {
        WinningNumbers winningNumbers = new WinningNumbers(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = new BonusNumber(30);
        LottoResult lottoResult = lottoResultService.calculateResults(lottoBundle, winningNumbers, bonusNumber);
        Assertions.assertEquals(1, lottoResult.getResults().get(FIRST));
    }

    @Test
    @DisplayName("5개가 일치하고, 보너스 번호가 일치하면 2등이다.")
    void test2() {
        WinningNumbers winningNumbers = new WinningNumbers(List.of(1, 2, 3, 4, 5, 10));
        BonusNumber bonusNumber = new BonusNumber(6);
        LottoResult lottoResult = lottoResultService.calculateResults(lottoBundle, winningNumbers, bonusNumber);
        Assertions.assertEquals(1, lottoResult.getResults().get(SECOND));
    }

    @Test
    @DisplayName("5개가 일치하고, 보너스 번호가 일치하지 않으면 3등이다.")
    void test3() {
        WinningNumbers winningNumbers = new WinningNumbers(List.of(1, 2, 3, 4, 5, 10));
        BonusNumber bonusNumber = new BonusNumber(30);
        LottoResult lottoResult = lottoResultService.calculateResults(lottoBundle, winningNumbers, bonusNumber);
        Assertions.assertEquals(1, lottoResult.getResults().get(THIRD));
    }

    @Test
    @DisplayName("4개가 일치하고, 보너스 번호가 일치하면 4등이다.")
    void test4() {
        WinningNumbers winningNumbers = new WinningNumbers(List.of(1, 2, 3, 4, 20, 40));
        BonusNumber bonusNumber = new BonusNumber(6);
        LottoResult lottoResult = lottoResultService.calculateResults(lottoBundle, winningNumbers, bonusNumber);
        Assertions.assertEquals(1, lottoResult.getResults().get(FOURTH));
    }

    @Test
    @DisplayName("4개가 일치하고, 보너스 번호가 일치하지 않으면 4등이다.")
    void test5() {
        WinningNumbers winningNumbers = new WinningNumbers(List.of(1, 2, 3, 4, 20, 40));
        BonusNumber bonusNumber = new BonusNumber(30);
        LottoResult lottoResult = lottoResultService.calculateResults(lottoBundle, winningNumbers, bonusNumber);
        Assertions.assertEquals(1, lottoResult.getResults().get(FOURTH));
    }

    @Test
    @DisplayName("일치하는 번호가 없으면 반환 값이 없다.")
    void test6() {
        WinningNumbers winningNumbers = new WinningNumbers(List.of(11, 12, 13, 14, 15, 16));
        BonusNumber bonusNumber = new BonusNumber(30);
        LottoResult lottoResult = lottoResultService.calculateResults(lottoBundle, winningNumbers, bonusNumber);
        Assertions.assertEquals(1, lottoResult.getResults().get(NONE));
    }
}