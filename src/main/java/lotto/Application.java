package lotto;

import lotto.system.shop.domain.LottoShop;
import lotto.system.shop.domain.LottoShopOwner;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LottoShopOwner owner = new LottoShopOwner();
        LottoShop shop = LottoShop.open(owner);
        shop.operate();
    }
}
