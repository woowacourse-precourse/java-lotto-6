package lotto.Service;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.Application;
import lotto.Domain.GameInfo;
import lotto.Domain.Lotto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;


class LottoServiceTest extends NsTest {

    private LottoService lottoService;

    @BeforeEach
    void createLottoService() {
        List<Lotto> sampleLottoTickets = createSampleLottoTickets();
        GameInfo sampleGameInfo = createSampleGameInfo();

        lottoService =  new LottoService(sampleLottoTickets, sampleGameInfo);
    }

    @DisplayName("로또 결과 계산 기능")
    @Test
    void getLottoResult() {
        // given
        // when
        int[] expectedResult = {0, 0, 0, 0, 1};
        // then
        assertArrayEquals(expectedResult, lottoService.calLottoResult());
    }

    @DisplayName("로또 수익률 계산 기능")
    @Test
    void calProfitMargin() {
        // given
        int[] lottoResult = lottoService.calLottoResult();
        // when
        double expectedResult = lottoService.calProfitMargin(lottoResult);
        // then
        assertEquals(expectedResult, 500.0);
    }
    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }

    List<Lotto> createSampleLottoTickets() {
        List<Lotto> sampleTickets = new ArrayList<>();
        Lotto sampleLotto = new Lotto(new ArrayList<>(Arrays.asList(1, 2, 3, 10, 11, 12)));

        sampleTickets.add(sampleLotto);

        return sampleTickets;
    }

    GameInfo createSampleGameInfo() {
        List<Integer> sampleWinnerNumber = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;
        int purchaseCost = 1000;
        return new GameInfo(sampleWinnerNumber, bonusNumber, purchaseCost);
    }
}