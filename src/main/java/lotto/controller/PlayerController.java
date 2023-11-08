package lotto.controller;

import java.util.List;
import lotto.model.player.BonusNumber;
import lotto.model.player.BuyLotto;
import lotto.model.player.WinningNumber;
import lotto.view.LottoInputView;

public class PlayerController {
    public Integer purchaseController() {
        BuyLotto buyLotto = null;
        boolean ispurchased = false;
        while(!ispurchased) {
            try {
                buyLotto = new BuyLotto(LottoInputView.readPurchaseAmount());
                ispurchased = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return buyLotto.getLottoPurchase();
    }

    public List<Integer> winningNumberController() {
        WinningNumber winningNumber = null;
        boolean ispurchased = false;
        while(!ispurchased) {
            try {
                winningNumber = new WinningNumber(LottoInputView.readWinningNumber());
                ispurchased = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return winningNumber.getWinningNumber();
    }

    public Integer bonusNumberController(List<Integer> winningNumber) {
        BonusNumber bonusNumber = null;
        boolean ispurchased = false;
        while(!ispurchased) {
            try {
                bonusNumber = new BonusNumber(winningNumber, LottoInputView.readBonusNumber());
                ispurchased = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return bonusNumber.getBonusNumber();
    }
}
