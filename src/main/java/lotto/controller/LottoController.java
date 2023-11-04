package lotto.controller;

import java.util.ArrayList;

import static lotto.domain.UserInput.*;

public class LottoController {

    public void run() {
        int purchaseAmount = inputPurchaseAmount();

        ArrayList<Integer> winningNumbers = inputWinningNumber();

        int bonusNumber = inputBonusNumber(winningNumbers);

        System.out.println("구매 가격 : " + purchaseAmount + " 구매 번호 : " + winningNumbers + " 보너스 번호 : " + bonusNumber);
    }

}
