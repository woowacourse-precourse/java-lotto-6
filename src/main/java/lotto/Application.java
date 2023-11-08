package lotto;

import lotto.domain.Seller;

public class Application {
    public static void main(String[] args) {
        Seller seller = new Seller();
        seller.buy();
        seller.draw();
        seller.check();
    }
}
