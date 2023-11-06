package lotto;

import org.junit.jupiter.api.Test;

public class LottoShopTest {

    @Test
    void compareWinLottoTest() {

        Customer customer = new Customer("5000");
        WinLotto winLotto = new WinLotto("1,2,3,4,5,6");
        winLotto.setBonusNumber("7");
        LottoShop lottoShop = new LottoShop(customer, winLotto);

        lottoShop.compareWinLotto();
    }
}
