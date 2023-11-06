package lotto.controller;

import lotto.exception.LottoNumberException;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class PurchaseAmount {
    private int purchaseAmount;
    private LottoNumberException lottoNumberException;

    public PurchaseAmount( ) {
        lottoNumberException = new LottoNumberException();
        purchaseAmount = 0;
    }

    public void input() {
        String userInput = readLine();

        purchaseAmount = Integer.parseInt(userInput);
    }
}
