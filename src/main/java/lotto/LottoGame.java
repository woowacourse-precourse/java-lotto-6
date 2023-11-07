package lotto;

import java.util.ArrayList;
import java.util.List;
import lotto.Input.InputType;

public class LottoGame {
    private static final int FIRST = 0;
    private Input lottoInput = new Input();
    private List<Integer> purchaseAmount;
    private List<Lotto> purchasedLotto;

    public LottoGame() {
        purchasedLotto = new ArrayList<>();
    }

    public void gameStart(){
        purchaseAmount = lottoInput.input(InputType.PURCHASE_AMOUNT);
        buyLotto(purchaseAmount.get(FIRST));
    }

    public void buyLotto(Integer purchaseAmount){
        Print.printPurchase(purchaseAmount);
        for (int i = 0; i < purchaseAmount % 1000; i++){
            purchasedLotto.add(new Lotto(Utils.makeRandomNumbers(1, 45, 6)));
        }
        Print.printPurchasedLotto(purchasedLotto);
    }
}
