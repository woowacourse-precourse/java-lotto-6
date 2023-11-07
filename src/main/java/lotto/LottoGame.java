package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import lotto.Input.InputType;

public class LottoGame {
    private static final int FIRST = 0;
    private static final int LOTTO_PRICE = 1000;
    private static final int ZERO = 0;
    private static final int FIVE_RANK = 5000;
    private static final int FOUR_RANK = 50000;
    private static final int THREE_RANK = 1500000;
    private static final int TWO_RANK = 30000000;
    private static final int ONE_RANK = 2000000000;
    private Input lottoInput = new Input();
    private List<Lotto> purchasedLotto;
    private final List<Integer> lottoAmountByRank;
    private Integer winningAmount;
    public LottoGame() {
        purchasedLotto = new ArrayList<>();
        winningAmount = ZERO;
        lottoAmountByRank = Arrays.asList(ZERO, ZERO, ZERO, FIVE_RANK, FOUR_RANK, THREE_RANK, ONE_RANK, TWO_RANK);
    }

    public void gameStart(){
        List<Integer> purchaseAmount;
        List<Integer> winningNumber;
        List<Integer> bonusNumber;

        purchaseAmount = lottoInput.input(InputType.PURCHASE_AMOUNT);
        buyLotto(purchaseAmount.get(FIRST));
        winningNumber = lottoInput.input(InputType.WINNING_NUMBERS);
        bonusNumber = lottoInput.input(InputType.BONUS_NUMBER);
        calcWinningAmount(winningNumber, bonusNumber.get(FIRST));
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

    public void calcWinningAmount(List<Integer> winningNumber, Integer bonusNumber){
        for (Lotto lotto : purchasedLotto){
            winningAmount += lottoAmountByRank.get(lotto.calcMatchNumber(winningNumber, bonusNumber));
        }
    }
}
