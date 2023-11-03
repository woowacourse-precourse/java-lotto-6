package lotto.service;

import static org.junit.jupiter.api.Assertions.*;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import lotto.domain.lotto.BonusNumber;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoTickets;
import lotto.domain.lotto.PurchasePrice;
import lotto.domain.lotto.WinningNumbers;
import lotto.domain.lottoresult.EarningRate;
import lotto.domain.lottoresult.LottoCheckResult;
import lotto.domain.lottoresult.LottoResultStatus;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;

class LottoCheckerTest {
    LottoChecker lottoChecker;

    @BeforeEach
    void setChecker() {
        lottoChecker = new LottoChecker();
    }

    @Test
    @DisplayName("로또들이 모두 일치하지 않는 경우")
    void testCheckFail() {
        //given
        LottoTickets lottoTickets = BDDMockito.mock(LottoTickets.class);

        List<Lotto> mockLottoList = new ArrayList<>();
        mockLottoList.add(new Lotto(Arrays.asList(1,2,3,4,5,6)));
        BDDMockito.given(lottoTickets.getLottoTickets()).willReturn(mockLottoList);

        WinningNumbers winningNumbers = WinningNumbers.create("7,8,9,10,11,12");
        BonusNumber bonusNumber = BonusNumber.create("13", winningNumbers);

        //when
        LottoCheckResult lottoCheckResult = lottoChecker.checkLottoTickets(lottoTickets, winningNumbers, bonusNumber);

        //then
        Map<LottoResultStatus, Integer> result = lottoCheckResult.getResult();

        Assertions.assertThat(result.get(LottoResultStatus.FAIL)).isEqualTo(1);
    }

    @Test
    @DisplayName("로또가 5개 일치하고, 보너스 번호가 일치하는 경우(2등)")
    void testCheckSecond() {
        //given
        LottoTickets lottoTickets = BDDMockito.mock(LottoTickets.class);

        List<Lotto> mockLottoList = new ArrayList<>();
        mockLottoList.add(new Lotto(Arrays.asList(1,2,3,4,5,6)));
        BDDMockito.given(lottoTickets.getLottoTickets()).willReturn(mockLottoList);

        WinningNumbers winningNumbers = WinningNumbers.create("1,2,3,4,5,7");
        BonusNumber bonusNumber = BonusNumber.create("6", winningNumbers);

        //when
        LottoCheckResult lottoCheckResult = lottoChecker.checkLottoTickets(lottoTickets, winningNumbers, bonusNumber);

        //then
        Map<LottoResultStatus, Integer> result = lottoCheckResult.getResult();
        Assertions.assertThat(result.get(LottoResultStatus.FIVE_MATCH_WITH_BONUS)).isEqualTo(1);
    }

    @Test
    @DisplayName("로또가 6개 일치하는 경우(1등)")
    void testFirst() {
        //given
        LottoTickets lottoTickets = BDDMockito.mock(LottoTickets.class);

        List<Lotto> mockLottoList = new ArrayList<>();
        mockLottoList.add(new Lotto(Arrays.asList(1,2,3,4,5,6)));
        BDDMockito.given(lottoTickets.getLottoTickets()).willReturn(mockLottoList);

        WinningNumbers winningNumbers = WinningNumbers.create("1,2,3,4,5,6");
        BonusNumber bonusNumber = BonusNumber.create("7", winningNumbers);

        //when
        LottoCheckResult lottoCheckResult = lottoChecker.checkLottoTickets(lottoTickets, winningNumbers, bonusNumber);

        //then
        Map<LottoResultStatus, Integer> result = lottoCheckResult.getResult();
        Assertions.assertThat(result.get(LottoResultStatus.ALL_MATCH)).isEqualTo(1);
    }

    @Test
    @DisplayName("7장 중 3장이 5등에 당첨되면 수익률은 214.3%")
    void testCalcEarningRate() {
        //given
        LottoCheckResult result = new LottoCheckResult();
        result.updateResult(LottoResultStatus.FAIL);
        result.updateResult(LottoResultStatus.FAIL);
        result.updateResult(LottoResultStatus.FAIL);
        result.updateResult(LottoResultStatus.FAIL);
        result.updateResult(LottoResultStatus.THREE_MATCH);
        result.updateResult(LottoResultStatus.THREE_MATCH);
        result.updateResult(LottoResultStatus.THREE_MATCH);

        //when
        EarningRate earningRate = lottoChecker.calculateEarningRate(result);

        //then
        double rate = Math.round(earningRate.getRate()*10.0)/10.0;
        Assertions.assertThat(rate).isEqualTo(214.3);
    }
}