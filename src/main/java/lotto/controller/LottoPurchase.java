package lotto.controller;

import lotto.exception.LottoNumberException;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class LottoPurchase {
    private int purchaseAmount;
    private LottoNumberException lottoNumberException;

    public LottoPurchase( ) {
        lottoNumberException = new LottoNumberException();
        purchaseAmount = 0;
    }

    public void inputAmount() {
        String userInput = readLine();

        purchaseAmount = Integer.parseInt(userInput);
    }
}
