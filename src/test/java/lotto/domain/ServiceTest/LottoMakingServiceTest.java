package lotto.domain.ServiceTest;

import lotto.domain.Model.Lotto;
import lotto.domain.Model.LottoContainer;
import lotto.domain.Service.LottoMakingService;
import lotto.domain.Utility.Constant;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LottoMakingServiceTest {
    @DisplayName("정확한 숫자의 로또 개수를 가진 컨테이너를 생성한다.")
    @Test
    void createLottoContainerHavingCorrectNumbersOfPapers() {
        LottoMakingService lottoMakingService = new LottoMakingService();
        int cash = 10000;
        LottoContainer lottoContainer = lottoMakingService.issue(cash);

        assertEquals(lottoContainer.getLottos().size(), cash / Constant.LOTTO_PRICE);
    }

    @DisplayName("정확한 숫자의 로또 개수를 가진 컨테이너를 생성한다.")
    @Test
    void createLottoPaperHavingUniqueSortedNumbersInRange() {
        LottoMakingService lottoMakingService = new LottoMakingService();

        Lotto lotto = lottoMakingService.issueLottoPaper();

        assertEquals(lotto.getNumbers().size(), Constant.LOTTO_PICK_NUMBER);
        assertEquals(Constant.LOTTO_PICK_NUMBER, lotto.getNumbers().stream().distinct().count());
        assertTrue(lotto.getNumbers().stream().allMatch(num ->
                num >= Constant.LOTTO_START_NUMBER && num <= Constant.LOTTO_END_NUMBER));
    }
}
