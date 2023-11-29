package lotto.service;

import lotto.model.LottoNumbers;
import lotto.model.PurchasePrice;
import lotto.view.output.OutputView;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BuyLottoServiceTest {
    private final BuyLottoService buyLottoService;

    BuyLottoServiceTest() {
        buyLottoService = new BuyLottoService(new OutputView());
    }

    @DisplayName("로또 구입 비즈니스 로직 테스트")
    @ParameterizedTest
    @ValueSource(ints = {7000, 8000, 20000})
    void buyLotto_Test(int input) {
        //given
        PurchasePrice purchasePrice = PurchasePrice.createPurchasePrice(input);
        //when
        LottoNumbers lottoNumbers = buyLottoService.buyLotto(purchasePrice);

        //then
        Assertions.assertEquals(input / 1000, lottoNumbers.getNumbers().size());
    }

}