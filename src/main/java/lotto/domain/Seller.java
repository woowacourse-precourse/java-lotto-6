package lotto.domain;

import java.util.List;

import lotto.global.helper.SellerHelper;
import lotto.view.Input;
import lotto.view.Print;

public class Seller {
    private List<Lotto> lottos;
    private Lotto win;
    private Integer purchaseAmount;

    public void buy() {
        Print.getAmount();
        purchaseAmount = Input.getPurchaseAmount();

        lottos = SellerHelper.buyLottos(purchaseAmount / LottoCondition.MONEY_UNIT);
        Print.purchase(purchaseAmount, lottos);
    }

    public void draw() {
        Print.getWinNumbers();
        win = Input.getWinNumbers();
    }
}
