package lotto.domain;

import java.util.List;

import lotto.global.helper.SellerHelper;
import lotto.view.Input;
import lotto.view.Print;

public class Seller {
    private List<Lotto> lottos;
    private Integer purchaseAmount;

    public void buy() {
        Print.getAmount();
        purchaseAmount = Input.getPurchaseAmount();

        lottos = SellerHelper.buyLottos(purchaseAmount / LottoCondition.MONEY_UNIT);
    }
}
