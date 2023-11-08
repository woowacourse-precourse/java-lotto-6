package lotto.model;

public class Customer {

    Lottos lottos;

    public Customer() {
    }

    public void buyLottos(int purchaseAmount) {
        lottos = new Lottos(purchaseAmount/1000);
    }

    public Lottos getLottos() {
        return lottos;
    }
}
