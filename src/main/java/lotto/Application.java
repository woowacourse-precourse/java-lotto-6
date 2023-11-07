package lotto;

import lotto.view.OutputView;

import lotto.controller.Shop;

public class Application {

    public static void main(String[] args) {
        try {
            Shop shop = Shop.visitShop();
            shop.buyLottos();
            shop.checkLottoResult();
        } catch (RuntimeException e) {
            OutputView.showErrorMessage(String.valueOf(e));
        }
    }
}
