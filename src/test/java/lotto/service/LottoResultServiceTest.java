package lotto.service;

import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.LottoResult;
import lotto.model.WinningNumbers;
import lotto.model.collections.LottoBundle;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.constant.RankCategory.*;
import static org.junit.jupiter.api.Assertions.*;

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
    void calculateResults_6개_일치_FIRST() {
        WinningNumbers winningNumbers = new WinningNumbers(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = new BonusNumber(30);

        LottoResult lottoResult = lottoResultService.calculateResults(lottoBundle, winningNumbers, bonusNumber);
        Assertions.assertEquals(1, lottoResult.getResults().get(FIRST));
    }

    @Test
    void calculateResults_5개_일치_보너스_일치_SECOND() {
        WinningNumbers winningNumbers = new WinningNumbers(List.of(1, 2, 3, 4, 5, 10));
        BonusNumber bonusNumber = new BonusNumber(6);

        LottoResult lottoResult = lottoResultService.calculateResults(lottoBundle, winningNumbers, bonusNumber);
        Assertions.assertEquals(1, lottoResult.getResults().get(SECOND));
    }

    @Test
    void calculateResults_5개_일치_보너스_불일치_THIRD() {
        WinningNumbers winningNumbers = new WinningNumbers(List.of(1, 2, 3, 4, 5, 10));
        BonusNumber bonusNumber = new BonusNumber(30);

        LottoResult lottoResult = lottoResultService.calculateResults(lottoBundle, winningNumbers, bonusNumber);
        Assertions.assertEquals(1, lottoResult.getResults().get(THIRD));
    }

    @Test
    void calculateResults_4개_일치_보너스_일치_FOURTH() {
        WinningNumbers winningNumbers = new WinningNumbers(List.of(1, 2, 3, 4, 20, 40));
        BonusNumber bonusNumber = new BonusNumber(6);

        LottoResult lottoResult = lottoResultService.calculateResults(lottoBundle, winningNumbers, bonusNumber);
        Assertions.assertEquals(1, lottoResult.getResults().get(FOURTH));
    }

    @Test
    void calculateResults_4개_일치_보너스_불일치_FOURTH() {
        WinningNumbers winningNumbers = new WinningNumbers(List.of(1, 2, 3, 4, 20, 40));
        BonusNumber bonusNumber = new BonusNumber(30);

        LottoResult lottoResult = lottoResultService.calculateResults(lottoBundle, winningNumbers, bonusNumber);
        Assertions.assertEquals(1, lottoResult.getResults().get(FOURTH));
    }

    @Test
    void calculateResults_일치_없음_NONE() {
        WinningNumbers winningNumbers = new WinningNumbers(List.of(11, 12, 13, 14, 15, 16));
        BonusNumber bonusNumber = new BonusNumber(30);

        LottoResult lottoResult = lottoResultService.calculateResults(lottoBundle, winningNumbers, bonusNumber);
        Assertions.assertEquals(1, lottoResult.getResults().get(NONE));
    }

    @Test
    void hasBonusState_보너스_넘버가_있으면_참() {
        BonusNumber bonusNumber = new BonusNumber(1);
        assertTrue(lottoResultService.hasBonusState(lotto, bonusNumber));
    }

    @Test
    void hasBonusState_보너스_넘버가_없으면_거짓() {
        BonusNumber bonusNumber = new BonusNumber(10);
        assertFalse(lottoResultService.hasBonusState(lotto, bonusNumber));
    }

    @Test
    void getMatchCount_로또_하나씩_정답과_비교한다() {
        WinningNumbers winningNumbers = new WinningNumbers(List.of(1, 2, 3, 4, 10, 11));
        Assertions.assertEquals(lottoResultService.getMatchCount(lotto, winningNumbers)
                , 4);
    }
}