package lotto.Service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import lotto.dto.LottoResults;
import lotto.model.PurchasePrice;
import lotto.view.output.OutputView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BuyLottoServiceTest {
    private final OutputView outputView;
    private final BuyLottoService buyLottoService;

    BuyLottoServiceTest() {
        outputView = new OutputView();
        buyLottoService = new BuyLottoService(outputView);
    }

    @DisplayName("로또 구매 로직")
    @Test
    void buyLottoTest() {
        //given
        PurchasePrice purchasePrice = new PurchasePrice(8000);
        //when
        LottoResults lottoResults = buyLottoService.buyLotto(purchasePrice);
        //then
        assertEquals(lottoResults.getLottos().size(), 8);
    }
}