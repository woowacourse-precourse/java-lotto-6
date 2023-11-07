package lotto.serviceTest;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.Application;
import lotto.Service.PurchaseService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PurchaseServiceTest extends NsTest {
    PurchaseService purchaseService = new PurchaseService();
    @DisplayName("구입 금액에 따른 로또 구매 개수를 계산한다.")
    @Test
    public void 로또_구매_개수_계산() {
        // given
        int purchasePrice1 = 1000;
        int purchasePrice2 = 2000;
        int purchasePrice3 = 3000;

        // when
        int lottoCount1 = purchaseService.calculateLottoCount(purchasePrice1);
        int lottoCount2 = purchaseService.calculateLottoCount(purchasePrice2);
        int lottoCount3 = purchaseService.calculateLottoCount(purchasePrice3);

        // then
        Assertions.assertEquals(lottoCount1, 1);
        Assertions.assertEquals(lottoCount2, 2);
        Assertions.assertEquals(lottoCount3, 3);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
