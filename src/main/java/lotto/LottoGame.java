package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.Input.InputType;

public class LottoGame {
    private static final int FIRST = 0;
    private static final int LOTTO_PRICE = 1000;
    private Input lottoInput = new Input();
    private List<Lotto> purchasedLotto;

    public LottoGame() {
        purchasedLotto = new ArrayList<>();
    }

    public void gameStart(){
        List<Integer> purchaseAmount;
        List<Integer> winningNumber;
        List<Integer> bonusNumber;

        purchaseAmount = lottoInput.input(InputType.PURCHASE_AMOUNT);
        buyLotto(purchaseAmount.get(FIRST));
        winningNumber = lottoInput.input(InputType.WINNING_NUMBERS);
        bonusNumber = lottoInput.input(InputType.BONUS_NUMBER);

    }

    public void buyLotto(Integer purchaseAmount){
        Print.printPurchase(purchaseAmount);
        for (int i = 0; i < purchaseAmount / LOTTO_PRICE; i++){
            List<Integer> makedNumbers = Utils.makeRandomNumbers(1, 45, 6);
            Collections.sort(makedNumbers);
            purchasedLotto.add(new Lotto(makedNumbers));
        }
        Print.printPurchasedLotto(purchasedLotto);
    }
}
