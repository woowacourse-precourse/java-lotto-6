package lotto.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import lotto.domain.Lotto;
import lotto.dto.LottoStatistics;
import lotto.repository.LottoRepository;
import lotto.repository.LottoWinningRepository;
import lotto.util.TestLottoGenerator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoServiceTest {
    private static LottoService lottoService;

    @BeforeAll
    static void setUp(){
        lottoService = new LottoService(new TestLottoGenerator(List.of(1, 2, 3, 4, 5, 6)), new LottoRepository(), new LottoWinningRepository());
    }

    @Test
    @DisplayName("로또 구매를 정상적으로 하는지 테스트")
    void buyLottoTest(){
        int purchaseAmount = 2000;
        lottoService.buyLotto(purchaseAmount);

        List<Lotto> myLotto = lottoService.getMyLotto();

        assertEquals(2, myLotto.size());

    }

    @Test
    @DisplayName("로또 1등 당첨 테스트")
    void lottoFirstWinnerTest(){
        lottoService.buyLotto(1000);

        lottoService.saveWinningNumbers(List.of(1, 2, 3, 4, 5, 6));
        lottoService.saveBonusNumber(7);

        LottoStatistics lottoStatistics = lottoService.calcLotto();

        assertEquals(1, lottoStatistics.firstCount());
        assertEquals(0, lottoStatistics.secondCount());
        assertEquals(0, lottoStatistics.thirdCount());
        assertEquals(0, lottoStatistics.fourthCount());
        assertEquals(0, lottoStatistics.fifthCount());
    }

    @Test
    @DisplayName("로또 2등 당첨 테스트")
    void lottoSecondWinnerTest(){
        lottoService.buyLotto(1000);

        lottoService.saveWinningNumbers(List.of(1, 2, 3, 4, 5, 7));
        lottoService.saveBonusNumber(6);

        LottoStatistics lottoStatistics = lottoService.calcLotto();

        assertEquals(0, lottoStatistics.firstCount());
        assertEquals(1, lottoStatistics.secondCount());
        assertEquals(0, lottoStatistics.thirdCount());
        assertEquals(0, lottoStatistics.fourthCount());
        assertEquals(0, lottoStatistics.fifthCount());
    }

    @Test
    @DisplayName("로또 3등 당첨 테스트")
    void lottoThirdWinnerTest(){
        lottoService.buyLotto(1000);

        lottoService.saveWinningNumbers(List.of(1, 2, 3, 4, 5, 7));
        lottoService.saveBonusNumber(8);

        LottoStatistics lottoStatistics = lottoService.calcLotto();

        assertEquals(0, lottoStatistics.firstCount());
        assertEquals(0, lottoStatistics.secondCount());
        assertEquals(1, lottoStatistics.thirdCount());
        assertEquals(0, lottoStatistics.fourthCount());
        assertEquals(0, lottoStatistics.fifthCount());
    }

    @Test
    @DisplayName("로또 4등 당첨 테스트")
    void lottoFourthWinnerTest(){
        lottoService.buyLotto(1000);

        lottoService.saveWinningNumbers(List.of(1, 2, 3, 4, 10, 11));
        lottoService.saveBonusNumber(12);

        LottoStatistics lottoStatistics = lottoService.calcLotto();

        assertEquals(0, lottoStatistics.firstCount());
        assertEquals(0, lottoStatistics.secondCount());
        assertEquals(0, lottoStatistics.thirdCount());
        assertEquals(1, lottoStatistics.fourthCount());
        assertEquals(0, lottoStatistics.fifthCount());
    }

    @Test
    @DisplayName("로또 5등 당첨 테스트")
    void lottoFifthWinnerTest(){
        lottoService.buyLotto(1000);

        lottoService.saveWinningNumbers(List.of(1, 2, 3, 8, 9, 10));
        lottoService.saveBonusNumber(11);

        LottoStatistics lottoStatistics = lottoService.calcLotto();

        assertEquals(0, lottoStatistics.firstCount());
        assertEquals(0, lottoStatistics.secondCount());
        assertEquals(0, lottoStatistics.thirdCount());
        assertEquals(0, lottoStatistics.fourthCount());
        assertEquals(1, lottoStatistics.fifthCount());
    }
}