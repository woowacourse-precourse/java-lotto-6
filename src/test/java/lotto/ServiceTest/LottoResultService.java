package lotto.ServiceTest;

import java.util.List;
import lotto.Model.BonusNumber.BonusNumber;
import lotto.Model.Lotto.Lotto;
import lotto.Model.LottoSet.LottoSet;
import lotto.Model.WinningNumber.WinningNumber;
import lotto.Service.LottoTicketService.LottoTicketService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LottoResultService {
    private LottoResultService lottoResultService;
    private WinningNumber winningNumber;

    private LottoTicketService lottoTicketService;
    private LottoSet lottoSet;
    private Lotto lotto;

    @BeforeEach
    void setUp() {
        lottoResultService = new LottoResultService();
        lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        LottoSet lottoSet = new LottoTicketService();
    }
    @Test
    void calculateResults_6개_일치_FIRST() {
          = new WinningNumbers(List.of(1, 2, 3, 4, 5, 6));
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

}
